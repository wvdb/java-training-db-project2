import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Runs all Cucumber features and generates a report
 */
@RunWith(Cucumber.class)
@CucumberOptions(	plugin = {"pretty", "html:target/cucumber-report"},
	features = {"classpath:features"},
	snippets = SnippetType.CAMELCASE
)
public class CucumberTest {
}
