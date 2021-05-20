package WebElementAdvancedConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tool_menuTip {
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
    public void testTipsDisplay(){
        WebElement toolTip = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div[2]/div/ul/li[20]/a"));
        toolTip.click();
        System.out.println(driver.findElement(By.id("age")).getAttribute("title"));

    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
