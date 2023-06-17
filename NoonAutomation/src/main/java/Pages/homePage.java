package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class homePage {

    private final WebDriver driver;


    public homePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "dd_header_signInOrUp")
    WebElement firstRegisterBtn;

    @FindBy (xpath = "//h3[@class='sc-58e23d11-7 flXQrt']")
    WebElement popUpRegisterBtn;

    @FindBy (id = "emailInput")
    WebElement emailInput;

    @FindBy (id = "passwordInput")
    WebElement passwordInput;

    @FindBy (id = "firstNameInput")
    WebElement firstNameInput;

    @FindBy (id = "lastNameInput")
    WebElement lastNameInput;

    @FindBy (id = "login-submit")
    WebElement createBtn;

    @FindBy (className = "userName")
    WebElement username;
    @FindBy (xpath = "//span[@data-qa='dd_user_menu']")
    WebElement myAccount;

    public void openRegisterForm() {
        firstRegisterBtn.click();
    }

    public void clickRegisterPopUp() {
        popUpRegisterBtn.click();
    }

    public void fillRegisterForm(String email, String passWord,
                                 String firstName, String lastName) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(passWord);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        createBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(myAccount));

    }

    public String getUserName() {
        return username.getText();
    }

    public String getUserMenuName() {
        return myAccount.getText();
    }

    public loginPage checkLogin(String email, String Password) {
        firstRegisterBtn.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys(Password);
        createBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(username));
        return new loginPage(driver);

    }

}
