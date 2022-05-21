Feature: As a user of the recipe-book app, I want to update recipe's name.

  Background: Validate the update api result.

    * url urlParam = 'http://localhost:8080'
    And print 'urlParam :',urlParam
    * def dataFile = 'recipe-file.json'
    * def add = call read('classpath:com/recipebook/testsuit/addRecipe.feature')  {"name": "veg pasta","dateCreated": "2022-05-19","isVeg" :  true,"serves":  4,"ingredients": [{"name": "pasta",}, {"name":  "tomato"}, {"name":  "garlic"}],"instructions" : "boil pasta, cut tomato"}
    * def value = add.response
    * def payload =
    """
   {
        "name": "Chicken Curry"
    }
    """

  Scenario Outline: Add a new recipe and then update newly added recipe's name.

    Given path '/recipes/update/'+value.id+''
    * header Authorization = call read('basic-auth.js') { username: 'user', password: 'password' }
    And request payload
    When method put
    Then status 200

    * def output = response

    And print 'response :',output
    Then assert responseTime < '100000'
    Then match response.id =='#notnull'
    Then match response.name ==  '#(recipeName2)'
    Examples:
      |read(dataFile)  |
