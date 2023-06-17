package addProductsTests;

import Base.baseTests;
import Pages.healthAndBeautyPage;
import Pages.loginPage;
import Pages.topPicksPage;
import org.testng.annotations.Test;

public class addSingleProduct extends baseTests {

    @Test
    public void addProduct(){
        loginPage login = homePage.checkLogin("yasmin_eid@outlook.com","DFDFxcv2121");
       healthAndBeautyPage healthAndBeautyPage = login.clickOnCategoryMenu();
        topPicksPage topPicksPage = healthAndBeautyPage.clickONTopPicks();

    }
}
