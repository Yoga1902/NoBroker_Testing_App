package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectrepository.Locators;
import utils.Base;

public class RentPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;

	public RentPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest = extTest;
	}
	
	public void clickRentButton() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			driver.findElement(By.xpath("//*[@class='cursor-pointer text-primary-color border-0 border-b-4 border-solid border-primary-color font-bold']")).click();

			extTest.log(Status.PASS, "Buy button clicked successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to click Buy button: " + e.getMessage());
		}
		
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

	public boolean redirectedRentPage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@itemprop='item']")));
			extTest.log(Status.PASS, "Redirected sucessfully");
			return true;
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Fail to redirect" + e.getMessage());
			return false;
		}
	}

	public boolean isHistorySectionVisible() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.historySection));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean isContinueLastSearchVisible() {
	    try {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//div[text()='Continue Last  Search']")
	        ));
	        extTest.log(Status.PASS, "Continue Last Search section is visible");
	        return true;
	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Continue Last Search section not visible: " + e.getMessage());
	        return false;
	    }
	}
}