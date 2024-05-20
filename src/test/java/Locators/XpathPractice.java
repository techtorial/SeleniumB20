package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathPractice {
    public static void main(String[] args) {
        /*
    1-Navigate to the http://tutorialsninja.com/demo/index.php?route=account/register
    2-Provide all the information
    3-Check the privacy box is displayed, not selected and enabled then click'
    4-Click Continue Button
    5-Validate the message "Your Account Has Been Created!" (XPATH CONTAINS)
    6-Click Continue Button (XPATH .=)
    7-Validate the current Url "https://tutorialsninja.com/demo/index.php?route=account/account"
    8-driver.quit()
    NOTE:Please use all XPATH Locator
     */

        WebDriver driver=new ChromeDriver();
        driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=account/register");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//it waits for the element for specific time(max 10 sec)
        WebElement firstName=driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Ahmet");
        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Baldir");
        WebElement email=driver.findElement(By.xpath("//input[@placeholder='E-Mail']"));
        email.sendKeys("ahmet545454335@gmail.com");
        WebElement phone=driver.findElement(By.xpath("//input[@type='tel']"));
        phone.sendKeys("12312312312");
        WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("Ahmet123");
        WebElement rePassword=driver.findElement(By.xpath("//input[@id='input-confirm']"));
        rePassword.sendKeys("Ahmet123");
        WebElement privacyBox=driver.findElement(By.xpath("//input[@name='agree']"));
        if(privacyBox.isDisplayed() && privacyBox.isEnabled() && !privacyBox.isSelected()){
            privacyBox.click();
        }
        System.out.println(privacyBox.isSelected());
        WebElement continueButton=driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();
        WebElement header=driver.findElement(By.xpath("//h1[contains(text(),'Created')]"));
        String actualHeader=header.getText().trim();//website
        String expectedHeader="Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader) ? "Header PASSED" : "Header FAILED");
        WebElement continueButton2=driver.findElement(By.xpath("//a[.='Continue']"));
        continueButton2.click();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://tutorialsninja.com/demo/index.php?route=account/account";
        System.out.println(actualUrl.equals(expectedUrl) ? "URL PASSED" : "URL FAILED");
        driver.quit();
    }
}
