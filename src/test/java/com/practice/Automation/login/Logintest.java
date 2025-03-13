package com.practice.Automation.login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Logintest {

    private WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void SetUp(@Optional ("chrome") String browser){
        System.out.println("Your running on "+browser);
        switch (browser.toLowerCase()){
            case "chrome":
                driver= new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "default":
                driver= new ChromeDriver();
                break;
        }
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @AfterMethod(alwaysRun = true)
    public void Close(){
        driver.quit();
    }
   @Test(groups = {"Positive","Regression","Smoke"})
    public void testLogin() throws InterruptedException{


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
    @Parameters({"username","password","ExpectedErrorMessage"})
    @Test(groups = {"Negative","Regression"})
    public void NegativeLoginTest(String username ,String password , String ExpectedErrorMessage) throws InterruptedException{


        WebElement usernameinput = driver.findElement(By.id("username"));
        usernameinput.sendKeys(username);

        WebElement passwordinput = driver.findElement(By.id("password"));
        passwordinput.sendKeys(password);


        WebElement submitbtn = driver.findElement(By.id("submit"));
        submitbtn.click();
        Thread.sleep(2000);


        WebElement Error = driver.findElement(By.id("error"));
        Assert.assertTrue(Error.isDisplayed());
        //String ExpectedErrorMessage ="Your username is invalid!";
        String ActualErrormessage = Error.getText();
        Assert.assertEquals(ActualErrormessage ,ExpectedErrorMessage);
        driver.quit();


    }


}
