package pl.rtaj.demo.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.rtaj.demo.Recipes.Recipe;

import java.util.List;
import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {


    Optional<Category> findAllByCategory(RecipeCategory category);


}
