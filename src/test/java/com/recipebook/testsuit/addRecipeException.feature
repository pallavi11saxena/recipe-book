Feature: As a user of the recipe-book app, I want to get the exception if I put wrong input in add API.

  Background: Validate the add api result.

    * url urlParam = 'http://localhost:8080'
    And print 'urlParam :',urlParam
    * def dataFile = 'recipe-file.json'
    * def payload =
    """
  {
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

  Scenario Outline: Add recipe negative scenario, get 500 internal server error when name is not passed in the request payload.

    Given path '/recipes/add'
    And request payload
    When method post
    Then status 500

    * def output = response

    And print 'response :',output
    Then assert responseTime < '100000'

    Examples:
      | read(dataFile) |
