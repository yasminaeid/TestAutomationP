package Queries_APIs;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;


public class getQueryById extends Authtokens {


    @Override @BeforeTest
    public void testOAuthWithPassword() throws JSONException {
        super.testOAuthWithPassword();
    }

    @Test
    public void checkSuccessResponse() {

        RequestSpecification authorization = given().
                header("Authorization", "Bearer " + Access_Token);
                authorization.get("url").
                then().log().all().
                assertThat().
                statusCode(200);
    }

    @Test
    public void validateSchema(){

        RequestSpecification authorization = given().
                header("Authorization", "Bearer " + Access_Token);
        authorization.get("url").
                then().
                assertThat()
                .body(JsonSchemaValidator.
                matchesJsonSchema(new File("src/test/java/TestData/GetQuerySchema.json")));


    }



}
