package ListenersDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class BaseListeners {
    public static WebDriver driver;
    public static void initialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://uk.yahoo.com/?p=us");
    }
    public static void failed() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File trg = new File("/Users/Raaj/Documents/Jayanthi/Java/JayPractice/ConceptsBased/src/test/java/ListenersDemo/Screenshot/image.png");
        FileUtils.copyFile(src,trg);

    }
}
