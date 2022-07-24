package executor;

import io.cucumber.core.cli.Main;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class CucumberIT {

    @Test
    void executor() {

        Main.run(new String[]{

                "--threads", "1",
                "-p", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "-g", "stepdefs", "src/main/resources/assignment"

        }, CucumberIT.class.getClassLoader());

    }

}
