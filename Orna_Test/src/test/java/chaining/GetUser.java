package chaining;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import org.testng.ITestContext;

 

public class GetUser {

 

    @Test
    public void getAllUsers() {
        baseURI = "https://gorest.co.in/";
        String BearerToken = "30ffe9ed20d0c58b1de26560e9396af335e4c40a7ea5574af3d0ed9633f264dc";
        given()
        .headers("Authorization", "Bearer "+ BearerToken)
        .contentType("application/json")
        .when()
            .get("/public/v2/users")
        .then()
        .statusCode(200)
        .log().all();
        }

    @Test
    public void getUserById(ITestContext context) {
        int id = (int) context.getAttribute("user_id");
        baseURI = "https://gorest.co.in/";
        String BearerToken = "30ffe9ed20d0c58b1de26560e9396af335e4c40a7ea5574af3d0ed9633f264dc";
        given()
        .headers("Authorization", "Bearer "+ BearerToken)
        .contentType("application/json")
        .pathParam("id", id)
        .when()
            .get("/public/v2/users/{id}")
        .then()
        .statusCode(200)
        .log().all();
        }
}