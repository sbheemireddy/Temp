import io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Payloads;
import io.restassured.RestAssured;


public class Main {

	public static void main(String[] args) {

		System.out.println("hello new world ");
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-type","application/json")
		.body(Payloads.addPlace()).when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		System.out.println("-------------"+js.getString("place_id"));
		
		
		
	}

}
