package WebElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownOperations {
    WebDriver webDiver;

    @BeforeTest
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/chenni/Documents/Jayanthi/Software/geckodriver");
        webDiver = new FirefoxDriver();

        String url = "http://www.leafground.com";
        webDiver.get(url);
        Thread.sleep(3000);
    }

    @Test
    public void testDropdownlist() throws InterruptedException {
// dropdown menu
       WebElement dropDown =  webDiver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[5]/a/h5"));
       dropDown.click();
        Thread.sleep(3000);
//1st Select using Index
        WebElement dDUsingIndex = webDiver.findElement(By.id("dropdown1"));
        Select select = new Select(dDUsingIndex);
        select.selectByIndex(3);
        Thread.sleep(3000);
//2nd select using text
        WebElement dDUsingValuedDUsingText = webDiver.findElement(By.name("dropdown2"));
        Select select1 = new Select(dDUsingValuedDUsingText);
        select1.selectByVisibleText("Selenium");
        Thread.sleep(3000);
// 3rd Select using value
        WebElement dDUsingValue = webDiver.findElement(By.id("dropdown3"));
        Select select2 = new Select(dDUsingValue);
        select2.selectByValue("3");
        Thread.sleep(3000);
/*
// 4th select number of Options
        List <WebElement> dDUsingOption = webDiver.findElements(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/select"));
        int size = dDUsingOption.size();
        System.out.println(size);
        for(WebElement value : dDUsingOption) {

            System.out.println(value);
        }
*/
// 5th select by sending value
        WebElement dDBySendingValue = webDiver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/select"));
        dDBySendingValue.sendKeys("Appium");
/*//6th select the program
        WebElement dDBySelection = webDiver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[6]/select/option[1]"));
        System.out.println(dDBySelection.getTagName());;*/
    }

    @AfterTest
    public void tearDown() {
        webDiver.quit();
    }
}
