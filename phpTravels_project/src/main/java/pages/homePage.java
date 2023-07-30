package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

    private final WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy (name = "email")
    WebElement email;

    @FindBy (name = "password")
    WebElement password;

    @FindBy (id = "submitBTN")
    WebElement submitBtn;


    public dashboardPage login(String Email,String Password){
        email.sendKeys(Email);
        password.sendKeys(Password);
        submitBtn.click();
        return new dashboardPage(driver);
    }


}
