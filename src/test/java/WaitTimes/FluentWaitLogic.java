package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FluentWaitLogic {

    /*
    It is a way to handle wait times issue
     */

    @Test
    public void practice(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton=driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();

        Wait<WebDriver> fluentWait=new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(5))
                .withMessage("Text is not on the page")
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
           WebElement message=fluentWait.until(mydriver->driver.findElement(By.xpath("//p[@id='message']")));
        Assert.assertEquals(BrowserUtils.getText(message),"It's gone!");
    }

}
