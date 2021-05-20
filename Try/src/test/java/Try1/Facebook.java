package Try1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Facebook {

   public WebDriver driver;
    @BeforeTest
    public void setUp(){
       /* System.setProperty("webdriver.chrome.driver","/Users/chenni/Documents/Jayanthi/Software/chromedriver");*/
  //      ChromeOptions options = new ChromeOptions();
        /*options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");*/
      //  driver = new ChromeDriver(options);
      //  driver=new ChromeDriver();
//        driver=new ChromeDriver();
        driver = new SafariDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

    }
    @Test(dataProvider = "LoginData")
    public void facebookTest(String uName,String pWord){
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();//button[@data-cookiebanner='accept_button']
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(uName);
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pWord);
        driver.findElement(By.xpath("//button[@name='login']")).click();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }
    @DataProvider(name = "LoginData")
    public Object[][] getData(){
String loginData[][]={{"jayanthirsundar@gmail.com","sundarfac"}};
return loginData;
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
