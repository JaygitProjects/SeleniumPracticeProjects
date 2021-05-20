package JavaScriptExecuteorDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DemoJavaScriptExecutor {

    WebDriver driver;


    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        /*JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript(Script,args);*/


    }

    @Test
    public void testBorder() throws IOException, InterruptedException {

        //bordering and getting screenShots
        WebElement border = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
        JavaScriptUtil.drawBorder(border, driver);
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File dest = new File("/Users/Raaj/Documents/Jayanthi/Java/JayPractice/Try/Screenshots/border1.png");
        FileUtils.copyFile(src, dest);

        //get the title
        System.out.println(JavaScriptUtil.getTitle(driver));

        //click the element
        WebElement register = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        JavaScriptUtil.clickElement(register, driver);
        Thread.sleep(1000);

        //creating an alert
       /* JavaScriptUtil.sendAlert(driver, "Alert created by me");
        Thread.sleep(2000);*/

        //refresh the screen
        JavaScriptUtil.refresh(driver);
        Thread.sleep(2000);
        //scroll up the window
        JavaScriptUtil.scrollUp(driver);
        Thread.sleep(3000);

        //scrool down the window
        JavaScriptUtil.scrollDown(driver);
        Thread.sleep(3000);
        //Zoom the page
        JavaScriptUtil.zoomPage(driver);
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}