package Base;

import Pages.homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class baseTests {

    private WebDriver driver;
    protected Pages.homePage homePage;

    @BeforeClass
    public void setup(){

        System.setProperty("Webdriver.chrome.driver","resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.noon.com/egypt-en/");
        driver.manage().window().maximize();
        homePage = new homePage(driver);

    }


    @AfterClass
    public void tearDown(){

        driver.quit();
    }


}
