Feature: Search Users using GET request

  Background: This Executes Before Each Test Scenarios In This Feature File
    Given this is the feature background

  @SearchAllUsers @GETScenario
  Scenario: Verify searching all users
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

    @SearchUsersPage2 @GETScenario
    Scenario: Verify Searching users in the Page 2
      Given I want to search for the users in page 2
      When I click search users
      Then I should get a successful response with status code 200
      And page number should be 2
      And per page should be 6
      And total users should be 12
      And total pages should be 2
      And response should return 6 users
      And users should have an id
      And user id 7 first name should be "Michael" and last name should be "Lawson"
      And user id 8 first name should be "Lindsay" and last name should be "Ferguson"
      And user id 9 first name should be "Tobias" and last name should be "Funke"
      And user id 10 first name should be "Byron" and last name should be "Fields"
      And user id 11 first name should be "George" and last name should be "Edwards"
      And user id 12 first name should be "Rachel" and last name should be "Howell"

      @SearchUser2
      Scenario: Verify Searching users by ID
        Given I want to search for user id 2
        When I click search user
        Then I should get a successful response with status code 200
        And user id should be 2
        And user first name should be "Janet" and last name should be "Weaver"