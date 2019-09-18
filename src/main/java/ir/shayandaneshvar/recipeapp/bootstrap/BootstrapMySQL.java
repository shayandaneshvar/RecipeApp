package ir.shayandaneshvar.recipeapp.bootstrap;

import ir.shayandaneshvar.recipeapp.domain.Category;
import ir.shayandaneshvar.recipeapp.domain.UnitOfMeasure;
import ir.shayandaneshvar.recipeapp.repositories.CategoryRepository;
import ir.shayandaneshvar.recipeapp.repositories.UnitOfMeasureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"dev", "prod"})
@RequiredArgsConstructor
public class BootstrapMySQL implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (categoryRepository.count() == 0L) {
            log.debug("loading cats");
            loadCategories();
        }
        if (unitOfMeasureRepository.count() == 0L) {
            log.debug("loading uoms");
            loadUom();
        }
    }

    private void loadCategories() {
        Category category = new Category();
        category.setDescription("American");
        categoryRepository.save(category);
        Category category1 = new Category();
        category.setDescription("Italian");
        categoryRepository.save(category1);
    }

    public void loadUom() {
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription("Teaspoon");
        unitOfMeasureRepository.save(unitOfMeasure);
        UnitOfMeasure unitOfMeasure1 = new UnitOfMeasure();
        unitOfMeasure.setDescription("Tablespoon");
        unitOfMeasureRepository.save(unitOfMeasure1);
    }
}
