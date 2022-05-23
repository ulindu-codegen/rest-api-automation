Feature: Search Users using GET request

  Scenario: Verify searching all users
    Given I want to search for all the users
    When I click search users
    Then I should get a successful response with status code 200
    And page number should be 1
    And per page should be 6
    And total users should be 12
    And total pages should be 2
