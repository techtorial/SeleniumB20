package com.qa.Spruce.tests;

import com.qa.Spruce.pages.SpruceMainPage;
import com.qa.Spruce.pages.SpruceSeaFoodPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SpruceSeaFoodTest extends SpruceTestBase{

    @Parameters({"searchWord","expectedTitle"})
    @Test
    public void validateProductInformation(String searchWord,String expectedTitle) throws InterruptedException {
        SpruceMainPage spruceMainPage=new SpruceMainPage(driver);
        spruceMainPage.clickSeaFood(driver);
        SpruceSeaFoodPage spruceSeaFoodPage=new SpruceSeaFoodPage(driver);
        spruceSeaFoodPage.searchItem(driver,searchWord);
        spruceSeaFoodPage.productInformation(expectedTitle);
    }
}
