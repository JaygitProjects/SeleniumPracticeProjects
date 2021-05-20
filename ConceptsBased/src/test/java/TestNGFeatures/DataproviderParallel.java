package TestNGFeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataproviderParallel {
    WebDriver driver;
    @BeforeTest
    public void testSetUp(){
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.store.demoqa.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    
    
    @Test(dataProvider = "TestData")
    public void testdataproviderParallel(){
        
    }
    @DataProvider(name = "TestData",parallel = true)
    public Object[][] testDataProvider(){
        Object[][] data = null;
       return data;
    }
    
}
