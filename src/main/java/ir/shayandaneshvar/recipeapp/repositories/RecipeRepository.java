package ir.shayandaneshvar.recipeapp.repositories;

import ir.shayandaneshvar.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
