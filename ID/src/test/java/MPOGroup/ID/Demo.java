package MPOGroup.ID;




import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import static io.restassured.matcher.ResponseAwareMatcher.*;
//import static org.hamcrest.Matchers.*;

public class Demo {
	
	//@Test
	public void test_1() {
		
		Response  response= RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
	}

	@Test
	public void Approach1() {
		
		 RestAssured.baseURI = "https://reqres.in";
	        RequestSpecification request = RestAssured.given();
	 
	        Response response = request.when().get("/api/users?page=2");
	        
	        System.out.println(response.getBody().asString());

	        response.then().statusCode(200);
	       
	       	
	}
	
	
	@Test
	public void Approach2() {
		
		baseURI = "https://reqres.in";
		
		given().get("/api/users?page=2"). 
		then().statusCode(200);
		
	       
	       	
	}
	
	
	

	}//end of class
