package requeststypes;

 

import io.restassured.http.ContentType;

 

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

 

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

 

public class PutTest {
    @Test
    public void putTest() {

        JSONObject jo = new  JSONObject();
        jo.put("name", "JohnSmith");
        jo.put("job", "Tester");

        System.out.println(jo.toJSONString());

        baseURI="https://reqres.in";
        given()
            .contentType(ContentType.JSON) //OR .accept(ContentType.JSON)
            .body(jo.toJSONString())
        .when()
            .put("/api/users/2")
        .then()
        .statusCode(200)
        .log().all();
    }

 

}