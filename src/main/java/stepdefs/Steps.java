package stepdefs;

import gherkin.deps.com.google.gson.JsonObject;
import io.cucumber.java.Before;
import io.cucumber.java8.En;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.jupiter.api.BeforeAll;

import java.util.List;

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

        Given("^this is the feature background$", () -> {

            System.out.println("Background : Executes Before Each Test Scenario In The Feature File");

        });

        Then("^I want to create a user with id (\\d+) AND job \"([^\"]*)\"$", (Integer id, String job) -> {

            List<Integer> userID = Assertions.validatableResponse.extract().path("data.id");
            int index = userID.indexOf(id);


            JsonObject reqBody = new JsonObject();
            reqBody.addProperty("name", Assertions.validatableResponse.extract().path("data["+index+"].first_name").toString());
            reqBody.addProperty("job", job);

            requestSpecification = given().contentType("application/json").body(reqBody.toString());

        });

        Then("^I want to delete user \"([^\"]*)\"$", (String firstName) -> {

            List<String> username = Assertions.validatableResponse.extract().path("data.first_name");
            int index = username.indexOf(firstName);

            requestSpecification = given().pathParam("id", Assertions.validatableResponse.extract().path("data["+index+"].id"));

        });

    }

    /*@Before
    public void before() {

        System.out.println("@Before : Executes Before Each Test Scenario");

    }

    @After
    public void after() {

        System.out.println("@After : Executes After Each Test Scenario");

    }*/

}
