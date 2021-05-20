
package Try2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Inputform {
    static WebDriver driver;
    Properties prop;
    String browserType;
    String url;

    @BeforeClass
    public void setUp() throws FileNotFoundException {
        String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
            prop.load(fis);
            browserType = prop.getProperty("browser");
            url = prop.getProperty("url");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (browserType.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        if (browserType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver_2");
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/geckodriver");
            driver = new FirefoxDriver();
        } else
            System.out.println("Driver not found");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    public static void commonInputElement() {
        if (driver.findElement(By.xpath("//a[@href='#'][@class='at-cv-button at-cv-lightbox-yesno at-cm-no-button']")).isEnabled())
            driver.findElement(By.xpath("//a[@href='#'][@class='at-cv-button at-cv-lightbox-yesno at-cm-no-button']")).click();
        //Input Forms
        WebElement inputForms = driver.findElement(By.xpath("//a[@href='#' and @class='dropdown-toggle']"));
        inputForms.click();
    }

    @Test(priority = 1, enabled = false)
    public void testSimpleForm() throws InterruptedException {
//popup cookie

        System.out.println("Title : " + driver.getTitle());
        System.out.println("*********************** Simple Form *********************************************");

/*//*
/Input Forms
        WebElement inputForms = driver.findElement(By.xpath("//a[@href='#' and @class='dropdown-toggle']"));
        inputForms.click();*/

        commonInputElement();
//1.Simple Form Demo
        Thread.sleep(1000);
        WebElement simpleForm = driver.findElement(By.xpath("//a[contains(@href,'./basic-first-form-demo.html')]"));
        simpleForm.click();
//Enter user message
        WebElement userMsg = driver.findElement(By.xpath("//input[@id='user-message']"));
        userMsg.sendKeys("Hi, I am Jayanthi");

// Show Message

        WebElement showMsg = driver.findElement(By.xpath("//button[text()='Show Message']"));
        showMsg.click();
        System.out.println("Message : " + driver.findElement(By.xpath("//*[@id='display']")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='display']")).getText(), "Hi, I am Jayanthi");

//2 input field
        WebElement enterA = driver.findElement(By.xpath("//input[@id='sum1']"));
        enterA.sendKeys("20");

        WebElement enterB = driver.findElement(By.xpath("//input[@id='sum2']"));
        enterB.sendKeys("40");

        WebElement getTotal = driver.findElement(By.xpath("//button[text()='Get Total']"));
        getTotal.click();
        System.out.println(driver.findElement(By.xpath("//*[@id='displayvalue']")).getText());
        Assert.assertEquals((driver.findElement(By.xpath("//*[@id='displayvalue']"))).getText(), "60");
    }

    @Test(priority = 2, enabled = false)
    public void testCheckBoxDemo() {
        System.out.println("***************************** Check box *********************************************");
//Check box demo

WebElement inputForms = driver.findElement(By.xpath("//a[@href='#' and @class='dropdown-toggle']"));
        inputForms.click();

        commonInputElement();
        //check box demo
    //    WebDriverWait wait = new WebDriverWait(driver, 10);

/* wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='./basic-checkbox-demo.html']")));*//*

        WebElement checkBox = driver.findElement(By.xpath("//a[@href='./basic-checkbox-demo.html']"));
        checkBox.click();

        */
/* wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='isAgeSelected']")));*/

//to scroll the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
//check box 1
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='isAgeSelected']")));
        WebElement checkBox1 = driver.findElement(By.xpath("//*[@id='isAgeSelected']"));
        checkBox1.click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='txtAge']")).getText(), "Success - Check box is checked");

//Multiple Checkbox Demo

        WebElement multipleCheckBox = driver.findElement(By.xpath("//input[@id='check1']"));
        multipleCheckBox.click();

System.out.println(multipleCheckBox.getText());
        System.out.println(multipleCheckBox.getAttribute("value"));

        if (multipleCheckBox.getAttribute("value").equals("Uncheck All"))
            System.out.println("All check boxes are checked");
        multipleCheckBox.click();
        if (multipleCheckBox.getAttribute("value").equals("Check All"))
            System.out.println("All checkboxes are unchecked");
    }

    //Radio Button Demo
    @Test(priority = 3, enabled = false)
    public void testRadioButton() throws InterruptedException {
        System.out.println("********************** Radio button *******************************");


//Input Forms
        WebElement inputForms = driver.findElement(By.xpath("//a[@href='#' and @class='dropdown-toggle']"));
        inputForms.click();

        commonInputElement();
        //RadioButton
        WebElement radioButtonDemo = driver.findElement(By.xpath("//a[text()='Radio Buttons Demo']"));
        radioButtonDemo.click();
        //single Radio
        WebElement singleRadioButton = driver.findElement(By.xpath("//input[@type='radio'][@name='optradio'][@value='Male']"));
        singleRadioButton.click();
        Thread.sleep(1000);
        WebElement getCheckedValue = driver.findElement(By.xpath("//button[@id='buttoncheck']"));
        getCheckedValue.click();

        if (driver.findElement(By.xpath("//p[@class='radiobutton']")).getText().equals("Radio button 'Male' is checked"))
            System.out.println("Male is selected");
        else if (driver.findElement(By.xpath("//p[@class='radiobutton']")).getText().equals("Radio button 'Female' is checked"))
            System.out.println("Female is selected");
        //Group Radio button
        List<WebElement> groupRadioButtons = driver.findElements(By.xpath("//*[@name='gender']"));
        for (WebElement button : groupRadioButtons) {
            if (button.getAttribute("value").equalsIgnoreCase("Female")) {
                button.click();
                System.out.println("Sex selected : " + button.getAttribute("value"));
                System.out.println(button.getAttribute("value") + ":" + button.isSelected());
            }
        }
        //age group
        List<WebElement> ages = driver.findElements(By.xpath("//*[@name='ageGroup']"));
        for (WebElement element : ages) {
            if (element.getAttribute("value").equalsIgnoreCase("5 - 15")) {
                element.click();
                System.out.println("Age Selected : " + element.getAttribute("value"));
                System.out.println(element.getAttribute("value") + ":" + element.isSelected());
            }

        }
//validate get value button
        driver.findElement(By.xpath("//button[text()='Get values']")).click();
        WebElement getValue = driver.findElement(By.xpath("//p[@class='groupradiobutton']"));
        String actualSex = getValue.getText().split("\n")[0].split(":")[1].trim();
        String actualAge = getValue.getText().split("\n")[1].split(":")[1].trim();
        Assert.assertEquals(actualSex, "Female");
        Assert.assertEquals(actualAge, "5 - 15");
    }

    @Test(priority = 4, enabled = false)
    public void testDropdown() throws InterruptedException {
        System.out.println("************************ Dropdown List **************************************");
        commonInputElement();
//Radio button mdemo menu
        driver.findElement(By.xpath("//a[text()='Select Dropdown List']")).click();
        System.out.println(driver.getTitle());
        WebElement days = driver.findElement(By.xpath("//select[@class='form-control']"));
        days.click();
        Select select = new Select(days);
        select.selectByValue("Tuesday");
        Thread.sleep(3000);
        WebElement daySelected = driver.findElement(By.xpath("//p[@class='selected-value']"));
        String actualDay = daySelected.getText().split("\\n")[0].split(":- ")[1].trim();

        Assert.assertEquals(actualDay, "Tuesday");

    }

    @Test(priority = 5, enabled = false)
    public void testInputForm() throws InterruptedException {
        System.out.println("****************** Input Form *********************");
        commonInputElement();


        WebElement inputForm = driver.findElement(By.xpath("//a[@href='./input-form-demo.html']"));
        inputForm.click();
        //Input form details
        driver.findElement(By.name("first_name")).sendKeys("Jayan");
        driver.findElement(By.name("last_name")).sendKeys("Bal");
        driver.findElement(By.name("email")).sendKeys("Jayanthirsundar@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("8686965356");
        driver.findElement(By.name("address")).sendKeys("8, Oakey, Wokingham");
        driver.findElement(By.name("city")).sendKeys("London");
        WebElement state = driver.findElement(By.name("state"));
        state.click();
        Select select = new Select(state);
        Thread.sleep(1000);
        select.selectByVisibleText("Florida");
        driver.findElement(By.name("zip")).sendKeys("12345");

        driver.findElement(By.name("website")).sendKeys("www.jay.com");

        List<WebElement> hasHost = driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement host : hasHost) {
            if (host.getAttribute("value").equalsIgnoreCase("No"))
                host.click();
        }
        driver.findElement(By.name("comment")).sendKeys("I like this website");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");


        driver.findElement(By.xpath("//button[@type='submit'][@class='btn btn-default']")).click();

    }

    @Test(priority = 6, enabled = false)
    public void testAjaxForm() {
        commonInputElement();
        driver.findElement(By.xpath("//a[@href='./ajax-form-submit-demo.html']")).click();
        driver.findElement(By.xpath("//input[@id='title']")).sendKeys("Jayan");
        driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("I like this website");
        driver.findElement(By.id("btn-submit")).click();
    }

    @Test(priority = 7)
    public void testJqueryDropDown() throws InterruptedException {
        System.out.println("****************** Test JQuery **************");
        commonInputElement();
        driver.findElement(By.xpath("//a[@href='./jquery-dropdown-search-demo.html']")).click();
//dropdown with select
        WebElement country = driver.findElement(By.id("country"));
        Select select = new Select(country);
        select.selectByIndex(3);
        Thread.sleep(2000);

//Multiple select by search
        WebElement state = driver.findElement(By.xpath("//select[@class='js-example-basic-multiple select2-hidden-accessible']"));
        Select select1 = new Select(state);
        select1.selectByVisibleText("New Jersey");
        select1.selectByVisibleText("New York");
        Thread.sleep(2000);

//dropdown with disabled values
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        WebElement disabledValues = driver.findElement(By.xpath("//select[@class='js-example-disabled-results select2-hidden-accessible']"));
        Select select2 = new Select(disabledValues);
//to select all options
        System.out.println("All options ");
        List<WebElement> allSelected = select2.getOptions();
        for (WebElement selectedElement : allSelected) {
            System.out.println("Selected countries(get options) : " + selectedElement.getText());
            Thread.sleep(2000);
        }
// to select only visible
        System.out.println("*** visible text ******** ");
        List<WebElement> allSelected2 = select2.getAllSelectedOptions();
        for (WebElement selectedElement : allSelected) {
            if (selectedElement.isEnabled()) {
                System.out.println("Selected countries : " + selectedElement.getText());
            }

        }
//Dropdown with category
        System.out.println("*** Category selection ******** ");
        //List<WebElement> allSelected3 = select2.getFirstSelectedOption();
        for (WebElement selectedElement : allSelected) {
            if (selectedElement.isSelected()) {
                System.out.println("Selected countries : " + selectedElement.getText());
            }

        }
    }
        @AfterClass
        public void tearDown () {
            driver.quit();
        }
    }


