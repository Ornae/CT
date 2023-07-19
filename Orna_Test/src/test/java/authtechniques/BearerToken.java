package authtechniques;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class BearerToken {
	
@Test	
public void bearerToken() {
	 baseURI="https://api.github.com";
     String bearerToken ="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";
     
      given()
          .headers("Authorization","Bearer "+bearerToken)
      .when()
          .get("/user/repos")
      .then()
      .statusCode(200)
      .log().all();
}
}
