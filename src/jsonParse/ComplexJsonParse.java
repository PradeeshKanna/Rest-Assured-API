package jsonParse;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComplexJsonParse {

	@Test
	public void JsonParse() {

		JsonPath js = new JsonPath(Payload.JsonBody());

		// 1. Print total Course count
		int count = js.getInt("courses.size()");
		System.out.println(count); 				// Output: 3

		// 2. Print Purchase Amount
		int TotalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(TotalAmount); 		// Output: 910

		// 3. Print title of first course
		String TitleFirstCourse = js.get("courses[0].title");
		System.out.println(TitleFirstCourse); 	// Output: Selenium

		// 4. Print all course titles and their respective Prices
		for (int i = 0; i < count; i++) {
			String courseTitle = js.get("courses[" + i + "].title");
			System.out.println("CourseTitle: " + courseTitle);

			int coursePrice = js.getInt("courses[" + i + "].price");
			System.out.println("CoursePrice: " + coursePrice);
		}

		// 5. Print no.of.copies sold by RPA course
		for (int i = 0; i < count; i++) {
			String courseTitle = js.get("courses[" + i + "].title");
			if (courseTitle.equalsIgnoreCase("RPA")) {
				int copies = js.getInt("courses[" + i + "].copies");
				System.out.println("RPA Copies: " + copies); 	// Output: 10
			}
		}

		// 6. Verify if sum of all course prices matches the purchase amount

		int sum = 0;

		for (int i = 0; i < count; i++) {
			int Price = js.getInt("courses[" + i + "].price");
			int Copies = js.getInt("courses[" + i + "].copies");

			int amount = Price * Copies;
			sum = sum + amount;
		}
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");

		Assert.assertEquals(sum, purchaseAmount);

	}

}
