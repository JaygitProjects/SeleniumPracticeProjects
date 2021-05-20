package WebElementAdvancedConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dragAndDrop {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/Raaj/Documents/Jayanthi/Software/geckodriver");
        driver = new FirefoxDriver();
        String url = "http://www.leafground.com/home.html";
        driver.get(url);
        Thread.sleep(5000);
    }

    @Test

    public void dragAndDrop(){
        WebElement dragButton = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[14]/a/img"));
        dragButton.click();
        WebElement draggable = driver.findElement(By.id("draggable"));

        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(droppable).release(droppable).build().perform();
   //or
   actions.dragAndDrop(draggable,droppable).build().perform();

    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
