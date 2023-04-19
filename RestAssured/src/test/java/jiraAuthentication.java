import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class jiraAuthentication {

    @Test
    public static SessionFilter generateJiraToken() {
        // to store the session
        SessionFilter session = new SessionFilter();
        String response = given()
                .baseUri("http://localhost:8080")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"username\": \"yasmine.eid\", \"password\": \"goldieminimEOldie\"}")
                // WHEN
                .filter(session)
                .when()
                .post("/rest/auth/1/session")

                // THEN
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .extract()
                .response()
                .toString();
return session;
    }


}

