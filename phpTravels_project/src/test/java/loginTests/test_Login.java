package loginTests;

import Base.baseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.dashboardPage;
import pages.homePage;

public class test_Login extends baseTests {

    @Test
    public void checkLogin(){
        homePage home = loginPage.clickLogin();
         dashboardPage dashboard = home.login("yasmineeid01@gmail.com","mamazenab2721");
        Assert.assertTrue(dashboard.getDashboardText().contains("Dashboard"));
    }

}
