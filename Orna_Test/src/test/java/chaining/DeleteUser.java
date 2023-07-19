package chaining;

 

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

 

public class DeleteUser {

 

    @Test
    public void deleteUser() {

 

        baseURI = "https://gorest.co.in/";
        String bearerToken = "d1f13ad71f2f5798fc9c7ef51bf436eed89edb70228ba3bd0c401bb17df6fed3";

 

        given().headers("Authorization", "Bearer " + bearerToken).contentType("application/json").when()
                .delete("/public/v2/users/3764735").then().statusCode(204).log().all();
    }

 

}