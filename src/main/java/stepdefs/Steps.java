package stepdefs;

import io.cucumber.java8.En;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Steps implements En {

    public static RequestSpecification requestSpecification;
    public static Response response;

    public Steps() {

        Given("^I want to search for all the users$", () -> {

            requestSpecification = given();

        });

        When("^I click search users$", () -> {

            response = requestSpecification.when().get("https://reqres.in/api/users");
            response.prettyPrint();

        });

        Given("^I want to search for the users in page (\\d+)$", (Integer pageNo) -> {

            requestSpecification = given().param("page", pageNo);

        });

    }

}
