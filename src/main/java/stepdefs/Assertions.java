package stepdefs;

import io.cucumber.java8.En;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.CoreMatchers.equalTo;

public class Assertions implements En {

    public static ValidatableResponse validatableResponse;

    public Assertions() {

        Then("^I should get a successful response with status code (\\d+)$", (Integer statusCode) -> {

            validatableResponse = Steps.response.then().statusCode(statusCode);

        });

        And("^page number should be (\\d+)$", (Integer pageNo) -> {

            validatableResponse.body("page", equalTo(pageNo));

        });

    }

}
