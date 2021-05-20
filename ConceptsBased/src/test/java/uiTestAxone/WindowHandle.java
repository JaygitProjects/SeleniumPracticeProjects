package uiTestAxone;

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
import java.util.concurrent.TimeUnit;
//multiple Window handle
//??? check how to do using explicit wait
public class WindowHandle {


    WebDriver webDriver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","/Users/chenni/Documents/Jayanthi/Software/geckodriver");
        webDriver = new FirefoxDriver();
        webDriver.get("http://uitest.automationtester.uk/window-popup-modal-demo.html");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
    }
    @Test
    public void testSingleWindow(){

    }
    @Test

public void testFollowTwittAndFB() throws InterruptedException {
        String oldHandle = webDriver.getWindowHandle();
       WebElement followOnTwitter =  webDriver.findElement(By.xpath("//a[text()='Follow Twitter & Facebook']"));
       followOnTwitter.click();


    Set<String> handles = webDriver.getWindowHandles();
        Iterator<String> iter = handles.iterator();
        while(iter.hasNext()){
            String handle = iter.next();
            if(! oldHandle.equalsIgnoreCase(handle)){
                webDriver.switchTo().window(handle);
//                WebDriverWait wait = new WebDriverWait(webDriver,10);
////                wait.until(ExpectedConditions.urlContains("karthik_gnathan"));
//                wait.until(ExpectedConditions.titleContains("Karthik Gandhinathan"));
                Thread.sleep(10000);
                System.out.println(webDriver.getCurrentUrl());
                System.out.println(webDriver.getTitle());
                webDriver.close();
                webDriver.switchTo().window(oldHandle);

            }
        }
    }
    @Test
            public void testFollowAll() throws InterruptedException {
        String oldHandle = webDriver.getWindowHandle();
        WebElement followAll = webDriver.findElement(By.xpath("//a[@id='followall']"));
        followAll.click();
        Set<String> handles = webDriver.getWindowHandles();
        Iterator<String> iter = handles.iterator();
        while (iter.hasNext()) {
            String handle = iter.next();
            if (!oldHandle.equalsIgnoreCase(handle)) {
                webDriver.switchTo().window(handle);
                Thread.sleep(10000);
                System.out.println(webDriver.getCurrentUrl());
                System.out.println(webDriver.getTitle());
                webDriver.close();
                webDriver.switchTo().window(oldHandle);
            }
        }
    }
   @AfterTest
   public void tearDown(){
        webDriver.quit();
   }
}
