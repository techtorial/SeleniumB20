package FileUploads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class Practice {

    @Test
    public void test(){
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");

        //FINDING THE CHOOSE FILE LOCATION AND UPLOAD FILE
        WebElement chooseFileButton=driver.findElement(By.cssSelector("#file-upload"));
        chooseFileButton.sendKeys("/Users/techtorial/Desktop/usa.png");
        WebElement uploadFile=driver.findElement(By.cssSelector("#file-submit"));
        uploadFile.click();

        //This is the proof that it actually uploaded file
        WebElement message=driver.findElement(By.cssSelector("#uploaded-files"));
        System.out.println(BrowserUtils.getText(message));
    }

    @Test
    public void practice() throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/upload/");

        //FINDING THE LOCATION OF CHOOSEFILE AND HANDLE UPLOAD
        WebElement chooseFile=driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFile.sendKeys("/Users/techtorial/Desktop/usa.png");
        WebElement box=driver.findElement(By.cssSelector("#terms"));
        box.click();
        WebElement submitButton=driver.findElement(By.tagName("button"));
        submitButton.click();
        Thread.sleep(2000);

        //VALIDATE
        WebElement text=driver.findElement(By.xpath("//h3"));
        String actualText=BrowserUtils.getText(text);
        String expectedText="1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualText,expectedText);
    }














}
