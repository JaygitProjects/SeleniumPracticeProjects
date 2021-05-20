package WebElementBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ButtonOperations {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/Users/Raaj/Documents/Jayanthi/Software/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://www.leafground.com/");
    }
    @Test
    public void buttonOperations() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        WebElement button = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[2]/a/h5"));
        button.click();
        Thread.sleep(6000);


        //2nd button
        WebElement getPositionButton = driver.findElement(By.id("position"));
        Point xyPoint = getPositionButton.getLocation();
        int xValue = xyPoint.getX();
        int yValue = xyPoint.getY();
        System.out.println(" x Co-ordinate = " + xValue);
        System.out.println(" y Co-ordinate = " + yValue);
//3rd button
        WebElement colorButton = driver.findElement(By.id("color"));
        System.out.println(colorButton.getAttribute("style"));
        //or
        System.out.println(colorButton.getCssValue("background-color")); // print result in RGBA format
//4th button

        WebElement sizeButton = driver.findElement(By.id("size"));
        System.out.println(" Button Height : " + sizeButton.getSize().getHeight());
        System.out.println(" Button Width  : " + sizeButton.getSize().getWidth());
//1st button
        WebElement clickButton = driver.findElement(By.id("home"));
        clickButton.click();


        Thread.sleep(3000);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
