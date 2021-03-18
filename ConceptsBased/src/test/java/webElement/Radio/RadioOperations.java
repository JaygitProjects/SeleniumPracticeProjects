package webElement.Radio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioOperations {
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
    public void testRadioButton() throws InterruptedException {
        WebElement radioButton = webDiver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[6]/a/h5"));
        radioButton.click();

        //2nd radio

        WebElement unChecked = webDiver.findElement(By.name("news"));
        System.out.println("unchecked : " + unChecked.isSelected());
        WebElement checked = webDiver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/label[3]"));
        checked.click();
        Thread.sleep(4000);
        System.out.println("checked   : " + checked.isEnabled());
        // 3rd age
        WebElement ageBelow20 = webDiver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/input[1]"));
        ageBelow20.click();
    }

    @AfterTest
    public void tearDown() {
        webDiver.quit();
    }
}
