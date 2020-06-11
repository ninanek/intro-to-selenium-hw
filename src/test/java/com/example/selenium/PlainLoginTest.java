package com.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PlainLoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void login() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().setSize(new Dimension(840, 1027));
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector(".fa")).click();
        assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Secure Area", "Login failed");
        driver.findElement(By.cssSelector(".icon-2x")).click();
        driver.close();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
