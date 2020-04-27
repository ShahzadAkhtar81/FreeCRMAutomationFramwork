package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    String sheetName = "contacts";




  @BeforeMethod
    public void setup(){
      initialization();
      loginPage = new LoginPage();
      loginPage.clkLoginIn();
      homePage = loginPage.userLogin(prop.getProperty("username"),prop.getProperty("password"));
      contactsPage = new ContactsPage();
      contactsPage = homePage.clkOnContactsLink();
      homePage = new HomePage();
      testUtil = new TestUtil();
  }


  @Test(priority = 1)
  public void verifyContactsPage(){
      Assert.assertTrue(contactsPage.verifyContactLabel(),"Contacts label is missing on the page");
  }


 /* @DataProvider*/
 /* public Object[][] getCrmTestData(){*/
 /*  Object data[][] = TestUtil.getTestData(sheetName);*/
 /*  return data;*/
 /* }*/

  /* @Test(priority = 2,dataProvider = "getCrmTestData")*/
  /*   public void validateCreateNewContact(String fname, String lname, String comp, String email, String add, String ph ){*/
  /*    contactsPage.createNewContact();*/
  /* }*/

     @Test(priority = 2)
     public void validateCreateNewContact(){
         contactsPage.createNewContact();
         
     }



  @AfterMethod
    public void tearDown(){
      //driver.quit();

  }
}
