package com.recipebook.controller;

import com.recipebook.data.bean.Ingredients;
import com.recipebook.data.bean.Recipe;
import com.recipebook.data.dao.IngredientsDAO;
import com.recipebook.data.dao.RecipeDAO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author pallavi
 * Controller for Get, POST, PUT and DELETE operations.
 */

@RestController
@RequestMapping(path = "/recipes")
public class RecipeBookController {

    private final RecipeDAO recipeDao;
    private final IngredientsDAO ingredientsDAO;

    RecipeBookController(RecipeDAO recipeDao, IngredientsDAO ingredientsDAO) {
        this.recipeDao = recipeDao;
        this.ingredientsDAO = ingredientsDAO;
    }

    /**
     * GET operation to get the list of all recipes.
     * @return recipes, list of all recipes returned
     */
    @GetMapping(path = "/", produces = "application/json")
    public List<Recipe> getRecipes() {
        return recipeDao.findAll();
    }

    /**
     * POST operation to add a new recipe.
     * @param recipe, recipe object to be added
     * @return recipe, added recipe object
     */
    @PostMapping("/add")
    public Recipe createRecipe(@Valid @RequestBody Recipe recipe) {
        Recipe recipeObj = recipeDao.save(recipe);
        for(Ingredients i : recipe.getIngredients()){
            i.setRecipe(recipeObj.getId());
            ingredientsDAO.save(i);
        }
        return recipeObj;
    }

    /**
     * PUT operation to update an existing recipe.
     * @param recipe, recipe object with updated details
     * @param id, id of the recipe to be updated
     * @return recipe, updated recipe object
     */
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
            if (null != recipe.getIngredients()) {
                for(Ingredients i : recipe.getIngredients()){
                    i.setRecipe(id);
                    ingredientsDAO.save(i);
                }
                currentRecipe.setIngredients(recipe.getIngredients());
            }
            if (null != recipe.getInstructions())
                currentRecipe.setInstructions(recipe.getInstructions());
            return recipeDao.save(currentRecipe);
        } catch (NoSuchElementException e) {
            throw e;
        }
    }

    /**
     * DELETE operation to delete a recipe.
     * @param  id, recipe id to be deleted
     */
    @DeleteMapping("/delete/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeDao.deleteById(id);
    }

}
