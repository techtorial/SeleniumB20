package com.qa.Blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BlazeMainPage {

    public BlazeMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#signin2")
    WebElement signUpButton;

    @FindBy(css = "#login2")
    WebElement loginButton;

    @FindBy(css = "#nameofuser")
    WebElement usernameHeader;

    public void clickSignUpButton(){
        signUpButton.click();
    }
    public void clickLoginButton(){
        loginButton.click();
    }

    public void headerInformation(String expectedHeader) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(usernameHeader.isDisplayed());
        Assert.assertTrue(BrowserUtils.getText(usernameHeader).startsWith(expectedHeader));
    }
}
