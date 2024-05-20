package GetWindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class MultipleWindows {

    @Test
    public void practice(){
        //Setup Automation
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");

        //Click Button 4 which opens 3 Tabs
        WebElement button4=driver.findElement(By.cssSelector("#newTabsBtn"));
        BrowserUtils.scrollWithJS(driver,button4);
        button4.click();

        //Switching Window and Validate Success Message
        BrowserUtils.switchWindow(driver,"Basic Controls");
        WebElement firstName=driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Baldir");
        WebElement gender=driver.findElement(By.cssSelector("#malerb"));
        BrowserUtils.scrollWithJS(driver,gender);
        gender.click();
        WebElement englishBox=driver.findElement(By.cssSelector("#englishchbx"));
        BrowserUtils.scrollWithJS(driver,englishBox);
        englishBox.click();
        WebElement email=driver.findElement(By.cssSelector("#email"));
        email.sendKeys("Ahmet@gmail.com");
        WebElement password=driver.findElement(By.cssSelector("#password"));
        password.sendKeys("12354");
        WebElement registerButton=driver.findElement(By.cssSelector("#registerbtn"));
        registerButton.click();
        WebElement message=driver.findElement(By.cssSelector("#msg"));
        String actualMessage=BrowserUtils.getText(message);
        String expectedMessage="Registration is Successful";
        Assert.assertEquals(actualMessage,expectedMessage);
        String actualColor=message.getCssValue("color");
        String expectedColor="rgba(0, 128, 0, 1)";
        Assert.assertEquals(actualColor,expectedColor);

        //Switch window back to Window handle Practice and validate Header
        BrowserUtils.switchWindow(driver,"Window Handles Practice");
        WebElement header=driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="Window Handles Practice";
        Assert.assertEquals(actualHeader,expectedHeader);

        //Switching window back to AlertsDemo and validate header
        BrowserUtils.switchWindow(driver,"AlertsDemo");
        WebElement alertsDemoHeader= driver.findElement(By.xpath("//h1[contains(text(),'AlertsDemo')]"));
        String actualAlertHeader=BrowserUtils.getText(alertsDemoHeader);
        String expectedAlertHeader="AlertsDemo";
        Assert.assertEquals(actualAlertHeader,expectedAlertHeader);
        WebElement promptBox=driver.findElement(By.cssSelector("#promptBox"));
        promptBox.click();

        /*
        1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
        2-scroll down to button 4 and Click open multiple tabs under Button 4
        3-the Basic Control and fill all the blanks
        4-Click Register button and validate the message "Registration is Successful" and color
        5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
        6- go to the alertsDemo page and validate "AlertsDemo" then click  the "Click Me" button under prompt box
        7-Proud of yourself
 */
    }
}
