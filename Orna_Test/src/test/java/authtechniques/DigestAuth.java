package authtechniques;

 

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

 

import org.testng.annotations.Test;

 

public class DigestAuth {

    @Test
    public void DigestAuth() {
        baseURI = "https://postman-echo.com";

        given()
            .auth().digest("postman", "password")
        .when()
            .get("/basic-auth")
        .then()
            .statusCode(200)
            .body("authenticated", equalTo(true))
            .log().all();

    }
}