package ListenersDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ListnersTrial2 implements ITestListener {
    static WebDriver driver;
public  static void initialize(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://www.dailymail.co.uk/home/index.html");
    driver.manage().window().maximize();
}
    public void onTestFailure(ITestResult result) {
        System.out.println("From listners class");
        ListenersTrial lt = new ListenersTrial();

        TakesScreenshot screenShot = (TakesScreenshot) driver;
      File src=   screenShot.getScreenshotAs(OutputType.FILE);
      File targ = new File("/Users/Raaj/Documents/Jayanthi/Java/JayPractice/ConceptsBased/src/test/java/ListenersDemo/Screenshot/Lisners.png");
        try {
            FileUtils.copyFile(src, targ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
