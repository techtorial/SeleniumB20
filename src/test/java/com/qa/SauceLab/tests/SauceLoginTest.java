package com.qa.SauceLab.tests;

import com.qa.SauceLab.pages.SauceLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceLoginTest extends SauceTestBase{

    @Test(dataProvider = "positiveLogin",dataProviderClass = SauceAllData.class)
    public void happyPathLogin(String username,String password,String expectedTitle){
        SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
        sauceLoginPage.login(username,password);
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }

    @Test(dataProvider = "negativeLogin",dataProviderClass = SauceAllData.class)
    public void negativeLogin(String username,String password,String expectedMessage){
        SauceLoginPage sauceLoginPage=new SauceLoginPage(driver);
        sauceLoginPage.login(username,password);
        Assert.assertEquals(sauceLoginPage.errorMessage(),expectedMessage);
    }


}
