package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasicsTest
{

    @BeforeSuite
    public void setUp()
    {
        System.out.println("Set up system property for Chrome browser");
    }

    @BeforeTest
    public void launchBrowser()
    {
        System.out.println("Launch chrome browser");
    }
    
    @BeforeClass
    public void  enterUrl()
    {
        System.out.println("Entering URL");
    }
     

    @BeforeMethod
    public void login()
    {
        System.out.println("Login to webpage");
    }

     

    @Test
    public void getTitleTest()
    {
        System.out.println("Title for the test");
    }

    @AfterMethod
    public void logOut()
    {
        System.out.println("Logging out");
    }
    
    @AfterClass
    public void CloseBrowser()
    {
        System.out.println("Closing browser");
    }
    
    @AfterTest
    public void deleteAllCookies()
    {
        System.out.println("Deleeting all coockies");
    }
     
    @AfterSuite
    public void generateReport()
    {
        System.out.println("Generating report");
    }
    
}