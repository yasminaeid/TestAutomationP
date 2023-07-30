package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.loginPage;

public class baseTests {
    private WebDriver driver;
    protected pages.loginPage loginPage;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://phptravels.net/");
        driver.manage().window().maximize();
        loginPage = new loginPage(driver);

    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}
