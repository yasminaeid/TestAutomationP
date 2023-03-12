import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getIssueType {

    String jiraToken = jiraAuthentication.generateJiraToken();
@Test
    public void getIssueTypes(){


        given()
                .baseUri("http://localhost:8080").header("cookie",jiraToken)
                .contentType(ContentType.JSON)
                .body(payloads.issuePayload())
                // WHEN
                .when()
                .get(" /rest/api/2/issuetype/10000")

                // THEN
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }
}
