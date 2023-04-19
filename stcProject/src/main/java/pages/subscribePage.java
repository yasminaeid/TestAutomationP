package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.security.PublicKey;

public class subscribePage {

    private WebDriver driver;

    public subscribePage(WebDriver driver) {
        this.driver = driver;
    }


    public String setPackageType(String locator) {

        String packageType = driver.findElement(By.id(locator)).getText();

        return packageType;
    }

    public String setPrice(String locator) {

        String price = driver.findElement(By.xpath(locator)).getText();
        return price;
    }

    public String getLightType() {
        String lightType = setPackageType("name-لايت");
        return lightType;
    }

    public String getPremiumType() {
        String premiumType = setPackageType("name-بريميوم");
        return premiumType;
    }

    public String getMainType() {
        String maintype = setPackageType("name-الأساسية");
        return maintype;
    }

    public String getLightPrice() {

        String lightPrice = setPrice("//*[@id=\"currency-لايت\"]/b");
        return lightPrice;
    }

    public String getMainPrice() {

        String mainPrice = setPrice("//*[@id=\"currency-الأساسية\"]/b");
        return mainPrice;
    }

    public String getPremiumPrice() {

        String premiumPrice = setPrice("//*[@id=\"currency-بريميوم\"]/b");
        return premiumPrice;
    }

    public int getNoOfCurrency() {
        int count = driver.findElements(By
                .xpath("//div[@class='price']//i")).size();
        return count;
    }

    public String getCurrency() {

        String currency = driver.findElement(By.xpath("//div[@class='price']//i")).getText();
        return currency;
    }

    public void clickOnCountrybutton() {
        driver.findElement(By.id("country-btn")).click();

    }

    public void selectCountry(String locator) {
        driver.findElement(By.id(locator)).click();
    }

}