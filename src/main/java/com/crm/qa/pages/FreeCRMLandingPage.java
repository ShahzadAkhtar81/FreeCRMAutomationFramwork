package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.TagName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeCRMLandingPage extends TestBase {

    @FindBy(className = "brand-name")
    WebElement freeCRMLogo;

    @FindBy(xpath = "//span[text()='Log In']")
    WebElement loginButton;

    @FindBy(linkText = "Sign Up")
    WebElement usrSignUp;

    @FindBy(linkText = "About")
    WebElement usrAbout;

    @FindBy(linkText = "CRM")
    WebElement usrCRM;

    @FindBy(linkText = "Apps")
    WebElement usrApps;

    @FindBy(linkText = "Pricing")
    WebElement usrPricing;


    // Initiate WebElements
    public FreeCRMLandingPage(){

        PageFactory.initElements(driver,this);
    }

    //Actions

    public String crmTitleValidation(){
        return driver.getTitle();
    }

    public boolean crmLogoValidation(){
        return freeCRMLogo.isDisplayed();
    }

    public void clkSignUpLink(){
        usrSignUp.click();
    }

    public void clkAboutLink(){
        usrAbout.click();



    }

    public void clkCRMLink(){
       usrCRM.click();
    }

    public void clkAPPSLink(){
       usrApps.click();
    }

    public void clkPricingLink(){
       usrPricing.click();
    }

    public LoginPage clkloginButton(){
        loginButton.click();

        return new LoginPage();
    }

}
