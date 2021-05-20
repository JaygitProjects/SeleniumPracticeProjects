package WebElementAdvancedConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandles {
    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/Raaj/Documents/Jayanthi/Software/geckodriver");
        driver = new FirefoxDriver();
        String url = "http://leafground.com/pages/Window.html";
        driver.get(url);
        Thread.sleep(5000);
    }

    @Test
    public void testWindows() throws InterruptedException {

        WebElement homePageButton = driver.findElement(By.id("home"));
        homePageButton.click();

        //to bring back th control to parent window
        String oldWindowHandle = driver.getWindowHandle();
// returns handles for all the windows opened including parent window handle
        Set<String> Handles = driver.getWindowHandles();
        System.out.println("Number of windows opened : " + Handles.size());
        //1. iterate the handles usion iterator
        /*Iterator<String> iter = Handles.iterator();
        while (iter.hasNext()) {
            String newWindow = iter.next();
            if (!oldWindowHandle.equals(newWindow)) {
                driver.switchTo().window(newWindow);
                Thread.sleep(3000);*/
//or 1. using for each loop

for (String string : Handles)   {
    if(!string.equals(oldWindowHandle)){
        driver.switchTo().window(string);
        Thread.sleep(3000);
    }

}

//now handling the Alert edit window
                WebElement editBox = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[1]/a/img"));
                Thread.sleep(4000);
                editBox.click();
                driver.close();
 driver.switchTo().window(oldWindowHandle);
 //or
 driver.switchTo().defaultContent();



            }



    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
