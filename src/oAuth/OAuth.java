package oAuth;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;

public class OAuth {
	public static void main(String[] args) {
	// *****  Whole API Contracts must be given by Developer *****
		
	// Authorization Server EndPoint
	String response1 = given()
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
	
	JsonPath js = new JsonPath(response1);
	String accessToken = js.getString("access_token");
	System.out.println("Access Token is: "+ accessToken);
	
	// GetCourseDetails EndPoint (Secured by OAuth)
	String response = given().queryParam("access_token", accessToken)
	.when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();
	
	System.out.println(response);
	
	}
}
