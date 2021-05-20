package TestNGFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SafariParallel {
    WebDriver driver;
    @Test
    public void testSafari() {


        driver = new SafariDriver();
        System.out.println("****Safari****");
        driver.get("https://demo.nopcommerce.com/");
        System.out.println("Thread count "+ Thread.currentThread().getId());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String title = driver.getTitle();
        System.out.println(title);
        WebElement login = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
        login.click();
        WebElement uname = driver.findElement(By.id("Email"));
        uname.sendKeys("ritha.sanjay@gmail.com");
        WebElement pWord = driver.findElement(By.id("Password"));
        pWord.sendKeys("Learnonline123");
        WebElement logut = driver.findElement(By.xpath("//button[text()='Log in']"));
        logut.click();
        System.out.println(driver.getCurrentUrl());
        driver.quit();
        //Assert.assertEquals("nopCommerce demo store", title);
    }
}
