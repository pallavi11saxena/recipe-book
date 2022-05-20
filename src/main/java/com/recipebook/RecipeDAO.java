package com.recipebook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface  RecipeDAO extends JpaRepository<Recipe, Long> {
/*
    private static Recipes list = new Recipes();

    static
    {
        list.getRecipeList().add(new Recipe("Dal Bati", new Date(), true, 2,
                null, "make" ));
        list.getRecipeList().add(new Recipe("Dal Bati", new Date(), true, 2,
                null, "make" ));
    }

    public Recipes getAllRecipes()
    {
        return list;
    }

    public void addRecipe(Recipe recipe) {
        list.getRecipeList().add(recipe);
    }*/

}
