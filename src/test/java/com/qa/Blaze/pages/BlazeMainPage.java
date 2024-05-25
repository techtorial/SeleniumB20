package com.qa.Blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeMainPage {

    public BlazeMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#signin2")
    WebElement signUpButton;

    public void clickSignUpButton(){
        signUpButton.click();
    }
}
