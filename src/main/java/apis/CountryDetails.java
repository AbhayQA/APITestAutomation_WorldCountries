package apis;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.ResponseBody;

import excel.KeyMapper;
import static net.serenitybdd.rest.SerenityRest.rest;

public class CountryDetails {
	
	public String getCountryResponse(String capitalCity) {
		ResponseBody getCountyDetails = rest().given().get("http://restcountries.eu/rest/v1/capital/"+capitalCity).body();
		
		System.out.println(getCountyDetails.toString());
		
		JsonPath jp = new JsonPath(getCountyDetails.asString());
		return jp.get(KeyMapper.country_name).toString();
	}
	
}
