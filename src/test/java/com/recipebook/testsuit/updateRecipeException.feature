Feature: As a user of the recipe-book app, I want to get the exception if I put wrong input in update API.

  Background: Validate the update api result.

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

  Scenario Outline: Update Recipe negative scenario, get 400 Bad request error when wrong parameter is passed in Id field.

    Given path '/recipes/update/tr'
    And request payload
    When method put
    Then status 400

    * def output = response

    And print 'response :',output
    Then assert responseTime < '100000'
    Then match response.error =='Bad Request'
    Examples:
      |read(dataFile)  |
