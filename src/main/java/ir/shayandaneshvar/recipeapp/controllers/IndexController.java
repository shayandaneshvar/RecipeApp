package ir.shayandaneshvar.recipeapp.controllers;

import ir.shayandaneshvar.recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Getting Index Page");
//        Optional<Category> categoryOptional =
//                categoryRepository.findByDescription("American");
//        Optional<UnitOfMeasure> unitOfMeasure =
//                unitOfMeasureRepository.findByDescription("Teaspoon");
//        System.out.println("Cat id is " + categoryOptional.get().getId());
//        System.out.println("uom id is " + unitOfMeasure.get().getId());
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
