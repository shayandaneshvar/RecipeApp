package ir.shayandaneshvar.recipeapp.controllers;

import ir.shayandaneshvar.recipeapp.commands.RecipeCommand;
import ir.shayandaneshvar.recipeapp.exceptions.NotFoundException;
import ir.shayandaneshvar.recipeapp.services.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@Slf4j
public class RecipeController {

    private final RecipeService recipeService;

    @/*Request*/GetMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(new Long(id)));
        return "recipe/show";
    }

    @GetMapping("recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeform";
    }

    //    @PostMapping
//    @RequestMapping(/*name = */"recipe"/*, method = RequestMethod.POST*/)
    @PostMapping("recipe")
    public String saveOrUpdate(@Valid @ModelAttribute RecipeCommand recipeCommand, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(err -> log.debug(err.toString()));
        }
        RecipeCommand savedCommand =
                recipeService.saveRecipeCommand(recipeCommand);
        return "redirect:/recipe/show/" + savedCommand.getId();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception) {
        log.error("Handling Not Found Exception!");
        log.error(exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("404error");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}
