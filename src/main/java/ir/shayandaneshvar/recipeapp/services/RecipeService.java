package ir.shayandaneshvar.recipeapp.services;

import ir.shayandaneshvar.recipeapp.commands.RecipeCommand;
import ir.shayandaneshvar.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long l);
}
