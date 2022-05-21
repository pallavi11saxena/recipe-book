Feature: As a user of the recipe-book app, I want to delete a recipe.

  Background: Validate the delete api result.

    * url urlParam = 'http://localhost:8080'
    And print 'urlParam :',urlParam
    * def dataFile = 'recipe-file.json'

  Scenario: Add and then delete the newly added recipe.

    * def add = call read('classpath:com/recipebook/testsuit/addRecipe.feature')  {"name": "veg pasta","dateCreated": "2022-05-19","isVeg" :  true,"serves":  4,"ingredients": [{"name": "pasta",}, {"name":  "tomato"}, {"name":  "garlic"}],"instructions" : "boil pasta, cut tomato"}
    * def value = add.response

    Given path '/recipes/delete/'+value.id+''
    * header Authorization = call read('basic-auth.js') { username: 'user', password: 'password' }
    When method delete
    Then status 200

    * def output = response

    Then assert responseTime < '100000'

