package com.crm.qa.base;

import com.crm.qa.utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {

    public static WebDriver driver;
    public static Properties prop;


    // Create Constructor to load properties files as we create object of this class
    public TestBase(){

        try{
              prop = new Properties();
            FileInputStream file = new FileInputStream("/Users/shahzadakhtar/Downloads/FreeCRMTestAutomation/src/main/java/com/crm/qa/config/config.properties");
            prop.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Reading the properties from config.properties file
    public static void initialization(){

        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/shahzadakhtar/Downloads/drivers/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("firefox")){
            System.setProperty("webdriver.gecho.driver","/Users/shahzadakhtar/Downloads/drivers/geckodriver");
            driver =  new FirefoxDriver();

            }
        else {
            System.out.println("Please provide the valid Browser name for testing");
            }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.implicitwait, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
        }

    }


