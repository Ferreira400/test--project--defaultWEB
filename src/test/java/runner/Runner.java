package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},
        glue = {"gherkin"},
        plugin = {"pretty",
                "json:target/report/cucumber.json",
                "html:target/report/cucumber.html"},
        tags = "@tagdefault",
        dryRun = false


)

public class Runner {}
