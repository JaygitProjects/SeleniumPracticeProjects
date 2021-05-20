package WebElementAdvancedConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadFiles {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/chenni/Documents/Jayanthi/Software/geckodriver");
        driver = new FirefoxDriver();
        String url = "http://www.leafground.com/pages/download.html";
        driver.get(url);
        Thread.sleep(5000);
    }
    @Test
    public void testFilesDownload(){
        WebElement excelFile = driver.findElement(By.partialLinkText("excel"));
        excelFile.click();
        

    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
