package com.practice.Automation.login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Positivelogintest {
   @Test
    public void testLogin() throws InterruptedException{
        //Open page
        WebDriver driver = new ChromeDriver(); // creating instance of the class Chromedriver class.
        driver.get("https://practicetestautomation.com/practice-test-login/");

        //Type username student into Username field
        WebElement usernameinput = driver.findElement(By.id("username"));
        usernameinput.sendKeys("student");

        //Type password Password123 into Password field
        WebElement passwordinput = driver.findElement(By.id("password"));
        passwordinput.sendKeys("Password123");

        //Push Submit button
        WebElement submitbtn = driver.findElement(By.id("submit"));
        submitbtn.click();

        Thread.sleep(2000);

        //Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        String ExpectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String Actualurl = driver.getCurrentUrl();
        Assert.assertEquals(Actualurl,ExpectedUrl); // using the Assert method to check of the expeted url is same as Actual.

        //Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        String pageSource = driver.getPageSource();
        String Message = "Congratulations student. You successfully logged in!";
        Assert.assertTrue(pageSource.contains(Message)); // we are uisng the assert boolean condition to see if the page source contains the message

        //Verify mvnbutton Log out is displayed on the new page
        WebElement logoutbtn = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutbtn.isDisplayed()); // Using the Assert boolean condition to see if logout button is displayed or not.
        driver.quit();
    }

}
