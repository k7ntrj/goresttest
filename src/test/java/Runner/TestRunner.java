package Runner;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/GoRestAPI.feature", glue={"classpath:src/test/java/Runner"}
)

public class TestRunner {

}
