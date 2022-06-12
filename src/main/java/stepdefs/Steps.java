package stepdefs;

import gherkin.deps.com.google.gson.JsonObject;
import io.cucumber.java8.En;
import io.restassured.internal.RequestSpecificationImpl;
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

        Given("^I want to search for user id (\\d+)$", (Integer userId) -> {

            requestSpecification = given().pathParam("id", userId);

        });

        When("^I click search user$", () -> {

            response = requestSpecification.when().get("https://reqres.in/api/users/{id}");
            response.prettyPrint();

        });

        Given("^I want to create an user with name \"([^\"]*)\" and job \"([^\"]*)\"$", (String name, String job) -> {

            JsonObject reqBody = new JsonObject();
            reqBody.addProperty("name", name);
            reqBody.addProperty("job", job);

            requestSpecification = given().contentType("application/json").body(reqBody.toString());

        });

        When("^I click create user$", () -> {

            response = requestSpecification.when().post("https://reqres.in/api/users");
            System.out.println(((RequestSpecificationImpl) requestSpecification).getBody());
            response.prettyPrint();

        });

        Given("^I want to update user id (\\d+) name as \"([^\"]*)\" AND job as \"([^\"]*)\"$", (Integer userId, String name, String job) -> {

            JsonObject reqBody = new JsonObject();
            reqBody.addProperty("name", name);
            reqBody.addProperty("job", job);

            requestSpecification = given().contentType("application/json").body(reqBody.toString()).pathParam("id", userId);

        });

        When("^I click update user$", () -> {

            response = requestSpecification.when().put("https://reqres.in/api/users/{id}");
            System.out.println(((RequestSpecificationImpl) requestSpecification).getBody());
            response.prettyPrint();

        });

        Given("^I want to delete user id (\\d+)$", (Integer userId) -> {

            requestSpecification = given().pathParam("id", userId);

        });

        When("^I click delete user$", () -> {

            response = requestSpecification.when().delete("https://reqres.in/api/users/{id}");
            System.out.println(((RequestSpecificationImpl) requestSpecification).getURI());
            response.prettyPrint();

        });

    }

}
