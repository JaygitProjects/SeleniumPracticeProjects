package WebElementAdvancedConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FrameHandle {
    ////*[@id="post-153"]/div[2]/div/ul/li[10]/a/img
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
//Frame element
    public void testFrames() throws InterruptedException {

//Frame Element
    driver.manage().window().maximize();
    WebElement frame =driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[10]/a/img"));
    frame.click();
    Thread.sleep(5000);
//1st frame
    driver.switchTo().frame(0);
    WebElement frame1 = driver.findElement(By.xpath("//*[@id=\"Click\"]"));
    frame1.click();

        System.out.println("Text on the button :" + frame1.getText());


        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.switchTo().frame("frame2");
        WebElement frame2button = driver.findElement(By.id("click1"));
        System.out.println(frame2button.getText());
        driver.switchTo().defaultContent();
//3rd finding number of frames
 List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
        System.out.println("Total number of frames : " + totalFrames.size());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
