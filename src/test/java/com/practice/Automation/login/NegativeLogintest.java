package com.practice.Automation.login;

import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLogintest {
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
