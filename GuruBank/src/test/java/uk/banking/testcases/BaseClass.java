package uk.banking.testcases;

import com.beust.jcommander.Parameter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import uk.banking.utilities.ReadConfig;


public class BaseClass {
     WebDriver driver;
    static Logger logger;
ReadConfig read = new ReadConfig();
  String url = read.readAppUrl();
    String userName = read.readUserId();
   String password = read.readPassword();
   @Parameters("browser")
    @BeforeClass
    public void setUp(String browser){
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", read.readChromePath());
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", read.readGeckoPAth());
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari"))
            driver = new SafariDriver();
         else
            System.out.println("Driver not found");
        //log4j

         logger=Logger.getLogger("GuruBank");
        PropertyConfigurator.configure("log4j.properties");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
