package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//div[@class='ui header item mb5 light-black' and contains(text(),'Contacts')]")
    WebElement verifyContactsLabel;

    @FindBy(xpath= "//div[@class='ui checked fitted read-only checkbox']//input[@name='id']")
    WebElement clkCheckBox;

    @FindBy(xpath = "//button[contains(text(),'New')]")
    WebElement clkNewButton;

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement fname;

    @FindBy(xpath="//input[@name='last_name']")
    WebElement lname;

    @FindBy(xpath="//div[@name='company']//input[@class='search']")
    WebElement companyLookup;

    @FindBy(xpath="//input[@placeholder='Email address']")
    WebElement customerEmail;

    @FindBy(xpath="//input[@placeholder='Street Address']")
    WebElement customerAddress;

    @FindBy(xpath = "//input[@placeholder='Number']")
    WebElement phoneNumber;

    @FindBy(xpath = "//button[@class='ui linkedin button']")
    WebElement clkSaveButton;


    public void ContactsPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean verifyContactLabel(){
        return verifyContactsLabel.isDisplayed();

    }

    public void selectContactsByName(String name){
        driver.findElement(By.xpath("//table//td[contains(text(),'"+name+"')]//parent::td[@class='ui fitted read-only checkbox']" +
                "//preceding-sibling::td[@class='ui fitted read-only checkbox']//input[@name='id']")).click();
    }

    //public void createNewContact(String first_name, String last_Name, String Company,String email, String Address, String phNumber){
    public void createNewContact(){
        clkNewButton.click();
        fname.sendKeys("Shahzad");
        lname.sendKeys("Akhtar");
        companyLookup.sendKeys("NBC");
        customerEmail.sendKeys("Shahzad@NBC.com");
        customerAddress.sendKeys("1231 avenue j");
        phoneNumber.sendKeys("7145256545");
        clkSaveButton.click();




    }








}
