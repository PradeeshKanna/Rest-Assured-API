package jsonDynamic;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class jsonExternalFile {
	
	// Read JSON from external file
	
	@Test
	public void jsonDynamic() throws IOException {
		
		// Method 1 (Send JSON File Directly as Request Body) !Recommended
		File jsonFile = new File("C:\\Users\\Pradeesh Kanna B\\Downloads\\AddBook.json");
		
		// Method 2 (Read JSON as String) Convert to Byte --> Convert to String
//		byte[] byte_content = Files.readAllBytes(Paths.get("C:\\Users\\Pradeesh Kanna B\\Downloads\\AddBook.json"));
//		String string_content = new String(byte_content);

		String response = RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		given().log().all().header("Content-Type", "application/json")
			.body(jsonFile)
		.when()
			.post("booking")
		.then().assertThat().log().all().statusCode(200);

	}
}
