package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {
        //LOCATOR: TAG NAME
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/techtorial/Downloads/Techtorialhtml%20(1).html");
        WebElement javaVersion = driver.findElement(By.tagName("u"));
        System.out.println(javaVersion.getText());

        //LOCATOR:LINK-TEXT
        WebElement javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();
        WebElement javaHeader = driver.findElement(By.tagName("h1"));
        System.out.println(javaHeader.getText());
        driver.navigate().back();
        WebElement seleniumButton = driver.findElement(By.linkText("Selenium"));
        seleniumButton.click();
        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));
        System.out.println(seleniumHeader.getText());
        driver.navigate().back();
        javaLink = driver.findElement(By.linkText("Java"));
        javaLink.click();

        WebElement cucumber = driver.findElement(By.linkText("Cucumber"));
        cucumber.click();
        WebElement cucumberHeader = driver.findElement(By.className("font-light"));
        System.out.println(cucumberHeader.getText());
        driver.navigate().back();
        driver.navigate().refresh();

        //LOCATOR:PARTIAL LINK TEXT

        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();

        //LOCATOR:CSS

        WebElement headerCss=driver.findElement(By.cssSelector("#techtorial1"));//id
        System.out.println(headerCss.getText());
        WebElement allTools=driver.findElement(By.cssSelector(".group_checkbox"));//class
        System.out.println(allTools.getText());
        //MY LOCATOR USAGE RANK:
        //CSS,XPATH,ID,NAME,Class...
        driver.quit();
    }
}
