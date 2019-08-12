package pl.rtaj.demo.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.rtaj.demo.recipes.Recipe;
import pl.rtaj.demo.recipes.RecipeRepository;

import java.util.List;
import java.util.Optional;

@RequestMapping("/category")
@Controller
public class CategoryController {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;

    public CategoryController(CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/{id}")
    public String home(@PathVariable Long id, Model model) {


        Optional<Category> optional = categoryRepository.findById(id);

        if (optional.isPresent()) {
            Category category = optional.get();
            model.addAttribute("selected", category);
            return "category";
        }

        else return "category";
//        else {
//         List<Recipe> all = recipeRepository.findAll();
//            model.addAttribute("selected", all);
//            return "category";
//        }
    }
}


