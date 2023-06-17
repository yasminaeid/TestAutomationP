package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class healthAndBeautyPage {

    private final WebDriver driver;

    @FindBy (id = "productBox-N52895406A")
    WebElement elviveShampoo;

    @FindBy (xpath = "//img[@src=\"https://f.nooncdn.com/mpcms/" +
            "EN0003/assets/8a199699-c63a-4043-88e6-6021a9cd49a0.gif\"]")
    WebElement topPicks;

    public healthAndBeautyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public topPicksPage clickONTopPicks(){
        scrollIntoView(driver,topPicks);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(topPicks));
        topPicks.click();
        return new topPicksPage(driver);
    }

}
