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
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement UsernameField = driver.findElement(By.id("username"));
        WebElement username = driver.findElement(By.xpath("//input[@id='username']")); // using the xpath
        WebElement name = driver.findElement(By.cssSelector("input[id='username']")); // using CSS Selector.
        WebElement PasswordField = driver.findElement(By.id("password"));
        WebElement passwordcss = driver.findElement(By.cssSelector("input[id='password']"));
        WebElement SubmitBtn = driver.findElement(By.className("btn"));
        WebElement button = driver.findElement(By.xpath("//button[@class='btn']"));

        List<WebElement> inputFields = driver.findElements(By.tagName("input")); // it wll list all the input type webelements


        WebElement LinkTextLocator = driver.findElement(By.linkText("Practice Test Automation."));
        WebElement PartialLinkText = driver.findElement(By.partialLinkText("Practice Test"));

        WebElement passwordbelowusername = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("username")));
        WebElement PrivacyPolicyLink = driver.findElement(RelativeLocator.with(By.tagName("a")).straightRightOf(By.linkText("Practice Test Automation.")));
        WebElement Homebutton = driver.findElement(By.xpath("menu-item-43"));

        driver.quit();
    }
    private static String ChromeTest(String url){
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        String title = driver.getTitle();
        //driver.quit();
        return title;
    }

}
