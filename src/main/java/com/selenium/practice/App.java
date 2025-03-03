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
        WebElement PasswordField = driver.findElement(By.id("password"));
        WebElement SubmitBtn = driver.findElement(By.className("btn"));

        List<WebElement> inputFields = driver.findElements(By.tagName("input"));

        WebElement LinkTextLocator = driver.findElement(By.linkText("Practice Test Automation."));
        WebElement PartialLinkText = driver.findElement(By.partialLinkText("Practice Test"));

        WebElement passwordbelowusername = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.id("username")));
        WebElement PrivacyPolicyLink = driver.findElement(RelativeLocator.with(By.tagName("a")).straightRightOf(By.linkText("Practice Test Automation.")));

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
