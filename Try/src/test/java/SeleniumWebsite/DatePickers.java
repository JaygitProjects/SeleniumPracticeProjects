package SeleniumWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class DatePickers {
    WebDriver driver;
@BeforeClass
public void setup(){
    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chromedriver_2");
    driver=new ChromeDriver();
    driver.get("https://www.seleniumeasy.com/test/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
public void cookieHandle(){
//cookie
    if(driver.findElement(By.xpath("//a[text()='No, thanks!']")).isEnabled())
        driver.findElement(By.xpath("//a[text()='No, thanks!']")).click();

//Date pickers menu

}
@Test()
public void testBootstrapDatePickers() throws InterruptedException, ParseException {

    driver.findElement(By.xpath("//a[text()='Date pickers']")).click();
    driver.findElement(By.linkText("Bootstrap Date Picker")).click();
    Date d = new Date();
    // System.out.println(d);
    // System.out.println(d.toString().replace(" ", "_").replace(":", "_"));

    Thread.sleep(2000);
//search box
    driver.findElement(By.xpath("//*[@id=\"sandbox-container1\"]/div/input")).click();
    Thread.sleep(2000);
//today click
    driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tfoot/tr[1]/th")).click();
    Thread.sleep(2000);
//to get displayed date
    //body/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]
    String todays = driver.findElement(By.xpath("//*[@id=\"sandbox-container1\"]/div/input")).getAttribute("value");
    System.out.println(todays);
    //validation
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate localDate = LocalDate.now();
    String todaysSystemDate=localDate.format(dtf);

    Assert.assertEquals(todays,todaysSystemDate);

}
//Date range
    @Test(priority = 1)
    public void testBootstrapRange() throws InterruptedException {
        System.out.println("********* bootstrap range *********");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[1]")).sendKeys("30/05/2021");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[2]")).clear();
        driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[2]")).sendKeys("21/06/2021");
        Thread.sleep(2000);

        //date compare
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date1 =driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[1]")).getAttribute("value");
    String date2 = driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[2]")).getAttribute("value");

        System.out.println("Start date:" + date1);
        System.out.println(" End date :" + date2);
        if (date1.equals(date2))
            System.out.println("Dates are Equal");
        else if (date1.compareTo(date2)<0)
            System.out.println("Date1 is before date2");
        else if (date1.compareTo(date2)>0)
            System.out.println("Date 1 is after date2 ");

//or
  /*WebElement startDate=  driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[1]"));
  startDate.click();
  driver.findElement(By.xpath(""));
  WebElement endsDate = driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[2]"));
  endDate.click();*/

    }

@Test(priority = 2)
public void testJqueryDatePickers() throws ParseException, InterruptedException {
    System.out.println("******************* J query date pickers *****************");
    driver.findElement(By.xpath("//a[text()='Date pickers']")).click();
    driver.findElement(By.linkText("JQuery Date Picker")).click();
    Thread.sleep(2000);
    //from
    WebElement fromDate = driver.findElement(By.xpath("//*[@id=\'from\']"));
    fromDate.click();
    Thread.sleep(2000);
    //next button
    WebElement nextbut= driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]"));
    nextbut.click();

/*JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", nextbut);*/

    Thread.sleep(2000);

    //date click
   WebElement day =  driver.findElement(By.xpath("//a[@class='ui-state-default'][text()=15]"));
   day.click();
    /*JavascriptExecutor executor1 = (JavascriptExecutor)driver;
    executor1.executeScript("arguments[0].click();", day);*/

  //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ui-state-default'][text()=15]")));



    //Thread.sleep(2000);
//To column
    WebElement toDate = driver.findElement(By.xpath("//*[@id=\"to\"]"));
    toDate.click();

    //next button
     driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]")).click();

    //date click
  driver.findElement(By.xpath("//a[@class='ui-state-default'][text()=15]")).click();
    Thread.sleep(2000);
   String sDate = fromDate.getAttribute("value");
   String eDate = toDate.getAttribute("value");

    System.out.println("Start date : "+sDate);
    System.out.println("End Date : " + eDate);
    if(sDate.compareTo(eDate)<  0)
        System.out.println("Start dates  are before end dates ");
    else if(sDate.compareTo(eDate)>0)
    System.out.println("Start dates  are after end dates");
    else if (sDate.compareTo(eDate)>0)
    System.out.println("Dates are equal");


}
@AfterClass
    public void tearDown(){
    driver.quit();
}
}
