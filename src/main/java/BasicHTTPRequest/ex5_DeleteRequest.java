package BasicHTTPRequest;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.testng.annotations.Test;

public class ex5_DeleteRequest 
{
	@Test(priority = 1)
	public void updateStudentDetails() 
	{		
		given()                              
			.contentType("application/json") 
		.when()                              
			.delete("http://localhost:3000/students/3")
		.then()	
			.statusCode(200)
			.log().all();		
	}
	
	

}
