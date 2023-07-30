package loginTests;

import Base.basetests;
import org.testng.annotations.Test;
import pages.loginPage;

public class test_login extends basetests {

    loginPage loginPageObject;
    @Test
    public void getUserName(){
        loginPageObject = new loginPage(driver);
        loginPageObject.findCredentials();
    }
}
