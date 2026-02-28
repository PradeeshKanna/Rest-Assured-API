package jsonDynamic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

public class JsonDynamic {

	// Dynamically build JSON Payload with external data inputs.
	
	@Test
	public void jsonDynamic() {

		String response = RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		given().log().all().header("Content-Type", "application/json")
			.body(Payload.createBookJSON("Kanna"))
		.when()
			.post("booking")
		.then().assertThat().log().all().statusCode(200);

	}
	

}
