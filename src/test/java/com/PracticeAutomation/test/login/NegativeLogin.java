package com.PracticeAutomation.test.login;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class NegativeLogin {
    @Test
    public void IncorrectUsername(){
        WebDriver driver = new ChromeDriver();
// Open page
        driver.get("https://practicetestautomation.com/practice-test-login/");
//Type username incorrectUser into Username field
        WebElement usernameinput = driver.findElement(By.id("username"));
        usernameinput.sendKeys("incorrectuser");
//Type password Password123 into Password field
        WebElement passwordinput = driver.findElement(By.id("password"));
        passwordinput.sendKeys("Password123");

//Push Submit button
        WebElement submitbtn = driver.findElement(By.id("submit"));
        submitbtn.click();

//Verify error message is displayed
        String pageSource = driver.getPageSource();
        String Message = "Your username is invalid!";
        Assert.assertTrue(pageSource.contains(Message)); // using an Assert boolean method to match the Error message from the page source.
//Verify error message text is Your username is invalid!
        driver.quit();

    }

    @Test
    public void IncorrectPassword(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameinput = driver.findElement(By.id("username"));
        usernameinput.sendKeys("student");

        WebElement passwordinput = driver.findElement(By.id("password"));
        passwordinput.sendKeys("incorrectpassword");

        WebElement submitbtn = driver.findElement(By.id("submit"));
        submitbtn.click();

        String ErrorMessage = "Your password is invalid!";
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains(ErrorMessage));

        driver.quit();
    }
}
