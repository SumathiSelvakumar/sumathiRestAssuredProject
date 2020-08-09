package RestAssured;

import static org.hamcrest.Matchers.notNullValue;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredAPI {
	
	private static final String BASE_URI_STRING = "https://gorest.co.in/public-api/users?_format=json&access-token=FWJwqOBz4MuLZumxoUJhnh1OgNQnjbX0WD1p";

	@Test
	public void validate200() {
		baseURI = BASE_URI_STRING;
		given()
		.get()
		.then()
		.statusCode(200)
		.log()
		.all();
	}

	@Test
	public void validateResponseBody() {
		baseURI = BASE_URI_STRING;
		given()
		.get()
		.then()
		.body("_meta", notNullValue())
		.log()
		.all();
	}

	@Test
	public void validateStatusCode() {
		baseURI = BASE_URI_STRING;
		given()
		.get()
		.then()
		.body("_meta.code", equalTo(401))
		.log()
		.all();

	}

	@Test
	public void validateMessage() {
		baseURI = BASE_URI_STRING;
		given()
		.get()
		.then()
		.body("_meta.message", equalTo("Authentication failed."))
		.log()
		.all();
	}

	@Test
	public void validateResultName() {
		baseURI = BASE_URI_STRING;
		given()
		.get()
		.then()
		.body("result.name", equalTo("Unauthorized"))
		.log()
		.all();

	}

	@Test
	public void validateResultMessage() {
		baseURI = BASE_URI_STRING;
		given()
		.get()
		.then()
		.body("result.message", equalTo("Your request was made with invalid credentials."))
		.log()
		.all();

	}

}