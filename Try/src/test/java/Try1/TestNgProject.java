package Try1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNgProject {
    WebDriver driver ;
    String url= "http://seleniumpractice.axone-tech.uk/index.php";
    @BeforeClass
    public void setUp(){
       System.setProperty("webdriver.chrome.driver","/Users/Raaj/Documents/Jayanthi/Software/chromedriver");
       driver = new ChromeDriver();
       driver.get(url);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @Parameters({"userName","passWord"})
    public void loginPage(String uName, String pWord){


        driver.getTitle();

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(uName);
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(pWord);
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
