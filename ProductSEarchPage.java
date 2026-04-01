package com.DemoTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductSEarchPage {
	 WebDriver driver;

	    public ProductSEarchPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Locators
	    By phonesCategory = By.xpath("//a[text()='Phones']");
	    By laptopsCategory = By.xpath("//a[text()='Laptops']");
	    By monitorsCategory = By.xpath("//a[text()='Monitors']");

	    // Dynamic product locator
	    public By selectProduct(String productName) {
	        return By.xpath("//a[text()='" + productName + "']");
	    }

	    // Actions
	    public void clickPhones() {
	        driver.findElement(phonesCategory).click();
	    }

	    public void clickLaptops() {
	        driver.findElement(laptopsCategory).click();
	    }

	    public void clickMonitors() {
	        driver.findElement(monitorsCategory).click();
	    }

	    public void clickProduct(String productName) {
	        driver.findElement(selectProduct(productName)).click();
	    }

	    // Reusable method (acts like search)
	    public void searchProduct(String category, String productName) {

	        if (category.equalsIgnoreCase("phones")) {
	            clickPhones();
	        } else if (category.equalsIgnoreCase("laptops")) {
	            clickLaptops();
	        } else if (category.equalsIgnoreCase("monitors")) {
	            clickMonitors();
	        }

	        clickProduct(productName);
	    }
	}
	


