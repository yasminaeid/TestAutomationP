package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {

    final private WebDriver driver;


    @FindBy (className = "userName")
    WebElement userName;

    @FindBy (xpath = "//div[@class='jsx-undefined trigger']")
    WebElement categoriesMenu;

    @FindBy (linkText = "Beauty & Health")
    WebElement healthAndBeauty;


    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUserName() {
        return userName.getText();
    }

    public healthAndBeautyPage clickOnCategoryMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(categoriesMenu).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(healthAndBeauty));
        actions.moveToElement(healthAndBeauty).perform();
        String text = healthAndBeauty.getText();
        System.out.println(text);
        healthAndBeauty.click();
        return new healthAndBeautyPage(driver);

    }



}
