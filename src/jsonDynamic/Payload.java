package jsonDynamic;

import java.io.File;

public class Payload {
	
	public static String createBookJSON(String lastname) {
		return "{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \""+lastname+"\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
	}

	public static String createBookJSON(File jsonFile) {
		// TODO Auto-generated method stub
		return null;
	}

}
