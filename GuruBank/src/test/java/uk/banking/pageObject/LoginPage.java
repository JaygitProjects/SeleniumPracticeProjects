package uk.banking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //finding elements
    @FindBy(name="uid")
     WebElement txtUserID;

    @FindBy(name= "password")
  WebElement txtPassword;

    @FindBy(name="btnLogin")
 WebElement btnLogin;

    //Methods to access the elements

    public  void setUserId(String uname){
        txtUserID.sendKeys(uname);
    }
    public  void setPassword(String pwd){
        txtPassword.sendKeys(pwd);
    }
    public void clickLogin(){
        btnLogin.click();
    }
}
