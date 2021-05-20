package WebElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxOperations {
    WebDriver webDiver;

    @BeforeTest
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/Raaj/Documents/Jayanthi/Software/geckodriver");
        webDiver = new FirefoxDriver();

        String url = "http://www.leafground.com";
        webDiver.get(url);
        Thread.sleep(3000);
    }
    @Test
    public void testCheckBox() throws InterruptedException {
        WebElement checkbox = webDiver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[7]/a/img"));
        checkbox.click();
//3rd checkbox

        WebElement deSelect = webDiver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div[1]"));
        Thread.sleep(3000);
        if(deSelect.isSelected())
            deSelect.click();
        Thread.sleep(3000);
        WebElement select = webDiver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div[2]"));
        Thread.sleep(3000);
        if(select.isSelected())
            select.click();
        Thread.sleep(3000);

    }
    @AfterTest
    public void tearDown() {
        webDiver.quit();
    }
}
