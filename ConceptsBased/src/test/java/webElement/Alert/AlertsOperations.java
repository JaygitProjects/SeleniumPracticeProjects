package webElement.Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertsOperations {
    WebDriver webDiver;
    @BeforeTest
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","/Users/Raaj/Documents/Jayanthi/Software/geckodriver");
        webDiver= new FirefoxDriver();

        String url = "http://www.leafground.com" ;
        webDiver.get(url);
        Thread.sleep(3000);
    }
@Test
public  void testAlerts() throws InterruptedException {
       WebElement alertBox = webDiver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[9]/a/img"));
       alertBox.click();
//Alert box1
       WebElement alertbox1 = webDiver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/button"));
        alertbox1.click();
// handling the alert window
       Alert alert = webDiver.switchTo().alert();
    Thread.sleep(3000);
       alert.accept();
Thread.sleep(3000);
//ok and cancel alert option
    WebElement alertbox2 = webDiver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button"));
    alertbox2.click();
    Alert confirmAlert = webDiver.switchTo().alert();
    Thread.sleep(3000);
    confirmAlert.dismiss();
    Thread.sleep(3000);
//prompt box (3rd )
 //not working
    /*WebElement alertbox3 = webDiver.findElement(By.cssSelector("#contentblock > section > div:nth-child(7) > div > div > button"));
    alertbox2.click();
    Alert promptAlert = webDiver.switchTo().alert();
    Thread.sleep(6000);
    promptAlert.sendKeys("Jay");
    promptAlert.accept();
    Thread.sleep(3000);*/
    }
    @AfterTest
    public void tearDown() {
        webDiver.quit();
    }
}

