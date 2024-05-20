package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealLifeTestCase {

    public static void main(String[] args) {
        //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//3. Get Title of page and validate it.(if conditions) expected title from website
//3. Get URL of current page and validate it.          expected url from website
//            4. Close browser.
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.godaddy.com/");
        String actualTitle=driver.getTitle();//website
        String expectedTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        System.out.println(actualTitle.equals(expectedTitle) ? "TITLE PASSED" : "TITLE FAILED");
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.godaddy.com/";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("URL PASSED");
        }else{
            System.out.println("URL FAILED");
        }
        driver.close();
    }
}
