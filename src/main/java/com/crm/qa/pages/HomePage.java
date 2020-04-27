package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//span[text()='Shahzad Akhtar']")
    WebElement verifyUsrNameOnHomePage;

    @FindBy(xpath = "//span[text()='Home']")
    WebElement homeLink;

    @FindBy(xpath = "//span[text()='Calendar']")
    WebElement calendarLink;


    @FindBy(xpath = "//span[contains(text(),'Contacts')]")
    WebElement ContactsLink;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

    public boolean usrNameValidations(){
        return verifyUsrNameOnHomePage.isDisplayed();

    }

    public CalendarPage clkOnCalandarLink(){
        return new CalendarPage();
    }

    public ContactsPage clkOnContactsLink(){
        ContactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clkOnDealsLink(){
        return new DealsPage();
    }







}

