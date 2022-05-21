Feature: As a user of the recipe-book app, I want to get the exception if I put wrong input in get API.

  Background: Validate the get api result.

    * url urlParam = 'http://localhost:8080'
    And print 'urlParam :',urlParam

  Scenario: Get Recipe negative scenario, get 404 Not found error when slash is missing from the endpoint.

    Given path '/recipes'
    * header Authorization = call read('basic-auth.js') { username: 'user', password: 'password' }
    And header Accept = 'application/json'
    When method get
    Then status 404

    * def output = response

    And print 'response :',output
    Then assert responseTime < '100000'
