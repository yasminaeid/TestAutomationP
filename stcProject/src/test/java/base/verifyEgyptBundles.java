package base;

import org.testng.Assert;
import org.testng.annotations.Test;


public class verifyEgyptBundles extends baseTests {

@Test
    public void testEgyptPackageType(){
//verify package types for Egypt

    Assert.assertEquals(subscribePage.getLightType(),"لايت","type isn't correct");
    Assert.assertEquals(subscribePage.getMainType(),"الأساسية","type isn't correct");
    Assert.assertEquals(subscribePage.getPremiumType(),"بريميوم","type isn't correct");

    }
    // verify package's price
    @Test
    public void testPackagePrice(){

    Assert.assertEquals(subscribePage.getLightPrice(),"0.25","Price doesn't match the expected");
        Assert.assertEquals(subscribePage.getMainPrice(),"0.5","Price doesn't match the expected");
        Assert.assertEquals(subscribePage.getPremiumPrice(),"1","Price doesn't match the expected");
    }

    //verify the currency
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
