package pl.rtaj.demo.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.rtaj.demo.recipes.Recipe;
import pl.rtaj.demo.recipes.RecipeRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;

    public CategoryController(CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/category/{id}")
    public String home(@PathVariable() Long id, Model model) {

        List<Category> listNavbar = categoryRepository.findAll();
        model.addAttribute("categories", listNavbar);

        List<Recipe> top = recipeRepository.top();
        model.addAttribute("top", top);

        Optional<Category> optional = categoryRepository.findById(id);

        if (optional.isPresent()) {
            Category category = optional.get();
            model.addAttribute("selected", category);
            return "category";
        } else return"404";
    }


    @GetMapping("/recipesFind")
    public String allRecipes(Model model) {

        List<Category> listNavbar = categoryRepository.findAll();
        model.addAttribute("categories", listNavbar);

        List<Recipe> top = recipeRepository.top();
        model.addAttribute("top", top);

        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes";
    }
}



