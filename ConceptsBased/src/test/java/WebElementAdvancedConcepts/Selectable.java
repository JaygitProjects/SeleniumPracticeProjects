package WebElementAdvancedConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selectable {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/chenni/Documents/Jayanthi/Software/geckodriver");
        driver = new FirefoxDriver();
        String url = "http://www.leafground.com/home.html";
        driver.get(url);
        Thread.sleep(5000);
    }

    @Test
    public void testSelectable() throws InterruptedException {
        WebElement selectable = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[15]/a"));
        selectable.click();

        List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@id=\'selectable\']/li"));
        Thread.sleep(4000);
        System.out.println(listOfElements.size());
        Actions action = new Actions(driver);
   /* action.keyDown(Keys.COMMAND)
                .click(listOfElements.get(0))
                .click(listOfElements.get(1))
                .click(listOfElements.get(2))
                .build().perform();*/
    //or
        action.clickAndHold(listOfElements.get(0)).clickAndHold(listOfElements.get(1)).clickAndHold(listOfElements.get(2)).build().perform();
    Thread.sleep(4000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}