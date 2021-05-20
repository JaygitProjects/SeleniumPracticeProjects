package Try1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Cross_browser_Testing {
    WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) throws InterruptedException {

        if (browser.equalsIgnoreCase("chrome")) {

            /*// Create object of HashMap Class
            Map<String, Object> prefs = new HashMap<String, Object>();

            // Set the notification setting it will override the default setting
            prefs.put("profile.default_content_setting_values.notifications", 2);

            // Create object of ChromeOption class
            ChromeOptions options = new ChromeOptions();

            // Set the experimental option
            options.setExperimentalOption("prefs", prefs);

            // pass the options object in Chrome driver*/
           /* System.setProperty("webdriver.chrome.driver", "/Users/chenni/Documents/Jayanthi/Software/chromedriver");
            ChromeOptions options = new ChromeOptions();
           // options.addArguments("--disable-notifications");
            options.addArguments("--disable-extensions");

            WebDriver driver =new ChromeDriver(options);*/

            System.setProperty("webdriver.chrome.driver", "/Users/chenni/Documents/Jayanthi/Software/chromedriver");
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("Firefox")) {

            System.setProperty("webdriver.gecko.driver", "/Users/chenni/Documents/Jayanthi/Software/geckodriver");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari"))
            driver = new SafariDriver();
            Thread.sleep(5000);


        /*
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
         */
            //driver.get("https://www.facebook.com/");
            driver.get("http://seleniumpractice.axone-tech.uk/index.php");

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            //driver.manage().deleteAllCookies();


        }


    @Test
    @Parameters({"uName", "pWord"})
    public void loginPage(String uName, String pWord) throws InterruptedException, AWTException {
        System.out.println(uName);
        System.out.println(pWord);
        Set<String> windows = driver.getWindowHandles();

        //2.get the size of the window
        System.out.println("Size of the Windows :" +windows.size());
      //  driver.manage().getCookies();

        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement cookieWindow =driver.findElement(By.id("u_0_p_Cu"));
        wait.until(ExpectedConditions.elementToBeClickable(cookieWindow)).click();*/
   //     WebElement frame1 = driver.findElement(By.xpath("//*[@id=\"u_0_j_cm\"]"));
    //driver.switchTo().frame(WebElement(frame1);

           /*Alert alert= driver.switchTo().alert();

            System.out.println(alert.getText());
            alert.sendKeys(String.valueOf(Keys.ENTER));
            alert.accept();
*/
        /*String oldWindow = driver.getWindowHandle();
        Set<String> newHandles = driver.getWindowHandles();

        System.out.println(newHandles.size());

        Iterator<String> iter = newHandles.iterator();
            driver.switchTo().window(oldWindow);
            while (iter.hasNext())
            { String handle = iter.next();
            if(!oldWindow.equalsIgnoreCase(handle)){
                driver.switchTo().window(handle);
                driver.getTitle();
                driver.findElement(By.id("u_0_p_Cu")).click();
                driver.close();
            }
        driver.switchTo().window(oldWindow);
        }


         */


        /*WebElement textLogin = driver.findElement(By.id("facebook"));
       // textLogin.clear();
        textLogin.sendKeys(uName);

        WebElement textPWord = driver.findElement(By.id("pass"));
        textPWord.clear();
        textPWord.sendKeys(pWord);

        WebElement buttLogin = driver.findElement(By.id("u_0_h_wn"));

       buttLogin.click();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());*/

        driver.getTitle();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"email\"]"));
       WebDriverWait wait = new WebDriverWait(driver,10);
       wait.until(ExpectedConditions.elementToBeClickable(signIn));

       signIn.sendKeys(uName);
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(pWord);
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();

    }

    @Test
    public void dummyTest() {
        System.out.println("Dummy Test");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();

    }
}

