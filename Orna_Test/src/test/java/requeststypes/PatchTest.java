package requeststypes;

 

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

 

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

 

import io.restassured.http.ContentType;

 

public class PatchTest {
    @Test
    public void patchTest() {

        JSONObject jo = new  JSONObject();
        jo.put("name", "John Smith");
        jo.put("job", "Manager");

        System.out.println(jo.toJSONString());

        baseURI="https://reqres.in";
        given()
            .contentType(ContentType.JSON) //OR .accept(ContentType.JSON)
            .body(jo.toJSONString())
        .when()
            .patch("/api/users/2")
        .then()
        .statusCode(200)
        .log().all();
    }
}