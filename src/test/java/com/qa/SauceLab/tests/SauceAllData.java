package com.qa.SauceLab.tests;

import org.testng.annotations.DataProvider;

public class SauceAllData {

    @DataProvider(name = "positiveLogin")
    public Object[][] getPositiveLoginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "Swag Labs"},
                {"problem_user", "secret_sauce", "Swag Labs"},
                {"performance_glitch_user", "secret_sauce", "Swag Labs"},
                {"error_user", "secret_sauce", "Swag Labs"},
                {"visual_user", "secret_sauce", "Swag Labs"}
        };
    }

    @DataProvider(name = "negativeLogin")
    public Object[][] getNegativeLoginData() {
        return new Object[][]{
                {"standard_user", "wrongpassword", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @DataProvider(name = "inventoryTest")
    public Object[][] inventoryTestData() {
        return new Object[][]{
                {"Sauce Labs Backpack","Sly Pack","$29.99"},
                {"Sauce Labs Bike Light","Water-resistant","$9.99"},
                {"Sauce Labs Bolt T-Shirt","T-shirt","$15.99"},
                {"Sauce Labs Fleece Jacket","midweight quarter","$49.99"},
                {"Sauce Labs Onesie","automation engineer","$7.99"},
                {"Test.allTheThings() T-Shirt (Red)","Labs t-shirt","$15.99"}
        };
    }

}
