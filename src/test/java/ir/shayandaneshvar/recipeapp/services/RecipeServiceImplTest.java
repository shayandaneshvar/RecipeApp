package ir.shayandaneshvar.recipeapp.services;

import ir.shayandaneshvar.recipeapp.converters.RecipeCommandToRecipe;
import ir.shayandaneshvar.recipeapp.converters.RecipeToRecipeCommand;
import ir.shayandaneshvar.recipeapp.domain.Recipe;
import ir.shayandaneshvar.recipeapp.exceptions.NotFoundException;
import ir.shayandaneshvar.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;
    RecipeToRecipeCommand recipeToRecipeCommand;
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository,
                recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test(expected = NotFoundException.class)
    public void getRecipeByIdNotFoundException() {
        Optional<Recipe> recipe = Optional.empty();
        when(recipeRepository.findById(anyLong())).thenReturn(recipe);
        Recipe recipeReturned = recipeService.findById(1L);
    }


    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);
        when(recipeRepository.findAll()).thenReturn(recipeData);
        Set<Recipe> recipes = recipeService.getRecipes();

        verify(recipeRepository, times(1)).findAll();
    }
}