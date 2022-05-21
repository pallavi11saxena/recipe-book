Feature: As a user of the recipe-book app, I want get the list of all the recipes.

  Background: Validate the get api result.

    * url urlParam = 'http://localhost:8080'
    And print 'urlParam :',urlParam

    * def get = call read('classpath:com/recipebook/testsuit/getRecipe.feature')
    * def oldSize = get.size

    * def add = call read('classpath:com/recipebook/testsuit/addRecipe.feature')  {"name": "veg pasta","dateCreated": "2022-05-19","isVeg" :  true,"serves":  4,"ingredients": [{"name": "pasta",}, {"name":  "tomato"}, {"name":  "garlic"}],"instructions" : "boil pasta, cut tomato"}
    * def value = add.response

  Scenario: Add a new recipe and validate that the old response size is less than the new response size after new recipe addition.

    Given path '/recipes/'
    And header Accept = 'application/json'
    When method get
    Then status 200

    * def output = response

    And print 'response :',output
    Then assert responseTime < '100000'
    Then assert responseBytes.length > oldSize
