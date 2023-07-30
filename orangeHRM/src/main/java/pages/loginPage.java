package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {

    private WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    By usernameCredentials = By.xpath("//label[@class='oxd-label'])[1]");
    By username = By.xpath("//p[normalize-space()='Username : Admin']");

//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

//
//    public String getUsernameText(By element) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
//        String TextLine = driver.findElement(element).getText();
//        return TextLine;
//    }

    public void findCredentials() {
//        wait.until(ExpectedConditions.visibilityOf((WebElement) username));
//      String newUsername = getUsernameText(username);
        System.out.println("hello");
    }
}
