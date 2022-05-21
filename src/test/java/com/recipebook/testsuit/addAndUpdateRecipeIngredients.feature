Feature: As a user of the recipe-book app, I want to update recipe's ingredients.

  Background: Validate the update api result.

    * url urlParam = 'http://localhost:8080'
    And print 'urlParam :',urlParam
    * def dataFile = 'recipe-file.json'
    * def add = call read('classpath:com/recipebook/testsuit/addRecipe.feature')  {"name": "veg pasta","dateCreated": "2022-05-19","isVeg" :  true,"serves":  4,"ingredients": [{"name": "pasta",}, {"name":  "tomato"}, {"name":  "garlic"}],"instructions" : "boil pasta, cut tomato"}
    * def value = add.response
    * def payload =
    """
   {
       "ingredients": [
            {
                "recipe": #(value.id),
                "id": 0,
                "name": "chicken"
            }
        ]
    }
    """

  Scenario Outline: Add a new recipe and then update it's ingredients.

    Given path '/recipes/update/'+value.id+''
    * header Authorization = call read('basic-auth.js') { username: 'user', password: 'password' }
    And request payload
    When method put
    Then status 200

    * def output = response

    And print 'response update ingredients :',output
    Then assert responseTime < '100000'
    Then match response.id =='#notnull'
    Then match response.name ==  '#(recipeName1)'
    Then match response.ingredients[0].name ==  '#(ingredientsName4)'
    Examples:
      |read(dataFile)  |
