package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.subscribePage;

public class baseTests {

    private WebDriver driver;
    protected subscribePage subscribePage;
@BeforeClass
    public void setup(){

        System.setProperty("Webdriver.chrome.driver","resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://subscribe.stctv.com/");
        driver.manage().window().maximize();

        subscribePage = new subscribePage(driver);

    }
@AfterClass
public void tearDown(){

    driver.quit();
}

}
