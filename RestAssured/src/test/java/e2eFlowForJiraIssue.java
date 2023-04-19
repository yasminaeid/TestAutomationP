import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.sessionId;

public class e2eFlowForJiraIssue {

    @Test
    public void create(ITestContext context) {


        String issueId = given()
                .baseUri("http://localhost:8080")
                .contentType(ContentType.JSON)
                .body(payloads.issuePayload())
                // WHEN
                .filter(jiraAuthentication.generateJiraToken())
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

     String commentId=   given()
                .baseUri("http://localhost:8080")
                .contentType(ContentType.JSON)
                .body(payloads.addComment())
                // WHEN
             .filter(jiraAuthentication.generateJiraToken())
                .when()
                .post("/rest/api/2/issue/" + issueId + "/comment")

                // THEN
                .then()
                .assertThat()
                .statusCode(201)
                .log().all()
                .extract()
                .jsonPath()
                .get("id");

        context.setAttribute("commentId", commentId);
    }

    @Test
    public void verifyTheAddedComments(ITestContext context){
        String commentId = (String) context.getAttribute("commentId");
        String issueId = (String) context.getAttribute("issueId");
        given()
                .baseUri("http://localhost:8080")
                .contentType(ContentType.JSON)
                // WHEN
                .filter(jiraAuthentication.generateJiraToken())
                .when()
                .queryParam("fields","comment")
                .get("rest/api/2/issue/"+issueId+"")

                // THEN
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();


    }
}
