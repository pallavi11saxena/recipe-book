package com.recipebook;


    import org.springframework.web.bind.annotation.*;

    import javax.validation.Valid;
    import java.util.List;

@RestController
@RequestMapping(path = "/recipes")
public class RecipeBookController {

    private final RecipeDAO recipeDao;


    RecipeBookController(RecipeDAO recipeDao) {
        this.recipeDao = recipeDao;
    }

    @GetMapping(path="/", produces = "application/json")
        public List<Recipe> getRecipes(){
            return recipeDao.findAll();
        }

    @PostMapping("/add")
    public Recipe createRecipe(@Valid @RequestBody Recipe recipe) {
        return recipeDao.save(recipe);
    }

        /*@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
        public ResponseEntity<Object> addRecipe(@RequestBody Recipe recipe)
        {
            Integer id = recipeDao.getAllRecipes().getRecipeList().size() + 1;
            recipe.setId(id);

            recipeDao.addRecipe(recipe);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(employee.getId())
                    .toUri();

            return ResponseEntity.created(location).build();
        }*/

}
