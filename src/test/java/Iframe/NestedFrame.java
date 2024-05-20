package Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class NestedFrame {

    @Test
    public void nestedFramePractice(){
        //Setup automation
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //Get into LEFT FRAME BUT FIRST TOP FRAME BECAUSE IT IS NESTED FRAME(FRAME-SET) (ID OR NAME)
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getText(left));

        //Get Out from Left Frame
        driver.switchTo().parentFrame();

        //GET INTO MIDDLE FRAME (WEB ELEMENT)
        WebElement middleFrame=driver.findElement(By.xpath("//frame[@name='frame-middle']"));
        driver.switchTo().frame(middleFrame);
        WebElement middleText=driver.findElement(By.cssSelector("#content"));
        System.out.println(BrowserUtils.getText(middleText));

        //GET OUT FROM MIDDLE FRAME
        driver.switchTo().parentFrame();

        //GET INTO RIGHT FRAME(ID-NAME)
        driver.switchTo().frame("frame-right");
        WebElement rightText=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(rightText));

        //GET OUT 2 times because of nested frame (TOP FRAME and MAIN HTML --> BOTTOM FRAME) -->INDEX
//        driver.switchTo().parentFrame();//TOP FRAME
//        driver.switchTo().parentFrame();//MAIN HTML
        driver.switchTo().defaultContent();//directly goes to the main html
        driver.switchTo().frame(1);//TOP FRAME(INDEX 0) -->BOTTOM FRAME(1)
        WebElement bottomText=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottomText));

    }
}
