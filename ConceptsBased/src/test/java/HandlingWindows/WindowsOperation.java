package HandlingWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class WindowsOperation {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/chenni/Documents/Jayanthi/Software/geckodriver");
        driver = new FirefoxDriver();
        String url = "http://leafground.com/pages/Window.html";
        driver.get(url);
        Thread.sleep(5000);
    }

    @Test
    public void testWindows() throws InterruptedException {

        WebElement homePageButton = driver.findElement(By.id("home"));
        homePageButton.click();
        //to bring back the control to parent window

        String oldWindowHandle = driver.getWindowHandle();
        /*
        while (I1.hasNext()) {
            String child_window = I1.next();
            // Here we will compare if parent window is not equal to child
            // window then we will close
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                Thread.sleep(3000);
              //  WebElement editBox = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[1]/a/img"));
                WebElement editBox = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[1]/a/img"));
                Thread.sleep(4000);
                editBox.click();
                driver.close();
            }
        }
    }*/

// returns handles for all the windows opened including parent window handle
        Set<String> Handles = driver.getWindowHandles();
        System.out.println("Number of windows opened : " + Handles.size());
        //iterate the handles
        Iterator<String> iter = Handles.iterator();
        while (iter.hasNext()) {
            String newWindow = iter.next();
            if (!oldWindowHandle.equals(newWindow)) {
                driver.switchTo().window(newWindow);
                Thread.sleep(3000);
//Alert edit window
                WebElement editBox = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[1]/a/img"));
                Thread.sleep(4000);
                editBox.click();
                //handling the operation in second window
                WebElement emailBox = driver.findElement(By.id("email"));
                driver.manage().window().maximize();
                System.out.println(driver.getTitle());
                emailBox.sendKeys("Jay@gmail.com");
                Thread.sleep(3000);
                driver.close();
                Thread.sleep(3000);
//Handling multiple windows
                driver.switchTo().window(oldWindowHandle);
                WebElement multipleWindowsButton = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button"));
                multipleWindowsButton.click();
                Thread.sleep(5000);
                Set<String> handles = driver.getWindowHandles();
                System.out.println("Number of Windows :" + handles.size());
                for (String handle : handles) {
                    if (!oldWindowHandle.equals(handle)) {
                        driver.switchTo().window(handle);
                        System.out.println("Window Title : " + driver.getTitle());
                        driver.manage().window().maximize();
                        Thread.sleep(5000);
                        driver.close();
                    }
                }
//3rd close all except this window
                        driver.switchTo().window(oldWindowHandle);
                        WebElement closeAllExcept = driver.findElement(By.id("color"));
                        closeAllExcept.click();
                        Set<String> windowHandles = driver.getWindowHandles();

                        for (String windowHandle : windowHandles) {
                            if(!oldWindowHandle.equals(windowHandle)){
                                driver.switchTo().window(windowHandle);
                                driver.close();
                            }
                        }
//4th -wait for 5 seconds
                driver.switchTo().window(oldWindowHandle);
                WebElement wait5seconds = driver.findElement(By.xpath("//*[@id=\"color\"]"));
                wait5seconds.click();
                WebDriverWait wait = new WebDriverWait(driver, 5);
                wait.until(ExpectedConditions.numberOfWindowsToBe(3));
                Thread.sleep(4000);
                }
                }
            }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
