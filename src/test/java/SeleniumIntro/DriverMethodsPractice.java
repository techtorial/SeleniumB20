package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverMethodsPractice {

    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
        System.out.println(driver.getTitle());
        driver.navigate().to("https://www.wikipedia.org/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
        driver.navigate().refresh();
        driver.get("https://www.pinterest.com/");
        System.out.println(driver.getTitle());
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().forward();
        driver.quit();

    }
}
