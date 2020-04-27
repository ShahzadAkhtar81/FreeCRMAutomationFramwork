package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FreeCRMLandingPage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCRMLandingTest extends TestBase {

    FreeCRMLandingPage freeCrmObj;
    LoginPage loginPage;


    @BeforeMethod
    public void setUp(){
        initialization();
        freeCrmObj = new FreeCRMLandingPage();
    }

    @Test(priority = 1)
    public void freeCRMLandingTitleValidations(){
        String crmLanding = freeCrmObj.crmTitleValidation();
        Assert.assertEquals(crmLanding,"Free CRM #1 cloud software for any business large or small");
    }

    @Test(priority = 2)
    public void freeCRMLandingLogoValidations(){
        boolean CRMflag = freeCrmObj.crmLogoValidation();
        Assert.assertTrue(CRMflag);
    }

    @Test(priority = 3)
    public void usrClkLoginButton(){

        loginPage = freeCrmObj.clkloginButton();

    }


    @AfterMethod
    public void tearDown(){

        driver.quit();


    }



}
