package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homepage;


    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
       loginPage.clkLoginIn();
        homepage = loginPage.userLogin(prop.getProperty("username"),prop.getProperty("password"));

    }

    @Test(priority = 1)
    public void verifyHomePageTitle(){
        String hpTitle = homepage.verifyHomePageTitle();
        Assert.assertEquals(hpTitle,"Cogmento CRM", "Home Page title not Matched");
    }



    @Test(priority = 2)
    public void validateUserNameLabel(){
        boolean nameFlag = homepage.usrNameValidations();
        Assert.assertTrue(nameFlag);
    }







    @AfterMethod
    public void tearDown(){
        driver.quit();

    }



}
