package com.DemoTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout_OrderPlacement {
	WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public Checkout_OrderPlacement(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ✅ Locators (more reliable)
    By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");
    By name = By.id("name");
    By country = By.id("country");
    By city = By.id("city");
    By card = By.id("card");
    By month = By.id("month");
    By year = By.id("year");
    By purchaseButton = By.xpath("//button[contains(text(),'Purchase')]");
    By confirmationMessage = By.xpath("//h2[contains(text(),'Thank you')]");
    By okButton = By.xpath("//button[contains(text(),'OK')]");

    // ✅ Click Place Order (ONLY normal Selenium)
    public void clickPlaceOrder() {

        WebElement placeOrder = wait.until(
                ExpectedConditions.elementToBeClickable(placeOrderButton)
        );

        placeOrder.click();

        System.out.println("Place Order button clicked successfully");
    }

    // ✅ Form methods with waits
    public void enterName(String uname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys(uname);
    }

    public void enterCountry(String ucountry) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(country)).sendKeys(ucountry);
    }

    public void enterCity(String ucity) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(city)).sendKeys(ucity);
    }

    public void enterCard(String ucard) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(card)).sendKeys(ucard);
    }

    public void enterMonth(String umonth) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(month)).sendKeys(umonth);
    }

    public void enterYear(String uyear) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(year)).sendKeys(uyear);
    }

    // ✅ Click Purchase
    public void clickPurchase() {
        WebElement purchase = wait.until(
                ExpectedConditions.elementToBeClickable(purchaseButton)
        );
        purchase.click();
    }

    // ✅ Get confirmation
    public String getConfirmationMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(confirmationMessage)
        ).getText();
    }

    // ✅ Click OK
    public void clickOk() {
        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
    }

    // ✅ Full reusable flow
    public void placeOrder(String uname, String ucountry, String ucity,
                           String ucard, String umonth, String uyear) {

        clickPlaceOrder();  // 🔥 MUST CALL THIS FIRST

        enterName(uname);
        enterCountry(ucountry);
        enterCity(ucity);
        enterCard(ucard);
        enterMonth(umonth);
        enterYear(uyear);

        clickPurchase();
    }
}