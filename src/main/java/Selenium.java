import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class Selenium {
    @Test
    public void Main() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver80.exe");
        String expectedTitle = "Trojmiasto.pl - wiadomości i informacje z Trójmiasta.";
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.trojmiasto.pl/");
        Thread.sleep(400);
        System.out.println("Test of title");
        String actualTitle = driver.getTitle();


        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Title of mainpage is correct!");


        }
        else {
            System.out.println("Main page has incorrect title and is " + actualTitle+"");
        }
        WebElement element = driver.findElement(By.className("ogloszenia-item"));
        WebElement element2 = driver.findElement(By.className("adv-sub-wrap"));
        WebElement element3 = driver.findElement(By.cssSelector("#masthead > ul > " +
                "li.navi-main-icons-item.ogloszenia-item > div > div > ul > li:nth-child(5) > a"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element);
        builder.moveToElement(element2);
        builder.moveToElement(element3);
        builder.click().build().perform();

        System.out.println("Test of advertisement subpage title: move mouse on Adverts element, then " +
                "moving it to all advertisement sub element");
        String properAdvertTitle= "Trojmiasto.pl - Tysiące nowych ofert miesięcznie";
        String actualAdvertTitle = driver.getTitle();
        if (properAdvertTitle.contentEquals(actualAdvertTitle)){
            System.out.println("All advertisement subpage title is correct");
        }
        else{
            System.out.println("All advertisement subpage title is incorrect and is " + actualAdvertTitle + " instead of");
        }

        String properAdvertURL = "https://ogloszenia.trojmiasto.pl/";
        String actualAdvertURL = driver.getCurrentUrl();
        System.out.println("Test of URL correctness:");

        if (properAdvertURL.contentEquals(actualAdvertURL))
            System.out.println("All advertisement subpage URL is correct " );

        else System.out.println("All advertisement subpage URL is incorrect and is " + actualAdvertURL + "");



        driver.quit();


    }

}
