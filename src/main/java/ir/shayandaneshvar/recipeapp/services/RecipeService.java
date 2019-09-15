package ir.shayandaneshvar.recipeapp.services;

import ir.shayandaneshvar.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
