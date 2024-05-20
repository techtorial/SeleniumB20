package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class GetAttributeLoopsPractice {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");
        WebElement warning=driver.findElement(By.xpath("//button"));
        warning.click();
        List<WebElement> allBoxes=driver.findElements(By.xpath("//div[@role='checkbox']"));

        for(WebElement box:allBoxes){
            if(box.getAttribute("aria-checked").equals("false")){
                Thread.sleep(1000);
                box.click();
                Thread.sleep(1000);
                box.sendKeys(Keys.ARROW_DOWN);
                box.sendKeys(Keys.ARROW_DOWN);
                box.sendKeys(Keys.ARROW_DOWN);
            }
        }
    }
}
