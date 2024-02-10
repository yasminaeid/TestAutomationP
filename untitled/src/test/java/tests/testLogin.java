package tests;

import Base.baseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import oynPages.oynHomepage;
import oynPages.oynLoginPage;


public class testLogin extends baseTests {

    @Test (priority = 1)
    public void testLogin(){
    oynLoginPage loginPage = new oynLoginPage(driver);
    oynHomepage homepage = loginPage.login("store@admin.com","P@ssw0rd");
     Assert.assertEquals(homepage.getDashboardText(),"Welcome To Dashboard"
             ,"text message isn't correct");

}
@Test (priority = 2)
    public void testLogout(){
        oynHomepage homepage = new oynHomepage(driver);
       homepage.logOut();
       Assert.assertEquals(homepage.getSignInText(),"Sign In");
}
}
