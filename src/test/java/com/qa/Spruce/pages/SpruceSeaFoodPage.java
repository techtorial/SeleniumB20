package com.qa.Spruce.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class SpruceSeaFoodPage {


    public SpruceSeaFoodPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#search-form-input")
    WebElement searchBox;
    @FindBy(xpath = "//label[@for='starRating_score_4Star']")
    WebElement fourStar;
    @FindBy(xpath = "//label[@for='pop_search_editor']")
    WebElement editorBox;
    @FindBy(xpath = "//span[contains(text(),'Salmon')]")
    WebElement productTitle;

    public void searchItem(WebDriver driver,String searchWord) throws InterruptedException {
        Thread.sleep(2000);
        BrowserUtils.scrollWithJS(driver,searchBox);
        searchBox.sendKeys(searchWord, Keys.ENTER);
    }

    public void productInformation(String expectedTitle) throws InterruptedException {
        fourStar.click();
        editorBox.click();
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(productTitle),expectedTitle);
    }
}
