package pl.rtaj.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.rtaj.demo.Category.Category;
import pl.rtaj.demo.Category.CategoryRepository;
import pl.rtaj.demo.Recipes.Recipe;
import pl.rtaj.demo.Recipes.RecipeRepository;

import javax.persistence.GeneratedValue;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public String home(Model model) {

        List<Category> list = categoryRepository.findAll();
        model.addAttribute("categories", list);

        return ("home");
    }

}