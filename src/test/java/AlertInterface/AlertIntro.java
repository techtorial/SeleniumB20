package AlertInterface;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {

    @Test
    public void Test(){
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Finding the alert and Handle with Alert Class
        WebElement jSAlert=driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        jSAlert.click();

        //you are switching your driver to alert
        Alert alert=driver.switchTo().alert();
        alert.accept(); //CLICK OK BUTTON

        //Validate the message
        WebElement message=driver.findElement(By.cssSelector("#result"));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage="You successfully clicked an alerts ";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualMessage,expectedMessage);
//        Assert.assertEquals(actualMessage,expectedMessage);

        //Finding the JS Confirm Button and Switch alert
        WebElement jsConfirm=driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        jsConfirm.click();
//        alert=driver.switchTo().alert(); //YOu do not need to re-assing alert.
        System.out.println(alert.getText());//It GETS THE TEXT FROM POP-UP
        alert.dismiss(); //IT CLICKS CANCEL BUTTON FROM POP-UP

        //VALIDATE MESSAGE
        message=driver.findElement(By.cssSelector("#result"));
        String actualMessageJS= BrowserUtils.getText(message);
        String expectedMessageJS="You clicked: Cancel";
//        Assert.assertEquals(actualMessageJS,expectedMessageJS);
        softAssert.assertEquals(actualMessageJS,expectedMessageJS);


        //FINDING THE PROMPT ELEMENT AND HANDLE ALERT
        WebElement promptButton=driver.findElement(By.xpath("//button[contains(text(),'JS Prompt')]"));
        promptButton.click();
        alert.sendKeys("I love Selenium"); //It sends data to the Alert Box
        alert.accept();

        //VALIDATE MESSAGE
        message=driver.findElement(By.cssSelector("#result"));
        System.out.println(BrowserUtils.getText(message));
        String actualMessagePrompt= BrowserUtils.getText(message);
        String expectedMessagePrompt="You entered: I love Selenium";
//        Assert.assertEquals(actualMessagePrompt,expectedMessagePrompt);
        softAssert.assertEquals(actualMessagePrompt,expectedMessagePrompt);
        softAssert.assertAll();
    }
}
