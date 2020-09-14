package com.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterTest
{
    WebDriver driver;

    @Test(enabled=true)
    @Parameters({ "browser", "url", "emailId", "password" })
    public void yahooLoginTest(String browser, String url, String emailId, String password)
    {
        if (browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();

            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setAcceptInsecureCerts(true);
            ChromeOptions co = new ChromeOptions();
            co.merge(dc);
            driver = new ChromeDriver(co);
        }
        else
            if (browser.equalsIgnoreCase("edge"))
            {
                WebDriverManager.edgedriver().setup();
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setAcceptInsecureCerts(true);
                EdgeOptions co = new EdgeOptions();
                co.merge(dc);
                driver = new EdgeDriver(co);
            }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("BeforeMethod");
        driver.findElement(By.id("login-username")).clear();
        driver.findElement(By.id("login-username")).sendKeys(emailId);
        driver.findElement(By.id("login-signin")).click();
        driver.findElement(By.id("login-passwd")).clear();
        driver.findElement(By.id("login-passwd")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='login-signin']")).click();

    }

}
