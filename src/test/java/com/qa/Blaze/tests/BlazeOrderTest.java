package com.qa.Blaze.tests;

import com.qa.Blaze.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BlazeOrderTest extends  BlazeTestBase{

    @Test
    public void validateOrderFunctionality() throws InterruptedException {
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        BlazeLoginPage blazeLoginPage=new BlazeLoginPage(driver);
        BlazeProductPage blazeProductPage=new BlazeProductPage(driver);
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        BlazeOrderPage blazeOrderPage=new BlazeOrderPage(driver);
        blazeMainPage.clickLoginButton();
        blazeLoginPage.login();
        blazeMainPage.chooseCategory("Laptops");
        blazeMainPage.chooseProduct("MacBook Pro");
        blazeProductPage.productInformationAndAddToCart(driver,"MacBook Pro",
                "$1100 *includes tax","MacBook Pro","Product added.");
        blazeMainPage.clickCartButton();
        blazeCartPage.clickPlaceOrderButton();
        blazeOrderPage.orderInformation(driver,"Ahmet","USA","Chicago","1231232",
                "12","2025","Thank you for your purchase!","https://www.demoblaze.com/index.html");
    }

    @Parameters({"category","product","price","message","name","country","city","cardNumber","month","year","successMessage","url"})
    @Test
    public void validateOrderFunctionalityParameter(String category,String product,String price,String message,String name,String country,
                                                    String city,String cardNumber,String month,String year,String successMessage,String url) throws InterruptedException {
        BlazeMainPage blazeMainPage=new BlazeMainPage(driver);
        BlazeLoginPage blazeLoginPage=new BlazeLoginPage(driver);
        BlazeProductPage blazeProductPage=new BlazeProductPage(driver);
        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        BlazeOrderPage blazeOrderPage=new BlazeOrderPage(driver);
        blazeMainPage.clickLoginButton();
        blazeLoginPage.login();
        blazeMainPage.chooseCategory(category);
        blazeMainPage.chooseProduct(product);
        blazeProductPage.productInformationAndAddToCart(driver,product, price,product,message);
        blazeMainPage.clickCartButton();
        blazeCartPage.clickPlaceOrderButton();
        blazeOrderPage.orderInformation(driver,name,country,city,cardNumber, month,year,successMessage,url);
    }
}
