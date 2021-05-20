package JavaScriptExecuteorDemo;

import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class JavaScriptUtil {

    public static void drawBorder(WebElement element, WebDriver driver) throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'",element);

    }
    public static String getTitle(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title =js.executeScript("return document.title;").toString();
        return title;
    }
    public static void clickElement(WebElement element, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }
    public static void sendAlert(WebDriver driver , String message){
        JavascriptExecutor ja = (JavascriptExecutor) driver;
        ja.executeScript("alert('"  + message +  "')");
    }
    public static void refresh(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("history.go(0)");

    }
    public static void scrollUp(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }
    public static void scrollDown(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }
    public static void zoomPage(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='60%'");
    }
}
