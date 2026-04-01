package com.DemoTesting;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoBlazeScreenshot {
	
	 public static void main(String[] args) throws Exception {
		 WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Launch Application
	        driver.get("https://www.demoblaze.com/");
	        Thread.sleep(4000);
	        takeScreenshot(driver, "1_Launch_Application.png");

	        // ---------------- LOGIN ----------------
	        driver.findElement(By.id("login2")).click();
	        Thread.sleep(3000);

	        WebElement username = driver.findElement(By.id("loginusername"));
	        WebElement password = driver.findElement(By.id("loginpassword"));
	        WebElement login = driver.findElement(By.xpath("//button[text()='Log in']"));

	        username.sendKeys("babudarius");
	        password.sendKeys("dari123");
	        login.click();

	        Thread.sleep(7000); // IMPORTANT: wait for homepage reload after login
	        takeScreenshot(driver, "2_Login.png");

	        // ---------------- SELECT PRODUCT ----------------
	        try {
	            driver.findElement(By.linkText("Samsung galaxy s6")).click();
	        } catch (Exception e) {
	            Thread.sleep(4000); // retry
	            driver.findElement(By.linkText("Samsung galaxy s6")).click();
	        }

	        Thread.sleep(5000);
	        takeScreenshot(driver, "3_Product_Page.png");

	        // ---------------- ADD TO CART ----------------
	        try {
	            Thread.sleep(3000);
	            driver.findElement(By.linkText("Add to cart")).click();
	        } catch (Exception e) {
	            Thread.sleep(4000); // retry
	            driver.findElement(By.linkText("Add to cart")).click();
	        }

	        Thread.sleep(4000);

	        // Handle Alert
	        try {
	            Alert alert = driver.switchTo().alert();
	            alert.accept();
	        } catch (Exception e) {
	            System.out.println("Alert not appeared immediately, retrying...");
	            Thread.sleep(3000);
	            driver.switchTo().alert().accept();
	        }
	        Thread.sleep(4000);

	        takeScreenshot(driver, "4_Product_Added.png");

	        // ---------------- LOGOUT ----------------
	        Thread.sleep(3000);
	        driver.findElement(By.id("logout2")).click();

	        Thread.sleep(4000);
	        takeScreenshot(driver, "5_Logout.png");

	        driver.quit();
	    }

	    public static void takeScreenshot(WebDriver driver, String filename) {
	        try {
	            Files.createDirectories(Paths.get("screenshots"));
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File source = ts.getScreenshotAs(OutputType.FILE);
	            Files.copy(source.toPath(),
	                    Paths.get("screenshots/" + filename));
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	}