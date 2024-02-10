package oynPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class oynLoginPage {

    final private WebDriver driver;

    oynPageBase pageBase;

    public oynLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailTextBox = By.id("mat-input-4");
    By passwordTextBox = By.id("mat-input-1");
    By signInButton = By.xpath("//div//button");

    public oynHomepage login(String email, String password){
        pageBase = new oynPageBase(driver);
        pageBase.populateField(emailTextBox,email);
        pageBase.populateField(passwordTextBox,password);
        pageBase.clickOnElement(signInButton);
        return new oynHomepage(driver);
    }


}
