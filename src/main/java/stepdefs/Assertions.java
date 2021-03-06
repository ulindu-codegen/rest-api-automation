package stepdefs;

import io.cucumber.java8.En;
import io.restassured.response.ValidatableResponse;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;

public class Assertions implements En {

    public static ValidatableResponse validatableResponse;

    public Assertions() {

        Then("^I should get a successful response with status code (\\d+)$", (Integer statusCode) -> {

            validatableResponse = Steps.response.then().statusCode(statusCode);
            Attachment.reportGeneration(Steps.requestSpecification, Steps.response);

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

        And("^user id (\\d+) first name should be \"([^\"]*)\" and last name should be \"([^\"]*)\"$", (Integer userId, String fName, String lName) -> {

            List<Integer> userIds = validatableResponse.extract().path("data.id");
            int index = userIds.indexOf(userId);

            validatableResponse.body("data[" + index + "].first_name", equalTo(fName));
            validatableResponse.body("data[" + index + "].last_name", equalTo(lName));

        });

        And("^user id should be (\\d+)$", (Integer id) -> {

            validatableResponse.body("data.id", equalTo(id));

        });

        And("^user first name should be \"([^\"]*)\" and last name should be \"([^\"]*)\"$", (String fName, String lName) -> {

            validatableResponse.body("data.first_name", equalTo(fName));
            validatableResponse.body("data.last_name", equalTo(lName));

        });

        And("^user name should be \"([^\"]*)\" and job should be \"([^\"]*)\"$", (String name, String job) -> {

            validatableResponse.body("name", equalTo(name));
            validatableResponse.body("job", equalTo(job));

        });

        And("^user should have an id$", () -> {

            validatableResponse.body("id", notNullValue());

        });

        And("^updated date should be \"([^\"]*)\"$", (String updatedDate) -> {

            validatableResponse.body("updatedAt", containsString(updatedDate));

        });

    }

}
