package TestNGFeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestDataProvider {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
       // System.setProperty("webdriver.gecko.driver", "/Users/chenni/Documents/Jayanthi/Software/geckodriver");
       // driver = new FirefoxDriver();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

    }

    @DataProvider(name = "testdata",parallel = true )
    public Object[][] testData() {
        Object[][] data = {{"admin@yourstore.com", "admin", "yes"},
                {"raj@gmail", "pwd", "no"},
                {"shar@gmail.com", "pass", "no"},
                {"adh@gmail.com", "pwordd", "no"}};
        return data;
    }

    @Test(dataProvider = "testdata" )
    public void testDataProvider(String uname, String pwd, String exp) {
        System.out.println("Thread count"+ Thread.currentThread().getId());
        WebElement eMail = driver.findElement(By.xpath("//input[@id='Email']"));
        eMail.clear();
        eMail.sendKeys(uname);

        WebElement pWord = driver.findElement(By.xpath("//input[@id='Password']"));
        pWord.clear();
        pWord.sendKeys(pwd);

        System.out.println("Username :" + uname + "\n" + "Password : " + pwd + "\n" + "Valid :" + exp);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        /*WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/logout']")));*/

        String actTitle = driver.getTitle();
        String expTitle = "Dashboard / nopCommerce administration";

        //Assert.assertEquals(actTitle,expTitle,"Titile mismatched");
        if (exp.equalsIgnoreCase("yes")) {
            if (actTitle.equalsIgnoreCase(expTitle)) {
                driver.findElement(By.xpath("//a[@href='/logout']")).click();
                Assert.assertTrue(true);
            }
            else
                Assert.assertTrue(false);
        } else if (exp.equalsIgnoreCase("no")) {
            if (actTitle.equalsIgnoreCase(expTitle)) {
                driver.findElement(By.xpath("//a[@href='/logout']")).click();
                Assert.assertTrue(false);
            } else

                Assert.assertTrue(true);
        }
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
