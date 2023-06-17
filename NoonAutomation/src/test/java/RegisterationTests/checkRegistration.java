package RegisterationTests;

import Base.baseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkRegistration extends baseTests {

    @Test
    public void verifyRegistration() {
        homePage.openRegisterForm();
        homePage.clickRegisterPopUp();
        homePage.fillRegisterForm(
                "yasmin_eid@outlook.com",
                "takeitOrLeaveit",
                "Yasmina",
                "Eid");
        Assert.assertEquals(homePage.getUserMenuName(), "My Account", "user menu isn't displayed");
        Assert.assertEquals(homePage.getUserName(), "Ahlan Yasmina!", "Username is wrong");
    }
}
