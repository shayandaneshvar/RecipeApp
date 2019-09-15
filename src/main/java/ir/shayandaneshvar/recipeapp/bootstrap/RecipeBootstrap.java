package ir.shayandaneshvar.recipeapp.bootstrap;

import ir.shayandaneshvar.recipeapp.domain.Recipe;
import ir.shayandaneshvar.recipeapp.repositories.CategoryRepository;
import ir.shayandaneshvar.recipeapp.repositories.RecipeRepository;
import ir.shayandaneshvar.recipeapp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository,
                           RecipeRepository recipeRepository,
                           UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        //prepare some recipes
        return recipes;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("loading Bootstrap data");
        recipeRepository.saveAll(getRecipes());
    }
}
