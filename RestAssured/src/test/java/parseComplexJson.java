import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class parseComplexJson {

    JsonPath js = new JsonPath(payloads.coursesResponse()); /*print no of courses*/

    @Test
    public int getNumberOfCourses() {
        int coursesCount = js.getInt("courses.size()");
        Assert.assertEquals(coursesCount, 3, "courses Count is 3");
        return coursesCount;
    }

    /*Print Purchase Amount*/

    @Test
    public void getPurchaseAmount() {
        int purchaseAmount = js.get("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);
    }
    /*print title of first course*/

    @Test
    public void getTitleOfFirstCourse() {
        String title = js.get("courses[0].title");
        System.out.println(title);
    }

    //Print All course titles and their respective Prices
    @Test
    public void getAllTitlesAndPrices() {
        for (int i = 0; i < getNumberOfCourses(); i++) {
            String titles = js.get("courses[" + i + "].title");
            String prices = js.get("courses[" + i + "].price").toString();
            System.out.println(titles);
            System.out.println(prices);
        }

    }

    //Print no of copies sold by RPA Course
    @Test
    public void coursesCopy() {
        for (int i = 0; i < getNumberOfCourses(); i++) {
            String titles = js.get("courses[" + i + "].title");
            if (titles.equalsIgnoreCase("RPA")) {
                int copies = js.get("courses["+i+"].copies");
                System.out.println("RBA course's copy are " + copies);
                break;
            }
        }
    }
}
