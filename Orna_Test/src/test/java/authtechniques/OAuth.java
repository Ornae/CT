package authtechniques;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;


public class OAuth {
	
	 @Test
	    public void oAuth() {

	       baseURI="https://api.github.com";
	       String token ="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";
	        given()
	            .auth().oauth2(token)
	        .when()
	            .get("/user/repos")
	        .then()
	        .statusCode(200)
	        .log().all();
	    }

}
