import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getIssueType {

@Test
    public void getIssueTypes(){


        given()
                .baseUri("http://localhost:8080")
                .contentType(ContentType.JSON)
                .body(payloads.issuePayload())
                // WHEN
                .filter(jiraAuthentication.generateJiraToken())
                .when()
                .get(" /rest/api/2/issuetype/10000")

                // THEN
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }
}
