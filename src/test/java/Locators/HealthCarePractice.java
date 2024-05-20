package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HealthCarePractice {

    public static void main(String[] args) throws InterruptedException {
        /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or .equals XPATH METHOD
10-Validate the header is "Appointment Confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
     */
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement makeAppointmentButton=driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointmentButton.click();
        WebElement username=driver.findElement(By.xpath("//input[@id='txt-username']"));
        username.sendKeys("John Doe");
        WebElement password=driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        WebElement loginButton=driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        loginButton.click();
        WebElement facility=driver.findElement(By.xpath("//select[@name='facility']"));//button[@class='btn btn-default']
        facility.sendKeys("Hongkong CURA Healthcare Center");
        WebElement readmission=driver.findElement(By.xpath("//input[@name='hospital_readmission']"));
        if(readmission.isDisplayed() && readmission.isEnabled() && !readmission.isSelected()){
            readmission.click();
        }
        WebElement healthCareProgram=driver.findElement(By.xpath("//input[@value='Medicaid']"));
        healthCareProgram.click();
        WebElement date=driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("09/05/2024");
        WebElement comment=driver.findElement(By.xpath("//textarea"));
        comment.sendKeys("I love Selenium");
        WebElement appointmentButton=driver.findElement(By.xpath("//button[@type='submit']"));
        Thread.sleep(3000);
        appointmentButton.click();
        WebElement header=driver.findElement(By.xpath("//h2[contains(text(),'Confirmation')]"));
        String actualHeader=header.getText().trim();
        String expectedHeader="Appointment Confirmation";
        System.out.println(actualHeader.equals(expectedHeader) ? "HEADER PASSED" : "HEADER FAILED");
        WebElement program=driver.findElement(By.xpath("//p[.='Medicaid']"));
        System.out.println(program.getText());
        WebElement homePageButton=driver.findElement(By.xpath("//a[.='Go to Homepage']"));
        homePageButton.click();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
        driver.quit();
    }
}
