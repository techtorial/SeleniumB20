package com.qa.Blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class BlazeProductPage {

    public BlazeProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h2")
    WebElement productHeader;

    @FindBy(xpath = "//h3")
    WebElement priceWithTax;

    @FindBy(xpath = "//div[@id='myTabContent']//p")
    WebElement description;

    @FindBy(linkText = "Add to cart")
    WebElement addToCartButton;

    public void productInformationAndAddToCart(WebDriver driver,String expectedHeader,String expectedPrice,
                                               String expectedDescription,String expectedMessage) throws InterruptedException {
        Assert.assertEquals(BrowserUtils.getText(productHeader),expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(priceWithTax),expectedPrice);
        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDescription));
        addToCartButton.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(),expectedMessage);
        alert.accept();
    }






}
