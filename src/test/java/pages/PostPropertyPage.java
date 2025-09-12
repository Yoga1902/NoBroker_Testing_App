package pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;
import objectrepository.Locators;
import utils.Base;

public class PostPropertyPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;

	public PostPropertyPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest = extTest;
	}

	public void clicksPostProperty() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.findElement(Locators.clickpostpropertybutton).click();
			extTest.log(Status.PASS, "Property button clicked successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to click search button: " + e.getMessage());
		}
		
	}

	public boolean redirectedPostPropertyPage() {
		 try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='nb__102yC']")));
	            extTest.log(Status.PASS, "Redirected sucessfully");
	            return true;
	        } catch (TimeoutException te) {
	        	extTest.log(Status.FAIL, "Fail to redirect" + te.getMessage());
	            return false;
	        }
	}

	
	public void clicksPostNow() {
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
	
	public boolean redirectedDetailsPage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='citySelectContainer']")));
			extTest.log(Status.PASS, "Redirected sucessfully");
			return true;
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Fail to redirect" + e.getMessage());
			return false;
		}
	}
	

	public void enterCity(String cityName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    // 1. Click the dropdown container to activate input
		    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
		        By.id("citySelectContainer")
		    ));
		    dropdown.click();

		    // 2. Find the input inside react-select (even if readonly, sendKeys works once focused)
		    WebElement inputBox = wait.until(ExpectedConditions.presenceOfElementLocated(
		        By.xpath("//input[contains(@id,'react-select')]")
		    ));
		    inputBox.sendKeys(cityName);

		    // 3. Wait for suggestion option & click it
		    WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//div[contains(@class,'nb-select__option') and text()='" + cityName + "']")
		    ));
		    suggestion.click();
			    extTest.log(Status.PASS, "City selected: " + cityName);
			}
			catch (Exception e) {
				extTest.log(Status.FAIL, "Failed to select city: " + e.getMessage());
			}
		}
		
		  

	public void selectPropertytype() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.findElement(By.xpath("//div[text()='Residential']")).click();
			extTest.log(Status.PASS, "Property button clicked successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to click search button: " + e.getMessage());
		}
		
	}

	public void selectpropertyAdType() {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.findElement(By.xpath("//div[text()='PG/Hostel']")).click();
			extTest.log(Status.PASS, "Property button clicked successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to click search button: " + e.getMessage());
		}
	}

	public void clicksStartPostingNow() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.findElement(By.xpath("//button[text()='Start Posting Your Ad For FREE']")).click();
			extTest.log(Status.PASS, "Property button clicked successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to click search button: " + e.getMessage());
		}
		
	}

	public boolean redirectedRoomDetailsPage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Room Details']")));
			extTest.log(Status.PASS, "Redirected sucessfully");
			return true;
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Fail to redirect" + e.getMessage());
			return false;
		}
	}

	public void clicksalertConfirmation() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    try {
	        WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//button[normalize-space(text())='Yes']")
	        ));
	        yesButton.click();
	        extTest.log(Status.PASS, "Property button clicked successfully");
	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Failed to click Yes button: " + e.getMessage());
	    }
	}

	public boolean redirectedLocalityDetailsPage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Locality Details']")));
			extTest.log(Status.PASS, "Redirected sucessfully");
			return true;
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Fail to redirect" + e.getMessage());
			return false;
		}
		
	}

	public void selectRoomtype() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.findElement(By.id("Double")).click();
			extTest.log(Status.PASS, "Property button clicked successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to click search button: " + e.getMessage());
		}
		
	}

	public void clickSaveContinue() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.findElement(By.id("saveAndContinue")).click();
			extTest.log(Status.PASS, "Property button clicked successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to click search button: " + e.getMessage());
		}
		
	}


}
