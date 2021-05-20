package uk.Login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestLogin {
    WebDriver driver;


    @Test(dataProvider = "LoginTestData")
   /* String[][] data = null;
    @DataProvider(name = "LoginTestData")
    public String[][] loginTestData(){
        return data;
    }
    ///Users/Raaj/Documents/Jayanthi/Java/JayPractice/Guru99Scrum/LoginTestdata.xlt
    @Test(DataProvider = "LoginTestData")*/
    /*public void testLogin(String uname, String pword) throws IOException {
        WebElement login = driver.findElement(By.xpath("/html[1]/body[1]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
        login.sendKeys(uname);
        WebElement password = driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]"));
        password.sendKeys(pword);
        WebElement loginButton = driver.findElement((By.xpath("//tbody/tr[3]/td[2]/input[1]")));
        loginButton.click();*/

//  @DataProvider(name = "LoginTestData")
    public void test() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/resources/LoginTestdata.xlsx");
        Workbook workbook = new HSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();
        for (int i = 1; i <= rows; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j <= cols; j++) {
                Cell cell = row.getCell(j);
                System.out.println(cell);
            }
        }
    }
@BeforeTest
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String url = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";
            driver.get(url);
        }

@AfterTest
        public void tearDown(){

        driver.quit();

    }
}
