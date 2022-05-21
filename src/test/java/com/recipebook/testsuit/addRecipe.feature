Feature: As a user of the recipe-book app, I want to add a recipe.

  Background: Validate the add api result.

    * url urlParam = 'http://localhost:8080'
    And print 'urlParam :',urlParam
    * def dataFile = 'recipe-file.json'
    * def payload =
    """
  {
    "name": "veg pasta",
    "dateCreated": "2022-05-19",
    "isVeg" :  true,
    "serves":  4,
    "ingredients": [{
                "name": "pasta",
            }, {
                "name":  "tomato"
            }, {
                "name":  "garlic"
            }],
    "instructions" : "boil pasta, cut tomato"
  }
    """

  Scenario Outline: Add recipe and validate the response.

    Given path '/recipes/add'
    And request payload
    When method post
    Then status 200

    * def output = response

    And print 'response :',output
    Then assert responseTime < '100000'
    Then match response.id =='#notnull'
    Then match response.name ==  '#(recipeName1)'
    Then match response.dateCreated == '#notnull'
    Then match response.isVeg == '#(isVeg1)'
    Then match response.serves == '#(serves1)'
    Then match response.ingredients == '#notnull'
    Then match response.instructions == '#(instructions1)'

    Examples:
      | read(dataFile) |
