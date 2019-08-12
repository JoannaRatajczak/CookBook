package pl.rtaj.demo.Category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.rtaj.demo.Recipes.Recipe;
import pl.rtaj.demo.Recipes.RecipeRepository;

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

    @GetMapping("/")
    public String categoryRecipes(Model model, @RequestParam RecipeCategory categoryEnum) {


        Optional<Category> optional = categoryRepository.findAllByCategory(categoryEnum);

        if (optional.isPresent()) {
            Category category = optional.get();
            model.addAttribute("selected", category);
            return "category";
        }
        return null;

//        List<Recipe> listByCategory;
//        if (category==null) listByCategory = recipeRepository.findAll();
//        else listByCategory = recipeRepository.findAllByCategory(category);
//
//        model.addAttribute("recipies", listByCategory);

    }

}
