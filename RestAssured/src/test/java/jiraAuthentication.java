import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class jiraAuthentication {

    @Test
    public static String generateJiraToken() {

        String jiraToken = given()
                .baseUri("http://localhost:8080")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"username\": \"yasmine.eid\", \"password\": \"Mamazenab2721@@\"}")
                // WHEN
                .when()
                .post("/rest/auth/1/session")

                // THEN
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .extract()
                .jsonPath()
                .get("session.value");

        return jiraToken;

    }


}

