package com.DemoTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	  WebDriver driver;

	    // Constructor
	    public Login(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Locators
	    By loginLink = By.id("login2");            // Login button in header
	    By usernameField = By.id("loginusername"); // Username input in popup
	    By passwordField = By.id("loginpassword"); // Password input in popup
	    By loginButton = By.xpath("//button[text()='Log in']"); // Log in button in popup
	    public By logoutLink = By.id("logout2");   // Logout button after login

	    // Open login popup
	    public void openLoginPopup() {
	        driver.findElement(loginLink).click();
	    }

	    // Enter username
	    public void enterUsername(String username) {
	        driver.findElement(usernameField).sendKeys(username);
	    }

	    // Enter password
	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    // Click login
	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }

	    // Reusable login method
	    public void login(String username, String password) throws InterruptedException {
	        openLoginPopup();
	        Thread.sleep(1000); // wait for popup
	        enterUsername(username);
	        enterPassword(password);
	        clickLogin();
	    }

	    // Logout method
	    public void clickLogout() {
	        driver.findElement(logoutLink).click();
	    }
	}