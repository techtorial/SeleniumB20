package com.qa.SauceLab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class SauceInventoryPage {

    public SauceInventoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".inventory_item_name")
    List<WebElement> allProducts;

    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    WebElement productHeader;

    @FindBy(xpath = "//div[@data-test='inventory-item-desc']")
    WebElement productDescription;

    @FindBy(xpath = "//div[@data-test='inventory-item-price']")
    WebElement productPrice;

public void chooseItem(String expectedItem){
    for(WebElement product:allProducts){
        if(BrowserUtils.getText(product).contains(expectedItem)){
            product.click();
            break;
        }
    }
}
public void productInformation(String expectedHeader,String expectedDescription,String expectedPrice){
    Assert.assertEquals(BrowserUtils.getText(productHeader),expectedHeader);
    Assert.assertTrue(BrowserUtils.getText(productDescription).contains(expectedDescription));
    Assert.assertEquals(BrowserUtils.getText(productPrice),expectedPrice);
}












}
