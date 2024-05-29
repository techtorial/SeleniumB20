package com.qa.Blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

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

    @FindBy(xpath = "//a[@id='itemc']")
    List<WebElement> allCategories;

    @FindBy(xpath = "//a[@class='hrefch']")
    List<WebElement> allProducts;

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

    public void chooseCategory(String expectedCategory) throws InterruptedException {
        Thread.sleep(2000);
        for(WebElement category:allCategories){
            if(BrowserUtils.getText(category).contains(expectedCategory)){
                category.click();
                break;
            }
        }
    }

    public void chooseProduct(String expectedProduct) throws InterruptedException {
        Thread.sleep(2000);
        for(WebElement product:allProducts){
            if(BrowserUtils.getText(product).contains(expectedProduct)){
                product.click();
                break;
            }
        }
    }
}
