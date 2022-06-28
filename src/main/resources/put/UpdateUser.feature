Feature: Updating Users using PUT request

  @UpdateUser
  Scenario: Verify Updating Users
    Given I want to update user id 3 name as "Anne" AND job as "QA"
    When I click update user
    Then I should get a successful response with status code 200
    And user name should be "Tim" and job should be "QA"
    And updated date should be "2022-06-06"

  @UpdateUserParameterized
  Scenario Outline: Verify Updating Users
    Given I want to update user id <userId> name as "<userName>" AND job as "<job>"
    When I click update user
    Then I should get a successful response with status code 200
    And user name should be "<userName>" and job should be "<job>"
    And updated date should be "<updatedDate>"
    Examples:
      | userId | userName | job | updatedDate   |
      | 2      | Tim      | QA  | 2022-06-28T19  |
      | 3      | Anne     | DEV | 2022-06-28T19 |