package GetWindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test
    public void test(){
        //Setup Automation
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        WebElement clickHereButton=driver.findElement(By.linkText("Click Here"));
        clickHereButton.click();

        //SWITCHING WINDOW WITH LOGIC
        Set<String> allTabs=driver.getWindowHandles();
        System.out.println(allTabs);

        //WE WILL LOOP THROUGH THE TABS
        for(String pageId:allTabs){
            driver.switchTo().window(pageId);
            if(driver.getTitle().contains("New Window")){
                break;
            }
        }
        //PRINT OUT THE HEADER AFTER SWITCHING
        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));

    }

    @Test
    public void practice(){
        //Setup Automation
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");

        //CLICK BUTTON 2
        WebElement button2=driver.findElement(By.cssSelector("#newTabBtn"));
        BrowserUtils.scrollWithJS(driver,button2);
        button2.click();

        //SWITCH YOUR WINDOW
//        Set<String> allTabs=driver.getWindowHandles();
//        for(String tab:allTabs){
//            driver.switchTo().window(tab);
//            if(driver.getTitle().contains("AlertsDemo")){
//                break;
//            }
//        }
        BrowserUtils.switchWindow(driver,"AlertsDemo");

        //VALIDATING HEADER
        WebElement header=driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="AlertsDemo";
        Assert.assertEquals(actualHeader,expectedHeader);

        //CLICK ALERT-BOX
        WebElement box=driver.findElement(By.cssSelector("#alertBox"));
        box.click();


/*
    1-Navigate to the website
    2-Click Button2 if it throws exception then scroll to the button
    3-Validate the header "AlertsDemo"
    4-Click the first click me button
       */

    }
}
