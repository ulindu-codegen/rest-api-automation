Feature: Updating Users using PUT request

  Scenario: Verify Updating Users
    Given I want to update user id 2 name as "Tim" AND job as "QA"
    When I click update user
    Then I should get a successful response with status code 200
    And user name should be "Tim" and job should be "QA"
    And updated date should be "2022-06-06"