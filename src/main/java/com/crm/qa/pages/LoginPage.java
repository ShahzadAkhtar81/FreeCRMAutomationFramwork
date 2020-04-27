package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage extends TestBase {

    // page factory for Elements repo

    @FindBy(xpath = "//span[text()='Log In']")
    WebElement freeCRMLoginButton;

    @FindBy(name = "email")
    WebElement enterUserName;

    @FindBy(name = "password")
    WebElement enterPassword;

    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    WebElement ClkloginButton;

    @FindBy(className = "rd-navbar-panel")
    WebElement crmLogo;


/*    @FindBy(className = "user-display")
    WebElement usrLoggedIn;*/


    //Initializing the WebElements using Page Factory Class

  public LoginPage(){

      PageFactory.initElements(driver, this);   // pointing to current class objects

  }


  // Actions
   public String validateCRMPageTitle(){
      return driver.getTitle();
   }

   public boolean validateCRMLogo(){
      return crmLogo.isDisplayed();
   }

   public void clkLoginIn(){
       freeCRMLoginButton.click();

   }

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }


   public HomePage userLogin(String un, String pwd){

       //freeCRMLoginButton.click();
       enterUserName.sendKeys(un);
       enterPassword.sendKeys(pwd);
       ClkloginButton.click();

       return new HomePage();



   }











}

