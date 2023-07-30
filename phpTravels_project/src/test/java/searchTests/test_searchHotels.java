package searchTests;

import Base.baseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.dashboardPage;
import pages.homePage;
import pages.searchHotelsPage;

public class test_searchHotels extends baseTests {

    @Test
    public void testSearchHotel(){
        homePage home = loginPage.clickLogin();
        dashboardPage dashboard = home.login("yasmineeid01@gmail.com","mamazenab2721");
        searchHotelsPage searchHotelsPage = dashboard.clickHotels();
        searchHotelsPage.selectCountry("Dubai");
        searchHotelsPage.selectCheckInDate();
        Assert.assertEquals(searchHotelsPage.getCheckInData(),"27-07-2023");
        searchHotelsPage.selectCheckoutData();
        Assert.assertEquals(searchHotelsPage.getCheckoutData(),"02-08-2023");
        searchHotelsPage.selectNumberOfTravellers();
        searchHotelsPage.clickSearch();



    }
}
