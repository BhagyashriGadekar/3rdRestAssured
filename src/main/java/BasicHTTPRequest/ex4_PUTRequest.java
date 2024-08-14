package BasicHTTPRequest;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.testng.annotations.Test;

public class ex4_PUTRequest 
{
	
	@Test(priority = 1)
	public void updateStudentDetails() 
	{
		LinkedHashMap map=new LinkedHashMap();
		map.put("id", "3");
		map.put("name", "ADITYA");
		map.put("location", "PUNE");
		map.put("phone", 3333);
		
		String [] courcseNames= {"RPA","Power BI"};
		map.put("courses", courcseNames);
		
		
		given()                              
			.contentType("application/json") 
			.body(map)
		.when()                              
			.put("http://localhost:3000/students/3")
		.then()	
			.statusCode(200)
			.log().all();		
	}
}
