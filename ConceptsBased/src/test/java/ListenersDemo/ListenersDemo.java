package ListenersDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners(CustomListners.class)
public class ListenersDemo extends BaseListeners{

    @BeforeMethod
    public void setUp(){
       initialization();
    }



@Test
    public void takeScreenshot(){
        Assert.assertEquals(false,true);
}
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
