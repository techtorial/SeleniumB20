package AlertInterface;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class practiceAlert {

    @Test
    public void practiceHTMLAndJS() throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://sweetalert.js.org/");

        //FINDING THE PREVIEWJS AND HANDLE WITH JS ALERT
        WebElement previewJS=driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        previewJS.click();
        Alert alert=driver.switchTo().alert(); //Because pop-up happen here
        System.out.println(alert.getText());
        alert.accept();

        //FINDING PREVIEW HTML AND HANDLE WITH HTML ALERT
        WebElement previewHTML=driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        previewHTML.click();
        Thread.sleep(3000);
        WebElement text=driver.findElement(By.xpath("//div[@role='dialog']"));
        System.out.println(BrowserUtils.getText(text));
        WebElement okButton=driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();
    }
}
