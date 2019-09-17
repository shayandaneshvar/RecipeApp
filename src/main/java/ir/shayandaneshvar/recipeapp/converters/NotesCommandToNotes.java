package ir.shayandaneshvar.recipeapp.converters;

import ir.shayandaneshvar.recipeapp.commands.NotesCommand;
import ir.shayandaneshvar.recipeapp.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    @Override
    public Notes convert(NotesCommand notesCommand) {
        throw new UnsupportedOperationException();
    }
}
