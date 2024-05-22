package com.qa.Bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BankLoginPage {

    public BankLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[.='Home']")
    WebElement homeButton;
    @FindBy(xpath = "//button[.='Bank Manager Login']")
    WebElement managerLoginButton;
    @FindBy(xpath = "//button[contains(@ng-click,'customer')]")
    WebElement customerLoginButton;
    @FindBy(css = ".mainHeading")
    WebElement header;


    public void loginPageInformation(WebDriver driver,String expectedHeader,String expectedTitle,String expectedUrl){
        Assert.assertTrue(homeButton.isDisplayed() && homeButton.isEnabled());
        Assert.assertTrue(managerLoginButton.isEnabled() && managerLoginButton.isDisplayed());
        Assert.assertTrue(customerLoginButton.isEnabled() && customerLoginButton.isDisplayed());
        Assert.assertEquals(BrowserUtils.getText(header),expectedHeader);
        Assert.assertEquals(driver.getTitle(),expectedTitle);
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }



}
