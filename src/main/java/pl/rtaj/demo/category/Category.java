package pl.rtaj.demo.category;

import pl.rtaj.demo.recipes.Recipe;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    private Long id;
    private String title;
    private String description;


    @OneToMany(mappedBy="category")
    private List<Recipe> recipeList;

    public Category() {
    }

    public Category(Long id, String title, String description, List<Recipe> recipeList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.recipeList = recipeList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
