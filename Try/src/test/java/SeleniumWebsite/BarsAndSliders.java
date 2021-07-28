package SeleniumWebsite;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BarsAndSliders {
    WebDriver driver;
    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver_3");
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/");
        //  driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (driver.findElement(By.id("at-cv-lightbox-content")).isEnabled()) {
             driver.findElement(By.linkText("No, thanks!")).click();

        /*    WebElement cookie = driver.findElement(By.linkText("No, thanks!"));
            if (cookie.isEnabled()) {
                if (cookie.getText().equalsIgnoreCase("No, thanks!"))
                    cookie.click();
                driver.findElement(By.linkText("No, thanks!")).click();
            }

         */
        }
    }


        @Test(priority = 1,enabled = false)
        public void testJQueryDownloadBar() throws InterruptedException {
            System.out.println("********** JQuery UI Progress bar  **********");

            //Progress Bars & Sliders
            driver.findElement(By.linkText("Progress Bars & Sliders")).click();
            //JQuery Download Progress bars
            driver.findElement(By.linkText("JQuery Download Progress bars")).click();
            //download button
            driver.findElement(By.xpath("//button[@class='btn btn-primary' or @id='downloadButton']")).click();
          //  Thread.sleep(2000);
            //button[@class='btn btn-primary' or @id='downloadButton']
            WebDriverWait wait = new WebDriverWait(driver, 10);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Complete!')]")));

            driver.findElement(By.xpath("//div/button[text()='Close']")).click();

        }
        @Test(priority = 2,enabled = false)
         public void testBootstrapProgressBar() throws InterruptedException {

            System.out.println(" ************ Bootstrap Progress bar ************");
            //Progress Bars & Sliders
            driver.findElement(By.linkText("Progress Bars & Sliders")).click();
//Bootstrap Progress bar
            driver.findElement(By.linkText("Bootstrap Progress bar")).click();
//download button
            driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary active' or @id='cricle-btn']")).click();
//wait
// //button[@class='btn btn-block btn-primary active' or @id='cricle-btn']
            WebDriverWait wait = new WebDriverWait(driver, 25);
           WebElement element = driver.findElement(By.xpath("//div[@class='percenttext']"));
            wait.until(ExpectedConditions.textToBePresentInElement(element,"100"));
    }
    @Test(priority = 3)
    public  void testDragDropSliders(){
        System.out.println("****************** Drag & Drop Sliders ***************");
        //Progress Bars & Sliders
        driver.findElement(By.linkText("Progress Bars & Sliders")).click();
  //Drag & Drop Sliders
  driver.findElement((By.linkText("Drag & Drop Sliders"))).click();
  //slider 1
        driver.findElement(By.id("slider1")).click();
       String initialValue = driver.findElement(By.cssSelector("#slider1 div output")).getText();
       
        System.out.println(initialValue);
//slider 2
        driver.findElement(By.id("slider1")).click();
        String initialValue2 = driver.findElement(By.cssSelector("#slider2 div output")).getText();
        System.out.println(initialValue2);
//slider 3
        driver.findElement(By.id("slider1")).click();
        String initialValue3 = driver.findElement(By.cssSelector("#slider3 div output")).getText();
        System.out.println(initialValue3);
//slider 4
        driver.findElement(By.id("slider1")).click();
        String initialValue4 = driver.findElement(By.cssSelector("#slider4 div output")).getText();
        System.out.println(initialValue4);
//slider 5
        driver.findElement(By.id("slider1")).click();
        String initialValue5 = driver.findElement(By.cssSelector("#slider5 div output")).getText();
        System.out.println(initialValue5);
//slider 6
        driver.findElement(By.id("slider1")).click();
        String initialValue6 = driver.findElement(By.cssSelector("#slider6 div output")).getText();
        System.out.println(initialValue6);

    }
        @AfterClass
        public void tearDown () {
            driver.quit();
        }

    }
