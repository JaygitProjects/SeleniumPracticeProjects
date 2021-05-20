package WebElementAdvancedConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class AutoComplete {


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
    public void testAutoComplete() throws InterruptedException {
        WebElement autoComplete = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[17]/a/h5"));
        autoComplete.click();

        WebElement textBox = driver.findElement(By.id("tags"));
        textBox.sendKeys("s");
        Thread.sleep(4000);

        List<WebElement> textItems = driver.findElements(By.xpath("//*[@id=\"ui-id-1\"]/li"));
        Thread.sleep(4000);
        System.out.println(textItems.size());
        for (WebElement textItem : textItems) {
            if (textItem.getText().equalsIgnoreCase("SOAP")) {

                textItem.click();
                Thread.sleep(4000);
                System.out.println(textItem.getText());
            }

        }
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

