package steps;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import reports.FinalReport;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {

	@Steps
	TestSteps testSteps;
	
	private Scenario scenario;
	private TestStatus status = new TestStatus();
	FinalReport report = new FinalReport();
	
	int passCount = 0;
	
	@When("^i retrieve a country$")
	public void i_retrieve_a_booking() throws Throwable {
		testSteps.getCountryDetails("new delhi");
	}
	
	@Then("^i should be able to see the details$")
	public void i_should_be_able_to_see_the_details() throws Throwable {
		testSteps.assertValues(Serenity.sessionVariableCalled("countryName").toString(), "[India]");
	}
	
	@And("^i call checkingroups$")
	public void i_call_checkingroups() throws Throwable {
		System.out.println("And usage");
	}
	
	@Before
	public void before(Scenario scenario) throws InvalidFormatException, IOException {
	    this.scenario = scenario;
	    System.out.println("Executing Scenario: "+scenario.getName());
	}
	
	@Before("@first")
	public void beforeAll() throws IOException {
		status.resetPassCount();
		status.resetFailCount();
	}
	
	@After
	public void after() throws IOException {
		if(scenario.getStatus().equalsIgnoreCase("passed")) {
			status.setPassCount();
		}
		else if(scenario.getStatus().equalsIgnoreCase("failed")) {
			status.setFailCount();
		}
		
		report.consolidatedHTMLReport(scenario.getStatus(), scenario.getName());
	}
	
	@After("@last")
	public void afterAll() throws IOException {
		report.consolidatedHTMLReportGenerator(status.getPassCount(), status.getFailCount());
	}
	
	
}
