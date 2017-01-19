package steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import org.junit.Assert;

import apis.CountryDetails;

public class TestSteps {
	
	public CountryDetails reservation = new CountryDetails();
	
	@Step
	public void getCountryDetails(String capitalCity){
		String countryName = reservation.getCountryResponse("new delhi");
		
		Serenity.setSessionVariable("countryName").to(countryName);
	}
	
	@Step("Compulsory - Validate if {0} is present in response")
	public void assertValues(String expected, String actual) {
		Assert.assertEquals("Sample message", expected, actual);
	}
	
}
