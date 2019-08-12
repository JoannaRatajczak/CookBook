package pl.rtaj.demo.Category;

import pl.rtaj.demo.Recipes.Recipe;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private RecipeCategory category;
//    private MealType type;

    @OneToMany(mappedBy="category")
    private List<Recipe> recipeList;

    public Category() {
    }

    public Category(Long id, RecipeCategory category, List<Recipe> recipeList) {
        this.id = id;
        this.category = category;
        this.recipeList = recipeList;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
}
