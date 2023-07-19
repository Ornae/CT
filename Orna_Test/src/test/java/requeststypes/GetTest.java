package requeststypes;

 

import org.testng.annotations.Test;

 

import io.restassured.http.ContentType;

 

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

 

public class GetTest {

 

    @Test
    public void getTest() {
        baseURI="https://reqres.in/";
        given()
            .queryParam("page", "2") //OR .accept(ContentType.JSON)
        .when()
            .get("/api/users")
        .then()
        .statusCode(200)
        .log().all();
    }

    public void getTestBDD() {
        baseURI="https://reqres.in/";
        given()
            .queryParam("page", "2") //OR .accept(ContentType.JSON)
        .when()
            .get("/api/users")
        .then()
        .statusCode(200)
        .body("data[1].id", equalTo(8)) 
        .body("data.first_name", hasItems("Rachel","Tobias"))  //validate multipule data that we don't know the specific path

        .log().all();
    }
}