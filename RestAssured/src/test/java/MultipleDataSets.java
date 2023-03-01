import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MultipleDataSets {

    String token = generateToken.token();

@DataProvider(name = "products")
    public Object [][] getData(){

  return   new Object[][] {{"bags"},{"perfume"}, {"body cream"}};

}
@Test(dataProvider = "products")
    public void addBook(String name){

    given()
            .header("Authorization", "Bearer " + token)
            .baseUri("https://dummyjson.com")
            .contentType(ContentType.JSON)
            .body(payloads.addProduct(name))
            // WHEN
            .when()
            .post("/products/add")
            // THEN
            .then()
            .assertThat()
            .statusCode(200)
            .log().all();

}
}
