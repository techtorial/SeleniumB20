package com.qa.Blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BlazeOrderPage {

    public BlazeOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#name")
    WebElement name;
    @FindBy(xpath = "//*[@id='country']")
    WebElement country;
    @FindBy(css = "#city")
    WebElement city;
    @FindBy(css = "#card")
    WebElement creditCard;
    @FindBy(css = "#month")
    WebElement month;
    @FindBy(css = "#year")
    WebElement year;
    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;
    @FindBy(xpath = "//h2[contains(text(),'Thank you')]")
    WebElement message;
    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void orderInformation(WebDriver driver,String name,String country,String city,String cardNumber,
                                 String month,String year,String expectedMessage,String expectedUrl) throws InterruptedException {
        Thread.sleep(1000);
        this.name.sendKeys(name);
        this.country.sendKeys(country);
        this.city.sendKeys(city);
        this.creditCard.sendKeys(cardNumber);
        Thread.sleep(1000);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        purchaseButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);
        okButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }
}
