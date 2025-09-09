package pages;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import objectrepository.Locators;

public class PropertyPage {

    WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;

    public PropertyPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.extTest = extTest;
    }
    
    public void clickPostProperty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(Locators.propertyButton).click();
    }
    
    public void clickpostNow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // reduced from 15 to 5 sec
        WebElement postNowButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("postNow"))
        );

        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", postNowButton);
            Thread.sleep(1000); // wait 1 second before clicking
            postNowButton.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", postNowButton);
        }
    }

    public boolean propertypageLoadedSuccessfully() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.propertypage));
            return true;
        } catch (TimeoutException te) {
            return false;
        }
    }
    
    // Helper method to handle potential overlays
    private void handlePotentialOverlays() {
        try {
            // Check for and dismiss any notification bars, modals, or popups
            WebElement overlay = driver.findElement(By.className("modal"));
            if (overlay.isDisplayed()) {
                WebElement closeButton = overlay.findElement(By.className("close"));
                closeButton.click();
                Thread.sleep(500);
            }
        } catch (NoSuchElementException | InterruptedException e) {
            // No overlay found or interrupted, continue
        }
        
        try {
            // Check for notification banners
            WebElement notification = driver.findElement(By.cssSelector(".notification, .alert, .banner"));
            if (notification.isDisplayed()) {
                WebElement dismissButton = notification.findElement(By.cssSelector(".close, .dismiss, .x"));
                dismissButton.click();
                Thread.sleep(500);
            }
        } catch (NoSuchElementException | InterruptedException e) {
            // No notification found or interrupted, continue
        }
    }
    
    // Safe click method with retry mechanism
    private void clickElementSafely(By locator, int maxRetries) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        for (int i = 0; i < maxRetries; i++) {
            try {
                // Wait for element to be present
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                
                // Scroll element into view (center of viewport)
                js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
                Thread.sleep(1000); // Wait for scroll to complete
                
                // Wait for element to be clickable
                element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                
                // Try normal click first
                element.click();
                return; // Success, exit method
                
            } catch (ElementClickInterceptedException | TimeoutException e) {
                System.out.println("Attempt " + (i + 1) + " failed: " + e.getMessage());
                
                if (i == maxRetries - 1) {
                    // Last attempt - use JavaScript click
                    try {
                        WebElement element = driver.findElement(locator);
                        js.executeScript("arguments[0].click();", element);
                        System.out.println("Used JavaScript click as fallback");
                        return;
                    } catch (Exception jsException) {
                        throw new RuntimeException("All click attempts failed for locator: " + locator, jsException);
                    }
                } else {
                    // Wait before retry
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrupted while clicking element", e);
            }
        }
    }
    
    public void fillPropertyDetails(String city, String propertyType, String propertyCategory) {
        try {
            // Handle any potential overlays first
            handlePotentialOverlays();
            
            // Wait a moment for page to stabilize
            Thread.sleep(2000);
            
            // Click city dropdown with safe click method
            By cityDropdownLocator = By.xpath("//div[@class='css-151xaom-placeholder nb-select__placeholder']");
            System.out.println("Attempting to click city dropdown...");
            clickElementSafely(cityDropdownLocator, 3);
            
            // Wait for dropdown options to appear
            Thread.sleep(1000);
            
            // Click Bangalore option
            By bangaloreOptionLocator = By.xpath("//div[text()='Bangalore']");
            System.out.println("Attempting to click Bangalore option...");
            clickElementSafely(bangaloreOptionLocator, 3);
            
            // Wait before next interaction
            Thread.sleep(1000);
            
            // Click "Residential" option
            By residentialOptionLocator = By.xpath("//div[text()='Residential']");
            System.out.println("Attempting to click Residential option...");
            clickElementSafely(residentialOptionLocator, 3);
            
            // Wait before next interaction
            Thread.sleep(1000);
            
            // Click "PG/Hostel" option
            By pgHostelOptionLocator = By.xpath("//div[text()='PG/Hostel']");
            System.out.println("Attempting to click PG/Hostel option...");
            clickElementSafely(pgHostelOptionLocator, 3);
            
            System.out.println("Property details filled successfully");
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted while filling property details", e);
        } catch (Exception e) {
            System.err.println("Error filling property details: " + e.getMessage());
            throw new RuntimeException("Failed to fill property details", e);
        }
    }

    public void clickStartPosting() {
        try {
            By startPostingButtonLocator = By.xpath("//button[text()='Start Posting Your Ad For FREE']");
            clickElementSafely(startPostingButtonLocator, 3);
            System.out.println("Start Posting button clicked successfully");
        } catch (Exception e) {
            throw new RuntimeException("Start Posting button not found or not clickable!", e);
        }
    }

    public boolean isPropertyDetailsFormVisible() {
        try {
            // Wait until form is visible (adjust XPath/CSS based on actual HTML)
            WebElement propertyDetailsForm = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[text()='Yes']")));
            return propertyDetailsForm.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}