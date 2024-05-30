package com.qa.Spruce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpruceMainPage {

    public SpruceMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement ingredients;

    @FindBy(xpath = "//a[.='Fish & Seafood']")
    WebElement fishSeaFood;


    public void clickSeaFood(WebDriver driver){
        Actions actions=new Actions(driver);
        actions.moveToElement(ingredients).perform();
        fishSeaFood.click();
    }





}
