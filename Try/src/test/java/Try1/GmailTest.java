package Try1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class GmailTest {
    private WebDriver driver;


    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser){

        if(browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/Raaj/Documents/Jayanthi/Software/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","/Users/Raaj/Documents/Jayanthi/Software/geckodriver");
            driver = new FirefoxDriver();}
            else if(browser.equalsIgnoreCase("safari")){
                driver = new SafariDriver();
            }
            driver.get("https://www.google.com/intl/en-GB/gmail/about/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

        }

    @Parameters({"uName,passWord"})
@Test

    public void gmailTest(String uName, String passWord){
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a")).click();

       WebElement email = driver.findElement(By.cssSelector("#identifierId"));
       email.click();
       email.sendKeys("uName");

        WebElement next = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/div[2]"));
        next.click();

        WebElement pword = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input"));
        pword.click();
        pword.sendKeys("passWord");
        
        WebElement next2= driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button/div[2]"));
        next2.click();

    }
    @AfterTest
    public void  tearDown(){
        driver.quit();
    }

}
