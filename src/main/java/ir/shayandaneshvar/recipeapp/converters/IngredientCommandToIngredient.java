package ir.shayandaneshvar.recipeapp.converters;

import ir.shayandaneshvar.recipeapp.commands.IngredientCommand;
import ir.shayandaneshvar.recipeapp.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
    @Override
    public Ingredient convert(IngredientCommand ingredientCommand) {
        throw new UnsupportedOperationException();
    }
}
