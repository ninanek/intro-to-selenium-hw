package com.example.selenium.steps;

import com.example.selenium.pages.LoginPage;
import com.example.selenium.pages.MainPage;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertEquals;

public class UserSteps {
    private WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;


    public UserSteps(WebDriver driver) {
        this.driver = driver;
    }

    public UserSteps login(String username, String password) {
        mainPage = new MainPage(driver);

        loginPage = new LoginPage(driver);
        loginPage.setUsername("tomsmith")
                .setPassword("SuperSecretPassword!")
                .clickLogin();

        assertEquals(mainPage.getTitle(), "Secure Area", "Login failed");
        return this;
    }

    public void logout() {
        mainPage.clickLogout();
    }
}