package com.DemoTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCart {
	
	 WebDriver driver;

	    public AddToCart(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Locators
	    By cartLink = By.id("cartur");
	    By productInCart = By.xpath("//td[2]"); // product name in cart table
	    By placeOrderButton = By.xpath("//button[text()='Place Order']");

	    // Actions
	    public void clickCart() {
	        driver.findElement(cartLink).click();
	    }

	    public String getProductNameFromCart() {
	        return driver.findElement(productInCart).getText();
	    }

	    public void clickPlaceOrder() {
	        driver.findElement(placeOrderButton).click();
	    }

	    // Reusable method
	    public void verifyProductInCart() {
	        clickCart();
	        String product = getProductNameFromCart();
	        System.out.println("Product in cart: " + product);
	    }
	}


