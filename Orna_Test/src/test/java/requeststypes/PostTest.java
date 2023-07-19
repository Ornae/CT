package requeststypes;

 

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

 

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

 

import io.restassured.http.ContentType;

 

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

 

public class PostTest {
    @Test
    public void postTest() {

        JSONObject jo = new  JSONObject();
        jo.put("name", "Orna");
        jo.put("job", "Developer");

        System.out.println(jo.toJSONString());

        baseURI="https://reqres.in";
        given()
            .contentType(ContentType.JSON) //OR .accept(ContentType.JSON)
            .body(jo.toJSONString())
        .when()
            .post("/api/users")
        .then()
        .statusCode(201)
        .log().all();
    }

 

    

 

}