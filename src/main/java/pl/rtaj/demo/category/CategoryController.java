package pl.rtaj.demo.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

        Optional<Category> optional = categoryRepository.findById(id);

        if (optional.isPresent() && id != null) {
            Category category = optional.get();
            model.addAttribute("selected", category);
            return "category";
        } else return "category/all";
    }


    @GetMapping("/category/all")
    public String homeAllRecipes(Model model) {

        List<Category> allReceipe = categoryRepository.findAll();

        model.addAttribute("selected", allReceipe);
        return "category";
    }
}

//    @GetMapping("/recipe/{id}")
//    public String recipeView(@PathVariable Long id, Model model){
//
////for navbar ******************************************************
//        List<Category> list = categoryRepository.findAll();
//        model.addAttribute("categories", list);
////        *********************************************************
//
//       Optional<Recipe> optional = recipeRepository.findById(id);
//
//       if (optional.isPresent()){
//           Recipe recipe = optional.get();
//           model.addAttribute("recipe",recipe);
//           return "recipe";
//       }
//       else return "categories";
//
//    }




