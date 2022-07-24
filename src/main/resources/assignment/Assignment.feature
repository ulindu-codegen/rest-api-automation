Feature: QRest Final Assignment

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

  @SearchUsersPage1&2Parameterized
  Scenario Outline: Verify Searching users in Page 1 and 2
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
      | 1      | 6       | 12         | 2          | 6         | 1       | George     | Bluth     | 2       | Janet      | Weaver    | 3       | Emma       | Wong      | 4       | Eve        | Holt      | 5       | Charles    | Morris    | 6       | Tracey     | Ramos     |
      | 2      | 6       | 12         | 2          | 6         | 7       | Michael    | Lawson    | 8       | Lindsay    | Ferguson  | 9       | Tobias     | Funke     | 10      | Byron      | Fields    | 11      | George     | Edwards   | 12      | Rachel     | Howell    |

