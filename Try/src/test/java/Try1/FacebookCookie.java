package Try1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FacebookCookie {
    public static WebDriver driver;

    @BeforeTest
    public void startChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/chenni/Documents/Jayanthi/Software/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
@Test(dataProvider ="LoginData")
    public void openAndLogin() throws InterruptedException {

    driver.get("https://www.facebook.com");

    //cookie
    driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();

    WebElement textLogin = driver.findElement(By.xpath("//*[@id=\"email\"]"));
    textLogin.clear();
    textLogin.sendKeys("jayanthirsundar@gmail.com");

    WebElement textPWord = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
    textPWord.clear();
    textPWord.sendKeys("sundarfac");

    WebElement buttLogin = driver.findElement(By.xpath("//button[@name='login']"));

    buttLogin.click();

    System.out.println(driver.getTitle());
    System.out.println(driver.getCurrentUrl());


}

@DataProvider(name="LoginData")

        public Object[][] dataLogin(){
        String data[][] = null;
        return data;
        }
@AfterTest
        public void tearDown(){
        driver.quit();
    }

}
