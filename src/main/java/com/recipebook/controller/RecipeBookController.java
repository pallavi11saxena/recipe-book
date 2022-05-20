package com.recipebook.controller;

import com.recipebook.data.bean.Recipe;
import com.recipebook.data.dao.RecipeDAO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author pallavi
 */

@RestController
@RequestMapping(path = "/recipes")
public class RecipeBookController {

    private final RecipeDAO recipeDao;

    RecipeBookController(RecipeDAO recipeDao) {
        this.recipeDao = recipeDao;
    }

    @GetMapping(path = "/", produces = "application/json")
    public List<Recipe> getRecipes() {
        return recipeDao.findAll();
    }

    @PostMapping("/add")
    public Recipe createRecipe(@Valid @RequestBody Recipe recipe) {
        return recipeDao.save(recipe);
    }

    @PutMapping("/update/{id}")
    public Recipe updateRecipe(@Valid @RequestBody Recipe recipe, @PathVariable Long id) throws NoSuchElementException {
        try {
            Recipe currentRecipe = recipeDao.getOne(id);
            if (null != recipe.getDateCreated())
                currentRecipe.setDateCreated(recipe.getDateCreated());
            if (null != recipe.getName())
                currentRecipe.setName(recipe.getName());
            if (null != recipe.getIsVeg())
                currentRecipe.setIsVeg(recipe.getIsVeg());
            if (null != recipe.getIngredients())
                currentRecipe.setIngredients(recipe.getIngredients());
            if (null != recipe.getInstructions())
                currentRecipe.setInstructions(recipe.getInstructions());
            return recipeDao.save(currentRecipe);
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeDao.deleteById(id);
    }


}
