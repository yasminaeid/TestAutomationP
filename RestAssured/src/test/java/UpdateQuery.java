import io.restassured.http.ContentType;
import org.json.JSONException;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UpdateQuery extend authTokens {

    @BeforeTest
    public void testOAuthWithPassword() throws JSONException {
        super.testOAuthWithPassword();
    }


    @Test
    public void getQueryIdandEtag(ITestContext context)   {
        // Creating a File instance
        File jsonData = new File("file.json");

        String queryId = given().
                header("Authorization", "Bearer " + Access_Token)
                .baseUri("url")
                .contentType(ContentType.JSON)
                .body(jsonData)
                .when()
                .post("/api/query").
                then().log().all().
                assertThat().
                statusCode(201).
                extract()
                .jsonPath()
                .get("queryId");
// Storing data in a context to use for other tests
        context.setAttribute("queryId", queryId);
//get etag
        String etag = given().
                header("Authorization", "Bearer " + Access_Token)
                .baseUri("url")
                .contentType(ContentType.JSON)
                .when()
                .get("/api/query/" + queryId)
                .then().log().all().
                assertThat().
                statusCode(200).
                extract()
                .headers().getValue("etag");
// Storing data in a context to use for other tests
        context.setAttribute("etag", etag);
        System.out.println(etag);
    }

    @Test
    public void updateQuery(ITestContext context)  {
        String etag = (String) context.getAttribute("etag");
        etag = etag.replace("\"", "");
        String queryId = (String) context.getAttribute("queryId");
        System.out.println((etag));
        System.out.println((queryId));
        given()
                .header("Authorization", "Bearer " + Access_Token)
                .header("If-Match", etag)
                .baseUri("url" + queryId)
                .contentType(ContentType.JSON)
                .body("{ \"status\": \"CLOSED\"}")
                // WHEN
                .when()
                .put("/status")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }
}
