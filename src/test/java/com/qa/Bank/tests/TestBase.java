package com.qa.Bank.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;

import java.time.Duration;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod //It will run before every @Test Annotation
    public void setup(){
        //SETUP AUTOMATION
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(ConfigReader.readProperty("qa_url"));
    }

    @AfterMethod //It will run after every @Test Annotation
    public void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            BrowserUtils.getScreenShot(driver,"bank");
        }
        driver.quit();
    }
}
