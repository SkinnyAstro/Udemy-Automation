package com.practice.Automation.login;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class DrPortalLogin {
    @Test
    public void positiveLogin() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://dev-doctor.s3-website.ap-south-1.amazonaws.com/amazon/");

        WebElement usernameinput = driver.findElement(By.name("username"));
        usernameinput.sendKeys("prasad.sartape@truemeds.in");

        WebElement passwordinput = driver.findElement(By.name("password"));
        passwordinput.sendKeys("Truemeds@2023");

        WebElement loginbtn = driver.findElement(By.id("login"));
        loginbtn.click();
        Thread.sleep(2000);

        String Expectedurl = "http://dev-doctor.s3-website.ap-south-1.amazonaws.com/amazon/dashboard";
        String Actualurl = driver.getCurrentUrl();
        Assert.assertEquals(Actualurl,Expectedurl);

        driver.quit();

    }

    @Parameters({"username","password","ExpectedErrorMessage"})
    @Test
    public void NegativeLogin(String username , String password , String ExpectedErrorMessage) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://dev-doctor.s3-website.ap-south-1.amazonaws.com/amazon/");

        WebElement usernameinput = driver.findElement(By.name("username"));
        usernameinput.sendKeys(username);

        WebElement passwordinput = driver.findElement(By.name("password"));
        passwordinput.sendKeys(password);

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement loginbtn = driver.findElement(By.id("login"));
        loginbtn.click();
      //  Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement error = driver.findElement(By.xpath("//span[contains(text(), 'Exception occurred while Authenticating doctor')]"));

        wait.until(ExpectedConditions.invisibilityOfElementLocated((By) error));
        String ActualErrorMessage = error.getText();

        Assert.assertEquals(ActualErrorMessage,ExpectedErrorMessage);
        driver.quit();
    }
}
