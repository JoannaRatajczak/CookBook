package pl.rtaj.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.rtaj.demo.category.Category;
import pl.rtaj.demo.category.CategoryRepository;
import pl.rtaj.demo.recipes.Recipe;
import pl.rtaj.demo.recipes.RecipeRepository;

import java.util.List;

@Controller
public class HomeController {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;

    public HomeController(CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<Category> list = categoryRepository.findAll();
        model.addAttribute("categories", list);

        List<Recipe> newest = recipeRepository.theNewest();
        model.addAttribute("newRecipes", newest);

        return ("home");
    }

}
