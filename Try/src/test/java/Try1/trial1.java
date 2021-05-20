package Try1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class trial1 {

    @Test
    public void testTrial() {
        WebDriver driver = new SafariDriver();
        driver.get("https://www.google.com/?client=safari");
        driver.findElement(By.xpath(""));
        driver.quit();
    }
}
