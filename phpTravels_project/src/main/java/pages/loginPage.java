package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {

    private final WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath ="//strong[@class='m-0 text-dark']")
    WebElement accountBtn;

    @FindBy (linkText = "Login")
    WebElement loginBtn;

    public homePage clickLogin(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        accountBtn.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(loginBtn).perform();
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        loginBtn.click();
        return new homePage(driver);
    }
}
