Feature:  Create Users using POST Request

  Scenario: Verifying Creating Users
    Given I want to create an user with name "Tom" and job "QA"
    When I click create user
    Then I should get a successful response with status code 201
    And user name should be "Tom" and job should be "QA"
    And user should have an id