package com.selenium.practice;
import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        WebDriver driver = new ChromeDriver();
        loginpageElemet(driver);
        //Exceptionpageelement(driver);
        driver.quit();

    }

    private static void  loginpageElemet(WebDriver driver){
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement UsernameField = driver.findElement(By.id("username"));
        UsernameField.sendKeys("Prasad");
        //WebElement username = driver.findElement(By.xpath("//input[@id='username']")); // using the xpath
        //WebElement name = driver.findElement(By.cssSelector("input[id='username']")); // using CSS Selector.
        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("Test");
        //WebElement passwordcss = driver.findElement(By.cssSelector("input[id='password']"));
        WebElement SubmitBtn = driver.findElement(By.className("btn"));
        SubmitBtn.isDisplayed();
        SubmitBtn.click();
        //WebElement button = driver.findElement(By.xpath("//button[@class='btn']"));

//        List<WebElement> inputFields = driver.findElements(By.tagName("input")); // it wll list all the input type webelements
//
//
//        WebElement LinkTextLocator = driver.findElement(By.linkText("Practice Test Automation."));
//        WebElement PartialLinkText = driver.findElement(By.partialLinkText("Practice Test"));
//
//        WebElement passwordbelowusername = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("username")));
//        WebElement PrivacyPolicyLink = driver.findElement(RelativeLocator.with(By.tagName("a")).straightRightOf(By.linkText("Practice Test Automation.")));
//        //WebElement Homebutton = driver.findElement(By.xpath("menu-item-43"));
//        return(null);

    }

    private static void Exceptionpageelement(WebDriver driver){
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        // find webelement for link Selenium webdriver with java for beginners program uisng link text and partial link text
        WebElement fulllink = driver.findElement(By.linkText("Selenium WebDriver with Java for beginners program"));
        WebElement partiallink = driver.findElement(By.partialLinkText("Selenium WebDriver with Java"));
        // find webelement for input fields using tag class name, xpath and CSS.

        // create a list of webelement for all buttons using tag.
        List<WebElement>buttonfields = driver.findElements(By.tagName("button"));
        // Identify both buttons using ID, name , CSS and Xpath for each
        WebElement editbuttonid = driver.findElement(By.id("edit_btn"));
        WebElement editbuttonname = driver.findElement(By.name("Edit"));
        WebElement editbuttonXpath = driver.findElement(By.xpath("//button[@id='edit_btn']"));
        WebElement editbuttonCSS = driver.findElement(By.cssSelector("button[id='edit_btn']"));

        WebElement Addbuttonid = driver.findElement(By.id("add_btn"));
        WebElement Addbyuttonname = driver.findElement(By.name("Add"));
        WebElement Addbuttonxpath = driver.findElement(By.xpath("//button[@id='add_btn']"));
        WebElement AddbuttonCSS = driver.findElement(By.cssSelector("button[id='add_btn']"));
    }
    private static String ChromeTest(String url){
        WebDriver driver = new ChromeDriver(); // Creating variale of Webdriver interface and instance of Chromedriver class
        driver.get(url);
        String title = driver.getTitle();
        //driver.quit();
        return title;
    }

}
