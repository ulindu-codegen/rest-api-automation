Feature: Delete Users using DELETE Request

  @DeleteUser
  Scenario: Verifying Deleting User
    Given I want to delete user id 2
    When I click delete user
    Then I should get a successful response with status code 204

  Scenario: Verify delete user using name
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

    Then I want to delete user "Emma"
    When I click delete user
    Then I should get a successful response with status code 204