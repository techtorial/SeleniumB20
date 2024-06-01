package WaitTimes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitlyWait {

    /*
    It is a way to handle wait time issues.
    We implement once under DriverHelper.
     */

    @Test
    public void ImplicitlyWait(){
        ChromeDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //It means it will wait max 10 sec for element to be loaded on HTML.
    }











}
