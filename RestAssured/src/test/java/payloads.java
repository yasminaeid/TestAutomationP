public class payloads {

    public static String coursesResponse() {

        return "{\n" +
                "\"dashboard\": {\n" +
                "\"purchaseAmount\": 910,\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "},\n" +
                "\"courses\": [\n" +
                "{\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\"price\": 50,\n" +
                "\"copies\": 6\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"Cypress\",\n" +
                "\"price\": 40,\n" +
                "\"copies\": 4\n" +
                "},\n" +
                "{\n" +
                "\"title\": \"RPA\",\n" +
                "\"price\": 45,\n" +
                "\"copies\": 10\n" +
                "}\n" +
                "]\n" +
                "}";
    }

    public static String addBook(String isbn, String aisle) {

        return "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\"" + isbn + "\",\n" +
                "\"aisle\":\"" + aisle + "\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n";

    }

    public static String addProduct(String name) {
        String product = "{\n" +
                "   \"title\":\"" + name + "\"\n" +
                "}";
        return product;
    }

    public static String issuePayload() {

        String issuePayload = "{"+
                "\"fields\": {"+
                "\"project\":{"+
                "\"key\": \"REST\""+
                "},"+
                "\"summary\": \"Issue 5 for adding comment\","+
                "\"issuetype\": {"+
                "\"name\": \"Bug\""+
                "}"+
                "}}";


        return issuePayload;
    }
    public static String addComment() {

        String comment = "{\n" +
                "    \"body\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eget venenatis elit. Duis eu justo eget augue iaculis fermentum. Sed semper quam laoreet nisi egestas at posuere augue semper.\",\n" +
                "    \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Administrators\"\n" +
                "    }\n" +
                "}";


        return comment;
    }

    public static String post(){

        String post = "\n" +
                "{\n" +
                "  \"title\": \"I am in love with someone.\",\n" +
                "  \"userId\": 5\n" +
                "}";
                return post;
    }
}