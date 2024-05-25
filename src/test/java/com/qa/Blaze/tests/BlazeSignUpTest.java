package com.qa.Blaze.tests;

import com.qa.Blaze.pages.BlazeMainPage;
import com.qa.Blaze.pages.BlazeSignUpPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class BlazeSignUpTest extends BlazeTestBase {

    @Test
    public void validateSignUpFunctionality() throws InterruptedException {
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        blazeMainPage.clickSignUpButton();
        BlazeSignUpPage blazeSignUpPage=new BlazeSignUpPage(driver);
        blazeSignUpPage.signUp(driver, ConfigReader.readProperty("username"),
                ConfigReader.readProperty("password"),"Sign up successful.");
    }
}

