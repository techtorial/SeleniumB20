package com.qa.Blaze.tests;

import com.qa.Blaze.pages.BlazeLoginPage;
import com.qa.Blaze.pages.BlazeMainPage;
import com.qa.Blaze.pages.BlazeProductPage;
import org.testng.annotations.Test;

public class BlazeProductTest extends BlazeTestBase {


    @Test
    public void validateProductInfoAndAddToCartFunctionality() throws InterruptedException {
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        BlazeLoginPage blazeLoginPage=new BlazeLoginPage(driver);
        BlazeProductPage blazeProductPage=new BlazeProductPage(driver);
        blazeMainPage.clickLoginButton();
        blazeLoginPage.login();
        blazeMainPage.chooseCategory("Laptops");
        blazeMainPage.chooseProduct("MacBook Pro");
        blazeProductPage.productInformationAndAddToCart(driver,"MacBook Pro",
                "$1100 *includes tax","MacBook Pro","Product added.");
    }
}
