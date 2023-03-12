import io.restassured.http.ContentType;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class e2eFlowForJiraIssue {

    String jiraToken = jiraAuthentication.generateJiraToken();

    @Test
    public void create(ITestContext context) {


        String issueId = given()
                .baseUri("http://localhost:8080").header("Cookie", "JSESSIONID=" + jiraToken)
                .contentType(ContentType.JSON)
                .body(payloads.issuePayload())
                // WHEN
                .when()
                .post("/rest/api/2/issue")

                // THEN
                .then()
                .assertThat()
//                .statusCode(201)
                .log().all().extract().jsonPath().get("id");

// Storing data in a context to use for other tests
        context.setAttribute("issueId", issueId);
    }

    @Test
    public void updateBug(ITestContext context) {
        String issueId = (String) context.getAttribute("issueId");
        given()
                .baseUri("http://localhost:8080").header("Cookie", "JSESSIONID=" + jiraToken)
                .contentType(ContentType.JSON)
                .body(payloads.addComment())
                // WHEN
                .when()
                .post("/rest/api/2/issue/" + issueId + "/comment")

                // THEN
                .then()
                .assertThat()
                .statusCode(201)
                .log().all();
    }
}
