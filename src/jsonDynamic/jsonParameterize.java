package jsonDynamic;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class jsonParameterize {
	
	// Parameterize the API test with multiple data sets.

	@Test(dataProvider="Multidataset")
	public void jsonDynamic(String lastName) {

		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		given().log().all().header("Content-Type", "application/json")
			.body(Payload.createBookJSON(lastName))
		.when()
			.post("booking")
		.then().assertThat().log().all().statusCode(200);

	}
	
	@DataProvider(name="Multidataset")
	public Object[][] Data() {
		
		return new Object[][] {{"LastName1"},{"LastName2"},{"LastName3"}};
		
	}
}
