package pl.rtaj.demo.recipes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
import pl.rtaj.demo.category.Category;
import pl.rtaj.demo.category.CategoryRepository;

//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Controller
public class RecipeController {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;

    public RecipeController(CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("category/recipe/{id}")
    public String recipeView(@PathVariable Long id, Model model) {

        List<Category> listNavbar = categoryRepository.findAll();
        model.addAttribute("categories", listNavbar);

        Optional<Recipe> optional = recipeRepository.findById(id);

        if (optional.isPresent()) {
            Recipe recipe = optional.get();
            model.addAttribute("recipe", recipe);
        }
        return "recipe";
    }

//    @RequestMapping("/")
//    private ModelAndView cookieHandler(HttpServletResponse response) {
//
//        response.addCookie(new Cookie("COOKIE", "The cookie's value"));
//
//        return new ModelAndView("viewname");
//    }

    @GetMapping("/edit")
    public String editTask(@RequestParam Long id, Model model) {

        List<Category> listNavbar = categoryRepository.findAll();
        model.addAttribute("categories", listNavbar);

        List<Recipe> top = recipeRepository.top();
        model.addAttribute("top", top);

        Optional<Recipe> optional = recipeRepository.findById(id);

        if (optional.isPresent()) {
            Recipe recipe = optional.get();
            model.addAttribute("recipe", recipe);
            return "edit";
        }
        return "404";
    }

    @PostMapping("/edited")
    @Transactional
    public String editedTask(Recipe recipe, Model model) {

        List<Category> listNavbar = categoryRepository.findAll();
        model.addAttribute("categories", listNavbar);

        Optional<Recipe> optional = recipeRepository.findById(recipe.getId());

        if (optional.isPresent()) {
            Recipe newRecipe = optional.get();
            Category newCategory = recipe.getCategory();
            newRecipe.setCategory(newCategory);
            newRecipe.setId(recipe.getId());
            newRecipe.setName(recipe.getName());
            newRecipe.setIngredients(recipe.getIngredients());
            newRecipe.setInstructions(recipe.getInstructions());
            newRecipe.setMark(null);
            newRecipe.setNotes(recipe.getNotes());
//        newRecipe.setPicture(recipe.setPicture());
            recipeRepository.save(newRecipe);
            System.out.println(newRecipe);
            return "redirect:/category/" + newRecipe.getCategory().getId();

        } else return "404";

    }

    @GetMapping("/delete")
    public String deleteRecipe(@RequestParam Long id) {

        recipeRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/like")
    public String likeRecipe(@RequestParam Long id) {

        Optional<Recipe> optional = recipeRepository.findById(id);
        if (optional.isPresent()) {
            Recipe likedRecipe = optional.get();
            likedRecipe.setMark(likedRecipe.getMark() + 1);
            recipeRepository.save(likedRecipe);
            return "redirect:/";
        } else return "404";
    }

    @GetMapping("/add")
    public String addRecipe(@RequestParam Long id, Model model) {

        List<Category> listNavbar = categoryRepository.findAll();
        model.addAttribute("categories", listNavbar);

        Recipe recipe = new Recipe();
        recipe.setCategory(categoryRepository.findById(id).orElse(null));
        model.addAttribute("recipe", recipe);

        return "add";
    }

    @PostMapping("/addNew")
    public String gotRecipeAndSave(Recipe recipe) {

        recipeRepository.save(recipe);
        return "redirect:/category/" + recipe.getCategory().getId();

    }

    @GetMapping("/addNoCat")
    public String addRecipeWithCat(Model model) {
        List<Category> listNavbar = categoryRepository.findAll();
        model.addAttribute("categories", listNavbar);

        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "addNoCat";
    }

    @PostMapping("/logout")
    public String logout() {

        return "home";
    }
}
