package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class searchHotelsPage {
    private final WebDriver driver;

    @FindBy (id = "select2-hotels_city-container")
    WebElement countryDropdown;

    @FindBy (className = "select2-search__field")
    WebElement countrySearchBox;

    @FindBy (xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
    WebElement searchResult;

    @FindBy (id = "checkin")
    WebElement checkInDatePicker;

    @FindBy (id = "checkout")
    WebElement checkoutDatePicker;

    @FindBy (xpath = "//div[2]/div[1]//tr[5]/td[5]")
    WebElement checkinDate;

    @FindBy (xpath = "//div[3]//tr[6]/td[4]")
    WebElement checkoutDate;

    @FindBy (xpath = "//div[@class='dropdown dropdown-contain']")
    WebElement travellersDropDown;

    @FindBy (xpath = "//div/div/div[4][@class='qtyInc']")
    WebElement roomIncBtn;

    @FindBy (xpath = "//div/div[2]/div//div[2][@class='qtyInc']")
    WebElement adultsNoBtn;

    @FindBy (xpath = "//div/div[3]/div//div[2][@class='qtyInc']")
    WebElement childsNoBtn;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement searchBtn;
    public searchHotelsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCountry(String country) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(countryDropdown));
        countryDropdown.click();
        countrySearchBox.sendKeys(country);
        wait.until(ExpectedConditions.visibilityOf(searchResult));
        searchResult.click();
    }

    public void selectCheckInDate() {
        checkInDatePicker.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(checkinDate));
        checkinDate.click();


    }

    public String getCheckInData() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String date = (String) jse.executeScript("return arguments[0].value", checkInDatePicker);
        System.out.println("Date:- " + date);
        return date;
    }

    public void selectCheckoutData() {
        Actions action = new Actions(driver);
        action.moveToElement(checkoutDatePicker).perform();
        checkoutDate.click();

    }

    public String getCheckoutData() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String date = (String) jse.executeScript("return arguments[0].value", checkoutDatePicker);
        System.out.println("Date:- " + date);
        return date;
    }

    public void selectNumberOfTravellers() {
        travellersDropDown.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(adultsNoBtn).click().perform();
    }

    public void selectNumberOfRooms() {
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOf(roomIncBtn));
        Actions actions = new Actions(driver);
        actions.moveToElement(roomIncBtn).click().perform();
    }

    public void selectNumberOfChildren() {
        Actions actions = new Actions(driver);
        actions.moveToElement(childsNoBtn).click().perform();
    }

    public void clickSearch(){
        searchBtn.click();
    }
}
