package base;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class verifyDjiboutiBundles extends baseTests {
    @BeforeClass
    public void navigation(){
        subscribePage.clickOnCountrybutton();
        subscribePage.selectCountry("dj");
    }

    @Test
    public void testDjiboutiPackageType(){

//verify package types for Emirates
        Assert.assertEquals(subscribePage.getLightType(),"لايت","type isn't correct");
        Assert.assertEquals(subscribePage.getMainType(),"الأساسية","type isn't correct");
        Assert.assertEquals(subscribePage.getPremiumType(),"بريميوم","type isn't correct");
    }

    @Test
    public void testPackagePrice(){

        Assert.assertEquals(subscribePage.getLightPrice(),"2.4","Price doesn't match the expected");
        Assert.assertEquals(subscribePage.getMainPrice(),"4.8","Price doesn't match the expected");
        Assert.assertEquals(subscribePage.getPremiumPrice(),"7.2","Price doesn't match the expected");
    }

    @Test
    public void checkPackageCurrency() {
        int price = subscribePage.getNoOfCurrency();
        for (int i = 0; i < price; i++) {
            String currency =  subscribePage.getCurrency();
            Assert.assertEquals(currency,"دولار أمريكي/شهر","Currency doesn't match");
            System.out.println(currency);
        }

    }

}
