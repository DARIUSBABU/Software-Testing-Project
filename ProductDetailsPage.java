package com.DemoTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
	
	  WebDriver driver;

	    public ProductDetailsPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Locators
	    By productName = By.xpath("//h2[@class='name']");
	    By productPrice = By.xpath("//h3[@class='price-container']");
	    By addToCartButton = By.xpath("//a[text()='Add to cart']");

	    // Actions
	    public String getProductName() {
	        return driver.findElement(productName).getText();
	    }

	    public String getProductPrice() {
	        return driver.findElement(productPrice).getText();
	    }

	    public void clickAddToCart() {
	        driver.findElement(addToCartButton).click();
	    }

	    // Reusable method
	    public void addProductToCart() {
	        clickAddToCart();
	    }
	}


