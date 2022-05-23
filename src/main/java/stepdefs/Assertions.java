package stepdefs;

import io.cucumber.java8.En;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;

public class Assertions implements En {

    public static ValidatableResponse validatableResponse;

    public Assertions() {

        Then("^I should get a successful response with status code (\\d+)$", (Integer statusCode) -> {

            validatableResponse = Steps.response.then().statusCode(statusCode);

        });

        And("^page number should be (\\d+)$", (Integer pageNo) -> {

            validatableResponse.body("page", equalTo(pageNo));

        });

        And("^per page should be (\\d+)$", (Integer perPage) -> {

            validatableResponse.body("per_page", equalTo(perPage));

        });

        And("^total users should be (\\d+)$", (Integer totalUsers) -> {

            validatableResponse.body("total", equalTo(totalUsers));

        });

        And("^total pages should be (\\d+)$", (Integer totalPages) -> {

            validatableResponse.body("total_pages", equalTo(totalPages));

        });

        And("^response should return (\\d+) users$", (Integer noOfUsers) -> {

            validatableResponse.body("data", hasSize(noOfUsers));

        });

        And("^users should have an id$", () -> {

            validatableResponse.body("data.id", everyItem(notNullValue()));

        });

    }

}
