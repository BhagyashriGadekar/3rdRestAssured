package BasicHTTPRequest;


import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ex1_getRequest
{
	@Test(priority=1)
	
	public void getRequest_ValidID() 
	{
	   given() // Pre-req
	    .contentType("application/json") 
	    .when() //request type get()/post()/put()/delete()
	    .get("https://reqres.in/api/users/2")
	    .then() //validation
	    .statusCode(200)
	    .body("data.first_name", equalTo("Janet"))
	    .body("data.last_name", equalTo("Weaver"))
	    .body("data.id", equalTo(2))
	    .contentType("application/json")
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
