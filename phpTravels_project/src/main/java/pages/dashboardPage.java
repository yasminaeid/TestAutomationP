package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class dashboardPage {
    private final WebDriver driver;

    public dashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (linkText = "Dashboard")
    WebElement dashboardLink;

    @FindBy (xpath = "//a[@href='https://phptravels.net/hotels']")
    WebElement hotels;

    public String getDashboardText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(hotels));
        return dashboardLink.getText();
    }

    public searchHotelsPage clickHotels() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Wait for a maximum of 10 seconds
        wait.until(ExpectedConditions.visibilityOf(hotels));
        hotels.click();
        return new searchHotelsPage(driver);

    }
}
