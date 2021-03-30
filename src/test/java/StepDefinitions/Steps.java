package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import java.time.LocalDate;

public class Steps {
	private static final String BASE_URL = "https://gorest.co.in/";
	private static String token;
	private static Response response;
	private static String jsonString;

	@Given("^API is running$")
    public void checkAPIStatus(){
        String addURI = "https://gorest.co.in/public-api/users";
        System.out.println("Add URL :"+addURI);
   		throw new cucumber.api.PendingException();
	}

	@When("^User sends POST request$")
    public void sendPostRequest(){
        double id = Math.random();
 		LocalDate createdAt = LocalDate.now();
		LocalDate updatedAt = LocalDate.now();
	 
		 RestAssured.baseURI = BASE_URL;
		 RequestSpecification request = RestAssured.given();
		 
		 request.header("Content-Type", "application/json");
		 response = request.body("{\"id\":\""+id+"\",\"name\":\"Charvi K\",\"email\":\"kaul_charvi@williamson.biz\",\"gender\":\"Male\",\"status\":\"Active\",\"created_at\":\""+createdAt+"\",\"updated_at\":\""+updatedAt+"\"}").post("/public-api/users");
		 
		 jsonString = response.asString();
		 token = JsonPath.from(jsonString).get("token");
	    throw new cucumber.api.PendingException();
	}

	@Then("^The user is added$")
	 public void userIsAdded() {
	 Assert.assertEquals(200, response.getStatusCode());
	}


}
