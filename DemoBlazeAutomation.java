package com.DemoTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoBlazeAutomation extends LaunchApplication {

	  WebDriverWait wait;

	    @Test(priority = 1)
	    public void openHomePageTest() {
	        driver.get("https://www.demoblaze.com/");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        String currentURL = driver.getCurrentUrl();
	        Assert.assertTrue(currentURL.contains("demoblaze"), "Home page not opened");

	        System.out.println("DemoBlaze Home Page Opened Successfully");
	    }

	    @Test(priority = 2)
	    public void loginUserTest() throws InterruptedException {
	        Login login = new Login(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Login with credentials
	        login.login("babudarius", "dari123");

	        // Wait for logout link to appear after login
	        wait.until(ExpectedConditions.visibilityOfElementLocated(login.logoutLink));

	        Assert.assertTrue(driver.findElement(login.logoutLink).isDisplayed(), "Login failed");
	        System.out.println("User logged in successfully");
	    }

	    @Test(priority = 3)
	    public void selectProductAndAddToCartTest() {
	        ProductSEarchPage search = new ProductSEarchPage(driver);
	        ProductDetailsPage details = new ProductDetailsPage(driver);
	        AddToCart cart = new AddToCart(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Search & open product
	        search.searchProduct("phones", "Samsung galaxy s6");

	        // Add to cart
	        details.addProductToCart();

	        // Wait for alert and accept
	        wait.until(ExpectedConditions.alertIsPresent());
	        driver.switchTo().alert().accept();

	        // Go to cart page
	        cart.clickCart();

	        // Wait until cart table is visible
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));

	        // Verify product is in cart
	        WebElement productRow = driver.findElement(By.xpath("//td[text()='Samsung galaxy s6']"));
	        Assert.assertTrue(productRow.isDisplayed(), "Product not found in cart");

	        System.out.println("Product selected and added to cart successfully");
	    }

	    @Test(priority = 4)
	    public void checkoutAndPlaceOrderTest() {
	        Checkout_OrderPlacement checkout = new Checkout_OrderPlacement(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Fill checkout form and place order
	        checkout.placeOrder("John", "India", "Kochi", "123456789", "03", "2026");

	        // Wait for modal confirmation
	        WebElement confirmationModal = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sweet-alert.showSweetAlert.visible"))
	        );

	        String confirmation = checkout.getConfirmationMessage();
	        Assert.assertTrue(confirmation.contains("Thank you"), "Order placement failed");

	        // Click OK
	        checkout.clickOk();
	        System.out.println("Checkout and order placement completed successfully");
	    }

	    @Test(priority = 5)
	    public void logoutTest() {
	        Login login = new Login(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Click logout
	        login.clickLogout();

	        // Wait until login link is visible
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));

	        Assert.assertTrue(driver.findElement(By.id("login2")).isDisplayed(), "Logout failed");
	        System.out.println("User logged out successfully");
	    }
	}