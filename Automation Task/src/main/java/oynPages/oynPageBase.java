package oynPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class oynPageBase {

    final private WebDriver driver;

    public oynPageBase(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToElement(By locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public String getElementText(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement product = driver.findElement(locator);
        return product.getText();
    }

    public void clickOnElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement element = driver.findElement(locator);
        element.click();
    }


    public String checkCartIConAfterAdd(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public String getSuccessMsg(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    public boolean selectRadioButton(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement radioButton = driver.findElement(locator);
        if (!radioButton.isSelected()) {
            // Select the radio button by clicking it
            radioButton.click();
        }

        return false;
    }


    public void selectFromDropDown(By locator, String option) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement dropDownlist = driver.findElement(locator);
        Select dropdown = new Select(dropDownlist);
        dropdown.selectByVisibleText(option);
    }

    public String checkTheOptionSelectedFromdropDown(By locator) {
        return driver.findElement(locator).getText();

    }

    public void populateField(By locator, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }

    public void scrollPage(int pixels)
    {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }
}
