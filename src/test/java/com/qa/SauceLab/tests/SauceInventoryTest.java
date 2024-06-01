package com.qa.SauceLab.tests;

import com.qa.SauceLab.pages.SauceInventoryPage;
import com.qa.SauceLab.pages.SauceLoginPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class SauceInventoryTest extends SauceTestBase{

    @Test(dataProvider = "inventoryTest",dataProviderClass = SauceAllData.class)
    public void validateAllProductInformation(String expectedHeader,String expectedDescription,String expectedPrice){
        SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
        sauceLoginPage.login(ConfigReader.readProperty("sauce_username"),
                             ConfigReader.readProperty("sauce_password"));
        SauceInventoryPage sauceInventoryPage=new SauceInventoryPage(driver);
        sauceInventoryPage.chooseItem(expectedHeader);
        sauceInventoryPage.productInformation(expectedHeader, expectedDescription,expectedPrice);
    }











}
