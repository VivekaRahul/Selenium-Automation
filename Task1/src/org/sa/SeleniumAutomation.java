package org.sa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class SeleniumAutomation {
    public static void main(String[] args) throws InterruptedException {
        
        //chrome drive path
        System.setProperty("webdriver.chrome.driver", 
                "C:/Users/Lenovo/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        
        //webdriver
        WebDriver driver = new ChromeDriver();
        
        //maxmize the window
        driver.manage().window().maximize();
        
        //facebook url
        driver.get("https://www.facebook.com/");
        
        //webelement(email, password, loin)
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("pass"));
        WebElement loginBtn = driver.findElement(By.name("login"));
        
        //send keys to email and password
        email.sendKeys("testuser@gmail.com");   
        password.sendKeys("1235");    
        loginBtn.click();
        
        
        Thread.sleep(5000);  
        if (driver.getPageSource().contains("The email or mobile number you entered isn’t connected to an account")) {
            System.out.println("Invalid Login Test Passed ✅");
        } else {
            System.out.println("Invalid Login Test Failed ❌");
        }
        
        driver.get("https://www.facebook.com/");
        loginBtn = driver.findElement(By.name("login"));
        loginBtn.click(); 
        
        Thread.sleep(5000);
        if (driver.getPageSource().contains("The email or mobile number you entered isn’t connected")) {
            System.out.println("Form Validation Test Passed ✅");
        } else {
            System.out.println("Form Validation Test Failed ❌");
        }
        
        driver.close(); 
    }
}


