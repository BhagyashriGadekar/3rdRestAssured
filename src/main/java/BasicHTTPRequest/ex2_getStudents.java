package BasicHTTPRequest;


import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class ex2_getStudents 
{
	@Test(priority = 1)
	public void getAllRequest() 
	{
	          given() 
	                   .contentType("application/json") 
	           .when() 
	           .get("http://localhost:3000/students")
	           .then()
	           .statusCode(200)
	                       .body("[0].id", equalTo("1"))
                           .body("[1].courses[1]", equalTo("appium"))
	           .log().all();
	}
	
	@Test(priority = 2, enabled = false)
	public void getSingleStudnet() 
	{
	       given() 
	          .contentType("application/json") 
	          .when() 
	          .get("http://localhost:3000/students/1")
	          .then()
	          .statusCode(200)
	                      .body("id", equalTo("1"))
	                      .body("name", equalTo("john"))
	                      .body("courses[0]", equalTo("Java"))
	          .contentType(ContentType.JSON)
	          //.contentType("application/json")
	        .log().all();
	}

}
