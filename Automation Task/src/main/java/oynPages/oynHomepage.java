package oynPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class oynHomepage {

    final private WebDriver driver;

    oynPageBase pageBase;

    public oynHomepage(WebDriver driver) {
        this.driver = driver;
    }

    By dashboardText = By.xpath("//dashboard/p");
    By userAccountImg = By.xpath("//div[@class=\"user\"]");
    By logoutBtn = By.xpath("//ul[@class='dropdown']/li[3]");
    By signInText = By.xpath("//div/h3");

    public String getDashboardText(){
        pageBase = new oynPageBase(driver);
        return pageBase.getElementText(dashboardText);
    }
public void logOut(){
    pageBase = new oynPageBase(driver);
        pageBase.clickOnElement(userAccountImg);
        pageBase.clickOnElement(logoutBtn);

}
    public String getSignInText(){
        return pageBase.getElementText(signInText);
    }
}
