Feature:  Create Users using POST Request

  @CreateUser
  Scenario: Verifying Creating Users
    Given I want to create an user with name "Tom" and job "QA"
    When I click create user
    Then I should get a successful response with status code 201
    And user name should be "Tom" and job should be "QA"
    And user should have an id

  Scenario: Verify create user using id
    Given I want to search for all the users
    When I click search users
    Then I should get a successful response with status code 200

    And page number should be 1
    And per page should be 6
    And total users should be 12
    And total pages should be 2
    And response should return 6 users
    And users should have an id

    And user id 1 first name should be "George" and last name should be "Bluth"
    And user id 2 first name should be "Janet" and last name should be "Weaver"
    And user id 3 first name should be "Emma" and last name should be "Wong"
    And user id 4 first name should be "Eve" and last name should be "Holt"
    And user id 5 first name should be "Charles" and last name should be "Morris"
    And user id 6 first name should be "Tracey" and last name should be "Ramos"

    Then I want to create a user with id 2 AND job "QA"
    When I click create user
    Then I should get a successful response with status code 201

    And user name should be "Janet" and job should be "QA"
    And user should have an id