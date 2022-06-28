package executor;

import io.cucumber.core.cli.Main;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class CucumberIT {

    @BeforeAll
    static void beforeAll(){

        System.out.println("@BeforeAll : Executing Before The All Test Scenarios");

    }

    @Test
    void executor() {

        Main.run(new String[]{

                "--threads", "1",
                "-p", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "-g", "stepdefs", "src/main/resources/delete"

        }, CucumberIT.class.getClassLoader());

    }

    @AfterAll
    static void afterAll(){

        System.out.println("@AfterAll : Executing After The All Test Scenarios");

    }

}
