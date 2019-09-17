package ir.shayandaneshvar.recipeapp.converters;

import ir.shayandaneshvar.recipeapp.commands.UnitOfMeasureCommand;
import ir.shayandaneshvar.recipeapp.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {
//        return null;
        throw new UnsupportedOperationException();
    }
}
