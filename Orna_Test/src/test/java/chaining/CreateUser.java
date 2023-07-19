package chaining;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import com.github.javafaker.Faker;

 

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

 

public class CreateUser {

 

    @Test
    public void createUser(ITestContext context){
        Faker faker = new Faker();
        JSONObject jo = new JSONObject();
        jo.put("name",faker.name().fullName());
        jo.put("gender","male");
        jo.put("email",faker.internet().emailAddress());
        jo.put("status", "active");
        System.out.println(jo.toJSONString());
        baseURI = "https://gorest.co.in/";
        String BearerToken = "30ffe9ed20d0c58b1de26560e9396af335e4c40a7ea5574af3d0ed9633f264dc";
        int id = given()
        .headers("Authorization", "Bearer "+ BearerToken)
        .contentType("application/json")
        .body(jo.toJSONString())
        .when()
            .post("/public/v2/users")
        .then()
        .statusCode(201)
        .log().all().extract().jsonPath().getInt("id");
        System.out.println("created user id = " + id);
        context.setAttribute("user_id", id);
        }
}