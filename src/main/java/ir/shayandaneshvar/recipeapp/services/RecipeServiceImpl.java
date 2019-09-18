package ir.shayandaneshvar.recipeapp.services;

import ir.shayandaneshvar.recipeapp.commands.RecipeCommand;
import ir.shayandaneshvar.recipeapp.converters.RecipeCommandToRecipe;
import ir.shayandaneshvar.recipeapp.converters.RecipeToRecipeCommand;
import ir.shayandaneshvar.recipeapp.domain.Recipe;
import ir.shayandaneshvar.recipeapp.exceptions.NotFoundException;
import ir.shayandaneshvar.recipeapp.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("In Service");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long l) {
        Optional<Recipe> recipe = recipeRepository.findById(l);
        if (recipe.isEmpty()) {
            throw new NotFoundException("Recipe Not Found. For ID value: " + l);
        }
        return recipe.get();
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);
        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("saved recipeID:" + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long l) {
        return recipeToRecipeCommand.convert(findById(l));
    }
}
