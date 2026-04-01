package com.DemoTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Signup {
	 WebDriver driver;

	    // Constructor
	    public Signup(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Locators
	    By signupLink = By.id("signin2");           // Sign up link in header
	    By usernameField = By.id("sign-username");  // Username input
	    By passwordField = By.id("sign-password");  // Password input
	    By signupButton = By.xpath("//button[text()='Sign up']");  // Signup button in popup

	    // Actions
	    public void clickSignupLink() {
	        driver.findElement(signupLink).click();
	    }

	    public void enterUsername(String username) {
	        driver.findElement(usernameField).sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickSignupButton() {
	        driver.findElement(signupButton).click();
	    }

	    // Reusable method for signup
	    public void signup() {
	        clickSignupLink();

	        // Small wait for popup to appear
	        try { Thread.sleep(1000); } catch (InterruptedException e) {}

	        enterUsername("babudarius");
	        enterPassword("dari123");
	        clickSignupButton();
	    }
	}