package pl.rtaj.demo.recipes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value = "SELECT * FROM recipe order by id desc limit 0, 3", nativeQuery = true)
    List<Recipe> theNewest();

    @Query(value = "SELECT * FROM recipe order by mark desc limit 0, 1", nativeQuery = true)
    List<Recipe> top();




}
