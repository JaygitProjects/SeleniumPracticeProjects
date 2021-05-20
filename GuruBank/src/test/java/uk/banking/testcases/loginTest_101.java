package uk.banking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import uk.banking.pageObject.LoginPage;

import java.util.concurrent.TimeUnit;

public class loginTest_101 extends BaseClass {
    @Test
    public void loginTest() {
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        logger.info("Url is opened");
        LoginPage lp = new LoginPage(driver);
        lp.setUserId(userName);
        logger.info("Entered username");
        lp.setPassword(password);
        logger.info("Entered password");
        lp.clickLogin();
        System.out.println(driver.getTitle());
        if (driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
            Assert.assertTrue(true);
            logger.info("Login test passed");
        } else {
            Assert.assertTrue(false);
        }
    }
}
