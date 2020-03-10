package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    @BeforeClass
    public static void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver80.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.navigate().to("https://www.trojmiasto.pl/");
    }



    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}

