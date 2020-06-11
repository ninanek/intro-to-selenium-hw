package com.example.selenium;

import com.example.selenium.steps.UserSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    protected WebDriver driver;
    protected UserSteps userSteps;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts();
        driver.get("https://the-internet.herokuapp.com/login");
        userSteps = new UserSteps(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
