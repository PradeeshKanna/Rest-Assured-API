package basics;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
/// ***** Create Booking (POST Method) - By giving Request JSON directly in the code
		
//		given().log().all().header("Content-Type", "application/json").body("{\r\n"
//				+ "    \"firstname\" : \"Jim\",\r\n"
//				+ "    \"lastname\" : \"Brown\",\r\n"
//				+ "    \"totalprice\" : 111,\r\n"
//				+ "    \"depositpaid\" : true,\r\n"
//				+ "    \"bookingdates\" : {\r\n"
//				+ "        \"checkin\" : \"2018-01-01\",\r\n"
//				+ "        \"checkout\" : \"2019-01-01\"\r\n"
//				+ "    },\r\n"
//				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
//				+ "}")
//		.when().post("booking")
//		.then().assertThat().statusCode(200).body("booking.firstname", equalTo("Jim"));

		
// ***** By passing Request JOSN from external file
//		given().log().all().header("Content-Type", "application/json").body(Payload.CreateBookJSON())
//		.when().post("booking")
//		.then().log().all().assertThat().statusCode(200).body("booking.firstname", equalTo("Jim"));
		
		
//***** Store the response body (JSON) and use JsonPath class
		String response = given().log().all().header("Content-Type", "application/json").body(Payload.CreateBookJSON())
		.when().post("booking")
		.then().assertThat().statusCode(200).body("booking.firstname", equalTo("Jim")).extract().response().asString();
		
		System.out.println(response);	// Will print whole JSON response body

		JsonPath js1= new JsonPath(response);				// Raw to JSON
		String bookingId = js1.getString("bookingid");
		System.out.println(bookingId);	// Will print only the booking ID from JSON response body
		
		
		// Update Booking (PUT Method)	
//		given().log().all().contentType("application/json").accept("application/json").pathParam("id", bookingId).cookie("token","abc123").body("{\r\n"
//				+ "    \"firstname\" : \"Jim_Rename\",\r\n"
//				+ "    \"lastname\" : \"Brown\",\r\n"
//				+ "    \"totalprice\" : 111,\r\n"
//				+ "    \"depositpaid\" : true,\r\n"
//				+ "    \"bookingdates\" : {\r\n"
//				+ "        \"checkin\" : \"2018-01-01\",\r\n"
//				+ "        \"checkout\" : \"2019-01-01\"\r\n"
//				+ "    },\r\n"
//				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
//				+ "}")
//		.when().put("booking/{id}")
//		.then().assertThat().statusCode(200);	
		
		// Get Booking (GET Method - Simple) 
		given().log().all().accept("application/json").pathParam("id", bookingId)
		.when().get("booking/{id}")
		.then().log().all().statusCode(200);
		
		
	}

}
