package addAttachment;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import jsonDynamic.Payload;

// Use "MultiPart" method to send attachment via Rest API
public class AddScreenshot {
	@Test
	public void jsonDynamic() {

		String response = RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		given().log().all().header("Content-Type", "application/json")
			.multiPart("file", new File("C:\\Users\\Downloads\\screenshot.png"))	// KEY is term 'file' and VALUE is 'actual attachment'
			.body("Random JSON...")
		.when()
			.post("booking")
		.then().assertThat().log().all().statusCode(201);

	}
}
