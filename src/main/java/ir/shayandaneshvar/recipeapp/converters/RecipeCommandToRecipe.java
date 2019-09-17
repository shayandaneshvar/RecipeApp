package ir.shayandaneshvar.recipeapp.converters;

import ir.shayandaneshvar.recipeapp.commands.RecipeCommand;
import ir.shayandaneshvar.recipeapp.domain.Recipe;
import lombok.AllArgsConstructor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
    private final CategoryCommandToCategory categoryCommandToCategory;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final NotesCommandToNotes notesCommandToNotes;

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source == null) {
            return null;
        }
        final Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setCookTime(source.getCookTime());
        // ........
        if (source.getCategories() != null && source.getCategories().size() >
                0) {
            source.getCategories().forEach(c -> recipe.getCategories().add(
                    categoryCommandToCategory.convert(c)));
        }
        //..
        return recipe;
    }
}
