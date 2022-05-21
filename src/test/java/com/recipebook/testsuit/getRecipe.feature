Feature: As a user of the recipe-book app, I want get the list of all the recipes.

  Background: Validate the get api result.

    * url urlParam = 'http://localhost:8080'
    And print 'urlParam :',urlParam

  Scenario: Get the list of all the recipes and validate the response and response time.

    Given path '/recipes/'
    * header Authorization = call read('basic-auth.js') { username: 'user', password: 'password' }
    When method get
    Then status 200

    * def output = response
    * def size = responseBytes.length

    And print 'response :',output
    Then assert responseTime < '100000'
    Then match response[0].id =='#notnull'
    Then match response[0].name == '#notnull'
    Then match response[0].dateCreated == '#present'
    Then match response[0].isVeg == '#present'
    Then match response[0].serves == '#present'
    Then match response[0].ingredients == '#present'
    Then match response[0].instructions == '#present'
