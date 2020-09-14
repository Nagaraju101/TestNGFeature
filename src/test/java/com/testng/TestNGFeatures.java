package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGFeatures
{

    WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setAcceptInsecureCerts(true);

        ChromeOptions co = new ChromeOptions();
        co.merge(dc);
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("BeforeMethod");
    }

    @Test
    public void loginTest()
    {
        System.out.println("Login Test");
    }

    @Test(dependsOnMethods = "loginTest")
    public void homePageTest()
    {
        System.out.println("Home Page Test");

    }

    @Test(dependsOnMethods = "homePageTest")
    public void logoutTest()
    {
        System.out.println("Home Page Test");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
        System.out.println("After Method");
    }

}
