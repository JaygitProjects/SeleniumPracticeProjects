package WebElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TextBoxOperations {
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
    public void testTextBox(){
        webDiver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 //link to edit option
        WebElement editButton = webDiver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[1]/a"));
        editButton.click();
//1St textbox
       WebElement emailBox = webDiver.findElement(By.id("email"));
       emailBox.sendKeys("jay@gmail.com");
//2nd text box
       WebElement appendBox =  webDiver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input"));
       appendBox.sendKeys("Jay");

// 3rd text box

       WebElement textEnteredBox = webDiver.findElement(By.name("username"));
       String value = textEnteredBox.getAttribute("value");
        System.out.println("Value of the text box :" + value);

//4th textbox
        WebElement clearTextBox = webDiver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div/div/input"));
        clearTextBox.clear();

//5th text box
        WebElement disabledTextBox = webDiver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/div/div/input"));
       /*String value2 = disabledTextBox.getAttribute("disabled");
       if (value2 == "True")

           System.out.println("Text Box is Disabled");
       else
           System.out.println("Text Box is Enabled");*/
        //or
        boolean disabled = disabledTextBox.isEnabled();
        System.out.println(disabled);


    }
    @AfterTest
    public void tearDown(){
        webDiver.quit();
    }
}


