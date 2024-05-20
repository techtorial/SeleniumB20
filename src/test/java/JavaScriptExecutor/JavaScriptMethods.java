package JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.swing.*;
import java.time.Duration;

public class JavaScriptMethods {

    @Test
    public void getTitleJS(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");
        System.out.println(driver.getTitle() + " Selenium getTitle");//%99
        System.out.println(BrowserUtils.getTitleWithJS(driver));
//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        System.out.println(js.executeScript("return document.title")+" JS TITLE"); //guarantee
//        String actualTitle= (String) js.executeScript("return document.title");
//        String expectedTitle="Kickstart Your Tech Career with Our Top-Rated Coding Bootcamp";
//        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void clickJS(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");
        WebElement aboutUs=driver.findElement(By.xpath("//span[.='About Us']"));
//        aboutUs.click();//not working
//        Actions actions=new Actions(driver); //did not work
//        actions.click(aboutUs).perform();
//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click()",aboutUs);
        BrowserUtils.clickWithJS(driver,aboutUs);
    }

    @Test
    public void scrollIntoView() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/");
        WebElement copyRight=driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true)",copyRight);
        BrowserUtils.scrollWithJS(driver,copyRight);
        Thread.sleep(3000);
        System.out.println(BrowserUtils.getText(copyRight));
        WebElement launchTop=driver.findElement(By.xpath("//b[.='LAUNCH A NEW TECH CAREER']"));
//        js.executeScript("arguments[0].scrollIntoView(true)",launchTop);
        BrowserUtils.scrollWithJS(driver,launchTop);
    }

}
