package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.loginPage;

public class basetests {

    protected WebDriver driver;
//    protected loginPage login;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();


    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}
