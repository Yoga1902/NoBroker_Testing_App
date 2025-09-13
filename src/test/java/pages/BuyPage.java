package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectrepository.Locators;
import utils.Base;

public class BuyPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;


	public BuyPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest = extTest;
	}
	
	public void selectCity(String cityName) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // 1. Click the dropdown to activate it
	    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("#searchCity .nb-select__control")
	    ));
	    dropdown.click();

	    // 2. Wait for the menu to appear
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.cssSelector(".nb-select__menu")
	    ));

	    // 3. Click the desired option
	    WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//div[contains(@class,'nb-select__menu')]//div[text()='" + cityName + "']")
	    ));
	    option.click();
	    
	    System.out.println("Selected city: " + cityName);
	}



	public void enterLocality(String locality) {
		try {
			WebElement localityInput = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("listPageSearchLocality")));
			localityInput.click();
			localityInput.sendKeys(locality);
			Base.sleep(1000);
			localityInput.sendKeys(Keys.ARROW_DOWN);
			Base.sleep(1000);
			localityInput.sendKeys(Keys.ENTER);

			extTest.log(Status.PASS, "Locality selected: " + locality);
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to select locality: " + e.getMessage());
		}
	}
	
	public void clickSearchButton() {
		try {
			driver.findElement(Locators.searchButton).click();

			extTest.log(Status.PASS, "Search button clicked successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to click search button: " + e.getMessage());
		}
	}
	public boolean isLocalityErrorDisplayed() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alertMessageBox")));
			extTest.log(Status.PASS, "Alert message displayed");
			return true;
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Error message not displayed: " + e.getMessage());
			return false;
		}
	}
	public void clickBuyButton() {
		try {
			driver.findElement(Locators.BuyButton).click();

			extTest.log(Status.PASS, "Buy button clicked successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to click Buy button: " + e.getMessage());
		}
	}
	
	public boolean redirectedBuyPage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='selectedLocalities']")));
			extTest.log(Status.PASS, "Redirected sucessfully");
			return true;
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Fail to redirect" + e.getMessage());
			return false;
		}
	}
	public void clickApartmentButton() {
	    try {
	        WebElement aptBtn = wait.until(
	            ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Apartment']"))
	        );
	        aptBtn.click();
	        extTest.log(Status.PASS, "Property Type selected successfully");
	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Failed to select property type: " + e.getMessage());
	    }
	}

	public void clickPropertyType() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			driver.findElement(Locators.PropertyStatus).click();

			extTest.log(Status.PASS, "Property Status selected successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to select Property Status button: " + e.getMessage());
		}
	}
	public void clickApartmentType() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			driver.findElement(Locators.ApartmentType).click();

			extTest.log(Status.PASS, "Apartment Type selected successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to select Apartment Type button: " + e.getMessage());
		}
	}
	public void clickPriceRange() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			driver.findElement(Locators.PriceRangeButton).click();

			extTest.log(Status.PASS, "Price range clicked successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to click Price Range button: " + e.getMessage());
		}
	}
	public boolean isPropertyDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='listCardContainer']")));
			extTest.log(Status.PASS, "Property Displayed sucessfully");
			return true;
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Fail to Display" + e.getMessage());
			return false;
		}

	}

	public void clickgetOwnerDetails() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        By ownerBtnLocator = By.xpath("//button[contains(text(),'Get Owner Details')]");

	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ownerBtnLocator));

	        // Scroll into view before clicking
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	        element.click();

	        extTest.log(Status.PASS, "Clicked on Get Owner Details button successfully");
	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Failed to click on Get Owner Details: " + e.getMessage());
	        throw e; // rethrow so test fails
	    }
	}


	public boolean isdisplayConfimationPage() {
		
	    try {
	    	
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	        By contactPageLocator = By.xpath("//div[contains(text(),'Owner Contact')]");

	        // Scroll into view before waiting
	        WebElement element = driver.findElement(contactPageLocator);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	        wait.until(ExpectedConditions.visibilityOfElementLocated(contactPageLocator));

	        extTest.log(Status.PASS, "Contact details displayed successfully");
	        return true;
	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Failed to display : " + e.getMessage());
	        return false;
	    }
	}



}
