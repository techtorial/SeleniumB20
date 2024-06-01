package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class ExplicitlyWait {

    /*
    Another way to handle wait time issue, but we need a certain
    condition to use it.
     */
    @Test
    public void practice(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton=driver.findElement(By.tagName("button"));
        startButton.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement header=driver.findElement(By.xpath("//h4[.='Hello World!']"));
        header=wait.until(ExpectedConditions.visibilityOf(header));
        Assert.assertEquals(BrowserUtils.getText(header),"Hello World!");
    }

}
