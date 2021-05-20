package ListenersDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.*;

//@Listeners(ListnersTrial2.class)
public class ListenersTrial extends ListnersTrial2 implements ITestListener {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
       initialize();

    }
    @Test
    public static void failingTest(){
        Assert.assertEquals(false,true);
    }

@AfterClass
    public void tearDown(){
        driver.quit();
}
}
