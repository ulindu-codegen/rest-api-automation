Feature: Search Users using GET request

  @SearchUsersPage2
  Scenario: Verify Searching users in Page 2
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

  @SearchUsersPage2Parameterized
  Scenario Outline: Verify Searching users in Page 2
    Given I want to search for the users in page <pageNo>
    When I click search users
    Then I should get a successful response with status code 200
    And page number should be <pageNo>
    And per page should be <perPage>
    And total users should be <totalUsers>
    And total pages should be <totalPages>
    And response should return <noOfUsers> users
    And users should have an id
    And user id <userId1> first name should be "<firstName1>" and last name should be "<lastName1>"
    And user id <userId2> first name should be "<firstName2>" and last name should be "<lastName2>"
    And user id <userId3> first name should be "<firstName3>" and last name should be "<lastName3>"
    And user id <userId4> first name should be "<firstName4>" and last name should be "<lastName4>"
    And user id <userId5> first name should be "<firstName5>" and last name should be "<lastName5>"
    And user id <userId6> first name should be "<firstName6>" and last name should be "<lastName6>"
    Examples:
      | pageNo | perPage | totalUsers | totalPages | noOfUsers | userId1 | firstName1 | lastName1 | userId2 | firstName2 | lastName2 | userId3 | firstName3 | lastName3 | userId4 | firstName4 | lastName4 | userId5 | firstName5 | lastName5 | userId6 | firstName6 | lastName6 |
      | 2      | 6       | 12         | 2          | 6         | 7       | Michael    | Lawson    | 8       | Lindsay    | Ferguson  | 9       | Tobias     | Funke     | 10      | Byron      | Fields    | 11      | George     | Edwards   | 12      | Rachel     | Howell    |
