package Try1;

import javafx.scene.control.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Browsers3 {
WebDriver driver ;


@Parameters({"browser","uName","pWord"})
@Test

public void browserTest(String browser, String uName, String pWord) throws InterruptedException {
if(browser.equalsIgnoreCase("chrome")){
        System.setProperty("webdriver.chrome.driver","/Users/chenni/Documents/Jayanthi/Software/chromedriver");
        driver = new ChromeDriver(); }
    else if(browser.equalsIgnoreCase("firefox")){
        System.setProperty("webdriver.gecko.driver","/Users/chenni/Documents/Jayanthi/Software/geckodriver");
        driver = new FirefoxDriver();}
    else if(browser.equalsIgnoreCase("safari")){
        driver = new SafariDriver();
    }
    else
            System.out.println("Browser not fine");

    //url
    driver.get("https://login.yahoo.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    System.out.println(driver.getTitle());
    System.out.println(driver.getCurrentUrl());


driver.findElement(By.xpath("//*[@id=\"login-username\"]")).sendKeys(uName);

driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();

driver.findElement(By.xpath("//*[@id=\"login-passwd\"]")).sendKeys(pWord);
    Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
Thread.sleep(2000);

WebElement jacc = driver.findElement(By.xpath("//*[@id=\"header-profile-button\"]/div[1]"));
jacc.click();
    System.out.println(driver.getCurrentUrl());
Thread.sleep(2000);
   /* Alert alert = (Alert) driver.switchTo().alert();
    alert.close();

WebElement popUp = driver.findElement(By.xpath("//*[@id='atomic']/body"));
        popUp.click();

WebElement logOut = driver.findElement(By.xpath("//*[@id=\"profile-signout-link\"]/span"));
logOut.click();*/

/*WebElement signOut = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[1]/div[3]/header/div[2]/div[3]/div[1]/div[2]/div/a/img"));
    WebDriverWait wait = new WebDriverWait(driver,10);
    wait.until(ExpectedConditions.elementToBeClickable(signOut));
    signOut.click();*/

}
@AfterTest
    public void tearDown(){
    driver.quit();
}

}
