package base;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class verifyEmiratesBundles extends baseTests{

    verifyEgyptBundles page = new verifyEgyptBundles();


    @BeforeClass
    public void navigation(){
        subscribePage.clickOnCountrybutton();
        subscribePage.selectCountry("ae");
    }

    @Test
    public void testEmiratesPackageType(){

//verify package types for Emirates
        Assert.assertEquals(subscribePage.getLightType(),"لايت","type isn't correct");
        Assert.assertEquals(subscribePage.getMainType(),"الأساسية","type isn't correct");
        Assert.assertEquals(subscribePage.getPremiumType(),"بريميوم","type isn't correct");
    }

    @Test
    public void testPackagePrice(){

        Assert.assertEquals(subscribePage.getLightPrice(),"5.4","Price doesn't match the expected");
        Assert.assertEquals(subscribePage.getMainPrice(),"10.9","Price doesn't match the expected");
        Assert.assertEquals(subscribePage.getPremiumPrice(),"16.3","Price doesn't match the expected");
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
