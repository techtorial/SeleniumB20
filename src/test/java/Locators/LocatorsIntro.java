package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LocatorsIntro {

    public static void main(String[] args) {
        //LOCATOR : ID
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/techtorial/Downloads/Techtorialhtml%20(1).html");
        WebElement header=driver.findElement(By.id("techtorial1"));
        String actualText=header.getText();//Techtorial Academy
        String expectedText="Techtorial Academy";
        Assert.assertEquals(actualText,expectedText);
        System.out.println(actualText.equals(expectedText) ? "Text Is Correct" : "Text is Wrong");
        WebElement paragraph=driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());
        //LOCATOR : NAME
        WebElement firstName=driver.findElement(By.name("firstName"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("Baldir");
        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("132342343");
        WebElement email=driver.findElement(By.id("userName"));
        email.sendKeys("ahmet@gmail.com");
        WebElement address=driver.findElement(By.name("address1"));
        address.sendKeys("2400 HanoverPark");
        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("Chicago");
        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("IL");
        WebElement postCode=driver.findElement(By.name("postalCode"));
        postCode.sendKeys("12343");

        //LOCATOR: CLASS
        WebElement allTools=driver.findElement(By.className("group_checkbox"));
        String actualToolText=allTools.getText();
        String expectedToolText="All Tools";
        System.out.println(actualToolText.equals(expectedToolText) ? "TEXT PASSED" : "TEXT FAILED");

        WebElement javaBox=driver.findElement(By.id("cond1"));
        System.out.println(javaBox.isSelected());//false
        if(javaBox.isDisplayed() && javaBox.isEnabled() && !javaBox.isSelected()){
            javaBox.click();
        }
        System.out.println(javaBox.isSelected());//true
        WebElement testNG=driver.findElement(By.id("cond3"));
        System.out.println(testNG.isSelected());
        if(testNG.isDisplayed()&& testNG.isEnabled() && !testNG.isSelected()){
            testNG.click();
        }
        System.out.println(testNG.isSelected());
        driver.quit();
    }

}
