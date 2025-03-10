package com.PracticeAutomation.test.login;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class NegativeLogin {
    @Test
    public void IncorrectUsername() throws InterruptedException{
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
        Thread.sleep(2000);
//Verify error message is displayed

        WebElement Error = driver.findElement(By.id("error"));
        Assert.assertTrue(Error.isDisplayed()); // We are using the assert condition to see if the error element is displayed or not
        //Verify error message text is Your username is invalid!
//        String pageSource = driver.getPageSource();
//        String Message = "Your username is invalid!";
//        Assert.assertTrue(pageSource.contains(Message)); // using an Assert boolean method to match the Error message from the page source.

        String ExpectedErrorMessage ="Your username is invalid!";
        String ActualErrormessage = Error.getText(); // we are creating an varibale of Actual message and storing the value that is being passed in the Error element
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

//        String pageSource = driver.getPageSource();
//        Assert.assertTrue(pageSource.contains(ErrorMessage));

        Assert.assertEquals(ActualErrorMessage, ExpectedErrorMessage);
        driver.quit();
    }
}
