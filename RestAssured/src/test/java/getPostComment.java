import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class getPostComment {

    String token = generateToken.token();
//@Test
//    public void addPost(){
//
//    posts p =   given()
//                .header("Authorization", "Bearer " + token)
//               .expect()
//               .defaultParser(Parser.JSON)
//
//                // WHEN
//                .when()
//                .post("https://dummyjson.com/posts/add")
//               .as(posts.class);
//       System.out.println(p.getId());
//
//    }

    //creating a list of posts
    List<postResponse> posts = new ArrayList<postResponse>();

@Test
    public void getAllPosts(){


       postResponse response = given()
                .expect()
                .defaultParser(Parser.JSON)
                // WHEN
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
               .as(postResponse.class);

    }


}
