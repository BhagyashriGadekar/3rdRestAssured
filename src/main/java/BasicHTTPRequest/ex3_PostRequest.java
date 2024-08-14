package BasicHTTPRequest;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.testng.annotations.Test;


public class ex3_PostRequest 
{
	@Test(priority = 1)
	public void getAllStudents() 
	{
		LinkedHashMap map=new LinkedHashMap();
		map.put("id", "3");
		map.put("name", "aditya");
		map.put("location", "Pune");
		map.put("phone", 3333);
		
		String [] courcseNames= {"RPA","Power BI"};
		map.put("courses", courcseNames);
		
		
		given()                                        
			.contentType("application/json") 
			.body(map)
		.when()                              
			.post("http://localhost:3000/students")
		.then()	
			.statusCode(201)
			.log().all();		
	}
	
	


}
