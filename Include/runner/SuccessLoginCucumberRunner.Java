import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Include/features/SuccessLogin.feature", // Path to your feature files
    glue = "stepDefinitions/SuccessLogin.groovy", // Package containing your step definitions
    plugin = {"pretty", "html:Reports/cucumber-html-report"} // Plugins for reporting
)
public class CucumberRunner {
}
