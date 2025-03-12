package com.practice.Automation.login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Logintest {
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
        String ExpectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String Actualurl = driver.getCurrentUrl();
        Assert.assertEquals(Actualurl,ExpectedUrl);

        String pageSource = driver.getPageSource();
        String Message = "Congratulations student. You successfully logged in!";
        Assert.assertTrue(pageSource.contains(Message));


        WebElement logoutbtn = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutbtn.isDisplayed());
        driver.quit();
    }
    @Test
    public void IncorrectUsername() throws InterruptedException{
        WebDriver driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameinput = driver.findElement(By.id("username"));
        usernameinput.sendKeys("incorrect");

        WebElement passwordinput = driver.findElement(By.id("password"));
        passwordinput.sendKeys("Password123");


        WebElement submitbtn = driver.findElement(By.id("submit"));
        submitbtn.click();
        Thread.sleep(2000);


        WebElement Error = driver.findElement(By.id("error"));
        Assert.assertTrue(Error.isDisplayed());
        String ExpectedErrorMessage ="Your username is invalid!";
        String ActualErrormessage = Error.getText();
        Assert.assertEquals(ActualErrormessage ,ExpectedErrorMessage);
        driver.quit();
        driver.quit();

    }
    @Test
    public void IncorrectPassword() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameinput = driver.findElement(By.id("username"));
        usernameinput.sendKeys("student");

        WebElement passwordinput = driver.findElement(By.id("password"));
        passwordinput.sendKeys("incorrectpassword");

        WebElement submitbtn = driver.findElement(By.id("submit"));
        submitbtn.click();
        Thread.sleep(2000);

        WebElement Error = driver.findElement(By.id("error"));
        Assert.assertTrue(Error.isDisplayed());

        String ExpectedErrorMessage = "Your password is invalid!";
        String ActualErrorMessage = Error.getText();

        Assert.assertEquals(ActualErrorMessage, ExpectedErrorMessage);
        driver.quit();
    }

}
