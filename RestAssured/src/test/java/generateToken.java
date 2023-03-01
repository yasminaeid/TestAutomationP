import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class generateToken {
@Test
    public static String token(){
String token =
        given()
                .baseUri("https://dummyjson.com")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"username\": \"kminchelle\", \"password\": \"0lelplR\"}")
                // WHEN
                .when()
                .post("/auth/login")

                // THEN
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .extract()
                .jsonPath()
                .get("token");
return token;

    }

}
