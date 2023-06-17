package RegisterationTests;

import Base.baseTests;
import Pages.loginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkLogin extends baseTests {



    @Test
    public void testLogin() {
        loginPage login = homePage
                .checkLogin("yasmin_eid@outlook.com", "takeitOrLeaveit");
        Assert.assertEquals(login.getUserName(),
                "Ahlan Yasmina!",
                "user name isn't displayed");
    }


}
