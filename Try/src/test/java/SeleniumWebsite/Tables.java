package SeleniumWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tables {
    WebDriver driver;
    @BeforeClass
    public void setup(){

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver_3");
        driver= new ChromeDriver();
      //  driver = new SafariDriver();
        driver.get("https://www.seleniumeasy.com/test/");
        driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        WebElement cookie = driver.findElement(By.linkText("No, thanks!"));
        if(cookie.isEnabled()) {
            if (cookie.getText().equalsIgnoreCase("No, thanks!"))
                cookie.click();
        }
    }

@Test(priority = 0)
public void testTablePaginat() throws InterruptedException {
    System.out.println("**************** Table Pagination ****************");
//Table
    driver.findElement(By.linkText("Table")).click();
    //Table Pagination
    driver.findElement(By.linkText("Table Pagination")).click();


    //  full xpath for page pagination //*[@id="myPager"]/li[]/a

  String beforeXpath = "//*[@id=\'myPager\']/li[";
  String afterXpath = "]/a";
//logic to click to each page and get corresponding rows
    for (int i = 2; i <= 4; i++) {
        WebElement pagination  = driver.findElement(By.xpath(beforeXpath + i + afterXpath));
        pagination.click();
        Thread.sleep(2000);
        List<WebElement> page = driver.findElements(By.xpath("//*[@id=\"myTable\"]//tr[@style='display: table-row;']"));
        int rowsinPage = page.size();
        System.out.println("\n Number of rows in each page : " + rowsinPage);
        for (int j = 0; j < rowsinPage; j++)
            System.out.println(page.get(j).getText());
    }

}
@Test(priority = 1)
public void testTableDataSearch(){
    System.out.println("*************** Table Data Search ****************");
//All examples
    driver.findElement(By.linkText("All Examples")).click();
//Table
    driver.findElement(By.linkText("Table")).click();
//Table Data Search
        driver.findElement(By.linkText("Table Data Search")).click();
// filter data by Tasks / Assignee / Status
/*WebElement searchBox = driver.findElement(By.id("task-table-filter"));
searchBox.click();*/
List<WebElement> taskColumn = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr/td[2]"));
int taskSize = taskColumn.size();
    System.out.println("Total Task records :" + taskSize);

    for(int i= 0; i<taskSize;i++)
    System.out.println( taskColumn.get(i).getText());
// filter by assigne
    List<WebElement> assigneColumn = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr/td[3]"));
    int assigneSize = taskColumn.size();
    System.out.println("\nTotal Assignee records :" + assigneSize);

    for(int i= 0; i<assigneSize;i++)
        System.out.println( assigneColumn.get(i).getText());
// filter by status
    List<WebElement> statusColumn = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr/td[2]"));
    int statusSize = statusColumn.size();
    System.out.println("\nTotal Status records :" + statusSize);
    for(int i= 0; i<statusSize;i++)
        System.out.println( statusColumn.get(i).getText());
//through search box
WebElement searchBox = driver.findElement(By.id("task-table-filter"));
searchBox.sendKeys("Bootstrap");
    System.out.println(searchBox.getAttribute("value"));
}
@Test(priority = 2)
public void testTableFilter() throws InterruptedException {
    System.out.println("***********  Table Filter *********");
//All examples
    driver.findElement(By.linkText("All Examples")).click();
//Table
    driver.findElement(By.linkText("Table")).click();
//Table Filter
    driver.findElement(By.linkText("Table Filter")).click();
//Colour buttons
    String beforeXpath = "//div[@class='btn-group']/button[";
    String afterXpath = "]";
    for (int i = 1; i <= 4; i++) {
       Thread.sleep(2000);
        WebElement colours = driver.findElement(By.xpath(beforeXpath + i + afterXpath));
        colours.click();
        List<WebElement> colourInfo = driver.findElements(By.xpath("//table[@class='table table-filter']"));
        System.out.println("\nNext colour click \n ");
        for (WebElement colo : colourInfo) {
            for (int j = 1; j <= colourInfo.size(); j++) {
                System.out.println(colo.getText());
            }
        }
    }
}
@Test(priority = 3)
public void testTableSortAndSearch() throws InterruptedException {
    System.out.println("*************** Table Sort And Search ****************");
//All examples
    driver.findElement(By.linkText("All Examples")).click();
//Table
    driver.findElement(By.linkText("Table")).click();
//Table Sort and search
    driver.findElement(By.linkText("Table Sort & Search")).click();
// Drop down for pages display
    WebElement dropDownPage = driver.findElement(By.xpath("//select[@name='example_length']"));
    Select select = new Select(dropDownPage);
    select.selectByValue("25");
    Thread.sleep(3000);
    List<WebElement> tableData = driver.findElements(By.xpath("//table"));
    for (int i = 0; i < tableData.size(); i++) {
        // for(WebElement data:tableData)
        System.out.println(tableData.get(i).getText());


    }
// Search box
    WebDriverWait wait = new WebDriverWait(driver,10);
    WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
   // wait.until(ExpectedConditions.elementToBeClickable(searchBox));
   // Thread.sleep(2000);
    searchBox.click();
    searchBox.sendKeys("Tokyo");
   // Thread.sleep(2000);
    List<WebElement> tableSearchData = driver.findElements(By.xpath("//table"));
    System.out.println("\nTotal Number of records through search box : "+ tableSearchData.size());
    for (int j = 0; j < tableSearchData.size(); j++) {

        System.out.println(tableSearchData.get(j).getText());

    }
}
@Test(priority=4)
public void testTestDataDownload() throws InterruptedException, AWTException {
    System.out.println("*************** Table Data Download ****************");
//All examples
    driver.findElement(By.linkText("All Examples")).click();
//Table
    driver.findElement(By.linkText("Table")).click();
//Table Data Download
driver.findElement(By.linkText("Table Data Download")).click();
//copy
  driver.findElement(By.xpath("//span[text()='Copy']")).click();
//csv
    driver.findElement(By.xpath("//span[text()='CSV']")).click();
    //Excel
    driver.findElement(By.xpath("//span[text()='Excel']")).click();
    //pdf
    driver.findElement(By.xpath("//span[text()='PDF']")).click();
    //print
/*WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.elementToBeClickable())*/
   driver.findElement(By.xpath("//a[@class='dt-button buttons-print']")).click();
    Thread.sleep(3000);
    Robot r = new Robot();
    r.keyPress(KeyEvent.VK_ESCAPE);
  //  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"previewArea\"]//div[1]")));

    Thread.sleep(3000);
}



@AfterClass
    public void tearDown(){
        driver.quit();
    }
}
