package Queries_APIs;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;

public class createQuery extends Authtokens {


    @Override
    @BeforeTest
    public void testOAuthWithPassword() throws JSONException {
        super.testOAuthWithPassword();
    }

    @Test
    public String createPremiumQuery() {
        // Creating a File instance
        File jsonData = new File("src/test/java/TestData/PremiumQuery.json");

// GIVEN
        String queryId =
        given()
                .header("Authorization", "Bearer " + Access_Token)
                .baseUri("url")
                .contentType(ContentType.JSON)
                .body(jsonData)
                // WHEN
                .when()
                .post("/api/query")

                // THEN
                .then()
                .assertThat()
                .statusCode(201)
                .log().all()
                .assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema
                                (new File("src/test/java/TestData/premiumQuerySchema.json")))
                .extract()
                .jsonPath()
                .get("queryId");

        return queryId;



    }

    @Test
    public void createTreatyQuery() {
        // Creating a File instance
        File jsonData = new File("src/test/java/TestData/TreatyQuery.json");

// GIVEN
        given()
                .header("Authorization", "Bearer " + Access_Token)
                .baseUri("https://ququev.lm-tst101.com")
                .contentType(ContentType.JSON)
                .body(jsonData)
                // WHEN
                .when()
                .post("/api/query")

                // THEN
                .then()
                .assertThat()
                .statusCode(201)
                .log().all()
                .assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(new File("src/test/java/TestData/treatySchema.json")));


    }


    @Test
    public void createClaimQuery(ITestContext context) {
        // Creating a File instance
        File jsonData = new File("src/test/java/TestData/claimQuery.json");

// GIVEN
        String queryId =
                given()
                        .header("Authorization", "Bearer " + Access_Token)
                        .baseUri("https://ququev.lm-tst101.com")
                        .contentType(ContentType.JSON)
                        .body(jsonData)
                        // WHEN
                        .when()
                        .post("/api/query")

                        // THEN
                        .then()
                        .assertThat()
                        .statusCode(201)
                        .log().all()
                        .assertThat()
                        .body(JsonSchemaValidator.
                                matchesJsonSchema
                                        (new File("src/test/java/TestData/claimQuerySchema.json")))
                        .extract()
                        .jsonPath()
                        .get("queryId");
        // Storing data in a context to use for other tests
        context.setAttribute("queryId", queryId);

    }

    @Test
    public void verifyONStatusCode(ITestContext context) {
        String queryId = (String) context.getAttribute("queryId");

        given()
                .header("Authorization", "Bearer " + Access_Token)
                .baseUri("https://ququev.lm-tst101.com")
                .contentType(ContentType.JSON)
                // WHEN
                .when()
                .get("/api/query/" + queryId)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void verifyOnQueryStatus(ITestContext context) {
        String queryId = (String) context.getAttribute("queryId");

        //get response
        Response response = given()
                .header("Authorization", "Bearer " + Access_Token)
                .baseUri("https://ququev.lm-tst101.com")
                .contentType(ContentType.JSON)
                .get("/api/query/" + queryId);

        //response body
        ResponseBody body = response.getBody();

        //convert body to string
        String bodyString = body.asString();

        //get jsonPath
        JsonPath path = response.jsonPath();

        //Get value of status
        String status = path.get("status");
        System.out.println((status));

        //Verify status value
        Assert.assertTrue(status.equals("ACTIVE"));


    }
@Test
    public String getQueryId(){
       String queryId=  createPremiumQuery();
    return queryId;
}




}





