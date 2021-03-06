package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest
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

    @Test(priority = 1, groups = "Title")
    public void googleTitleTest1()
    {

        String title = driver.getTitle();
        Assert.assertEquals(title, "Google");

        System.out.println("test1 Method executed");
    }

    @Test(priority = 2, groups = "Logo")
    public void googleTitleTest2()
    {

        boolean title = driver.getTitle().contains("Google123");
        Assert.assertFalse(title, "Google");

        System.out.println("test2 Method executed");
    }

    @Test(priority = 3, groups = "Logo")
    public void googleTitleTest3()
    {

        boolean title = driver.getTitle().contains("Google123");
        Assert.assertFalse(title, "Google");

        System.out.println("test3 Method executed");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
        System.out.println("driver quit method got executed");
    }
}
