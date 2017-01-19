package steps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		plugin = {"json:target/CustomReports/report.json"},
		features="src/test/resources/features/"
		)

public class RunTest {
	
}
