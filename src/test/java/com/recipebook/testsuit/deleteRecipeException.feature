Feature: As a user of the recipe-book app, I want to get the exception if I put wrong input in delete API.

  Background: Validate the delete api result.

    * url urlParam = 'http://localhost:8080'
    And print 'urlParam :',urlParam
    * def dataFile = 'recipe-file.json'

  Scenario: Delete recipe negative scenario, get 500 internal server error when a non-existent Id is passed.

    Given path '/recipes/delete/10000000000'
    When method delete
    Then status 500

    * def output = response

    Then assert responseTime < '100000'

