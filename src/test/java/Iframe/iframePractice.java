package Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class iframePractice {

    @Test
    public void test() {
        //Setup automation
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Printing the header and Writing I love Selenium in Box with Switching Frame
        WebElement header=driver.findElement(By.xpath("//h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr");
        WebElement box=driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I love Selenium");

        //Switching Frame again to get out from Sub-Frame
        driver.switchTo().parentFrame();
        WebElement seleniumLink=driver.findElement(By.partialLinkText("Elemental"));
        seleniumLink.click();
    }

    @Test
    public void practiceFrame() throws InterruptedException {
        //Setup automation
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://skpatro.github.io/demo/iframes/");

        //Click Pavilion and Switch my Window
        WebElement pavilion=driver.findElement(By.linkText("Pavilion"));
        pavilion.click();
        BrowserUtils.switchWindow(driver,"qavalidation");

        //Click Selenium then Selenium-Phyton
        WebElement seleniumButton=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']//span"));
        Actions actions=new Actions(driver);
        actions.moveToElement(seleniumButton).perform();
        WebElement seleniumPhyton=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Python']//span"));
        actions.click(seleniumPhyton).perform();
        driver.navigate().refresh();
        seleniumButton=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']//span"));
        actions.moveToElement(seleniumButton).perform();
       seleniumPhyton=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Python']//span"));
        actions.click(seleniumPhyton).perform();
        List<WebElement> allLinks=driver.findElements(By.xpath("//p//a"));

        //Validate Link Size
        for(WebElement link:allLinks){
            System.out.println(BrowserUtils.getText(link));
        }
        Assert.assertEquals(allLinks.size(),22);

        /*
          TASK 1:
        1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
        2-Click Pavilion
        3-Hover Over Selenium then click Selenium-Phyton
        4-Print out all the links(only links) and validate size is 22
       */

        //Switch Back to Iframe Window, Switch Iframe and Click Category 1
        BrowserUtils.switchWindow(driver,"iframes");
        driver.switchTo().frame("Framename1");//name, you can also use id
        WebElement category1=driver.findElement(By.linkText("Category1"));
        category1.click();

        //Switch your window again since it opens new one and Validate Header
        BrowserUtils.switchWindow(driver,"SeleniumTesting Archives");
        WebElement header=driver.findElement(By.tagName("h1"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="Category Archives: SeleniumTesting";
        Assert.assertEquals(actualHeader,expectedHeader);

        //Print out headers and validate Size
        List<WebElement> allTexts=driver.findElements(By.tagName("h3"));

        for(WebElement text:allTexts){
            System.out.println(BrowserUtils.getText(text));
        }
        Assert.assertEquals(allTexts.size(),9);

/*
        TASK2:
        1-Click the category 1 button
        2-Validate the header is "Category Archives: SeleniumTesting"
        3-Print out the top of the each box(text) and validate size is 9 I showed you during manual steps
*/

        //Switching window to iframes and Print out I am inside frame
        BrowserUtils.switchWindow(driver,"iframes");
        WebElement iframe1=driver.findElement(By.cssSelector("#Frame1"));
        driver.switchTo().frame(iframe1);
        WebElement text=driver.findElement(By.cssSelector("#frametext"));
        System.out.println(BrowserUtils.getText(text));

        //Switching frame back to normal(parent-frame(main html) and switch to frame2 because category3 in it
        driver.switchTo().parentFrame();//get out from previous frame
        driver.switchTo().frame("Frame2");//get in new frame
        WebElement category3=driver.findElement(By.linkText("Category3"));
        category3.click();
        BrowserUtils.switchWindow(driver,"SoftwareTesting Archives");
        WebElement headerSoftware=driver.findElement(By.tagName("h1"));
        System.out.println(BrowserUtils.getText(headerSoftware));

        /*
        TASK3:
        1-Go to the iframe tab
        2-print out "I am inside Frame"
        3-Click category 3
        4-print out the header "Category Archives: SoftwareTesting"
         */
    }

}
