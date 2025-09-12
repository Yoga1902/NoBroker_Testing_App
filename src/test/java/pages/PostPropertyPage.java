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
	            extTest.log(Status.PASS, "post page Redirected sucessfully");
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
			extTest.log(Status.PASS, "Redirected to property Details Page sucessfully");
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
			extTest.log(Status.PASS, "Property Type Selected successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to select property Button: " + e.getMessage());
		}
		
	}

	public void selectpropertyAdType() {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.findElement(By.xpath("//div[text()='PG/Hostel']")).click();
			extTest.log(Status.PASS, "Property Ad Type Selected successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to select property Ad type: " + e.getMessage());
		}
	}

	public void clicksStartPostingNow() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.findElement(By.xpath("//button[text()='Start Posting Your Ad For FREE']")).click();
			extTest.log(Status.PASS, "Posting Now button clicked successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to click PostNow Button: " + e.getMessage());
		}
		
	}

	public boolean redirectedRoomDetailsPage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Room Details']")));
			extTest.log(Status.PASS, "Redirected to RoomDetails Page sucessfully");
			return true;
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Fail to redirect Room Details" + e.getMessage());
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
	        extTest.log(Status.PASS, "Accepted the Confirmation");
	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Failed to accept the confirmation: " + e.getMessage());
	    }
	}

	public boolean redirectedLocalityDetailsPage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Locality Details']")));
			extTest.log(Status.PASS, "Redirected to Locality Page sucessfully");
			return true;
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Fail to redirect locality page" + e.getMessage());
			return false;
		}
		
	}

	public void selectRoomtype() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.findElement(By.id("Double")).click();
			extTest.log(Status.PASS, "RoomType selected successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to select Room Type: " + e.getMessage());
		}
		
	}

	public void clickSaveContinue() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.findElement(By.id("saveAndContinue")).click();
			extTest.log(Status.PASS, "Details saved and clicked continue button");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to save the details: " + e.getMessage());
		}
		
	}

	public void enterexpectedrent(String rent) {
		try {
			WebElement rentInput = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("rent")));
			rentInput.click();
			rentInput.sendKeys(rent);
			Base.sleep(1000);
			extTest.log(Status.PASS, "Expected Rent has been entered successfully");
			} catch (Exception e) {
				extTest.log(Status.FAIL, "Failed to enter the Expected Rent: " + e.getMessage());
		  }
				
	   }

	public void enterExpectedDeposit(String deposit) {
		try {
			WebElement depositInput = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("deposit")));
			depositInput.click();
			depositInput.sendKeys(deposit);
			Base.sleep(1000);
			extTest.log(Status.PASS, "Expected Deposit has been entered successfully");
			} catch (Exception e) {
				extTest.log(Status.FAIL, "Failed to enter the Expected Deposit: " + e.getMessage());
		  }
		
	}

	public void selectAmenities() {
		try {
		driver.findElement(By.id("CUPBOARD")).click();
		driver.findElement(By.id("BEDDING")).click();
		driver.findElement(By.id("AC")).click();
		driver.findElement(By.id("AB")).click();
		extTest.log(Status.PASS, "Amenities selected successfully");
	  } catch (Exception e) {
		extTest.log(Status.FAIL, "Failed to select Amenities: " + e.getMessage());
	  }
	}

	public boolean redirectedPGDetailsPage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='PG Details']")));
			extTest.log(Status.PASS, "Redirected to PG details page  sucessfully");
			return true;
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Fail to redirect PG details page" + e.getMessage());
			return false;
		}
	}
	
	public void enterLanmark(String landmark) {
		try {
			WebElement landmarkInput = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("street")));
			landmarkInput.click();
			landmarkInput.sendKeys(landmark);
			Base.sleep(1000);
			extTest.log(Status.PASS, "landmark has been entered successfully");
			} catch (Exception e) {
				extTest.log(Status.FAIL, "Failed to enter the Landmark: " + e.getMessage());
		  }		
	}

	public void enterlocality(String locality) {
		try {
			WebElement localityInput = wait
					.until(ExpectedConditions.elementToBeClickable(By.id("propertyLocality")));
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

	public void selectPGdetails() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(
					By.id("PLACE_AVAILABLE-PLACE_AVAILABLE-nbInput-FEMALE"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(
					By.id("NO_SMOKING"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(
					By.id("NO_STAY"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(
					By.id("NO_ENTRY"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(
					By.id("NO_DRINKING"))).click();
			extTest.log(Status.PASS, "PgDetails selected successfully");
		  } catch (Exception e) {
			extTest.log(Status.FAIL, "Failed to select PgDetails: " + e.getMessage());
		  }		
	}


	public void selectPreferredGuest(String guest) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	        // 1. Click the dropdown
	        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
	            By.id("pgDetailsPypForm-PG_GUESTS-nbInput")
	        ));
	        dropdown.click();

	        // 2. Wait for menu to appear
	        wait.until(ExpectedConditions.presenceOfElementLocated(
	            By.xpath("//div[contains(@class,'nb-select__menu')]")
	        ));

	        // 3. Now select the option by visible text
	        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//div[contains(@class,'nb-select__option') and normalize-space(text())='" + guest + "']")
	        ));
	        option.click();

	        extTest.log(Status.PASS, "Guest type selected: " + guest);

	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Failed to select GuestType: " + e.getMessage());
	    }
	}


	public void selectAvailableDate() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		    // 1. Click the dropdown container to activate input
		    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//*[@placeholder='dd/mm/yyyy']")
		    ));
		    dropdown.click();

		    // 2. Find the input inside react-select (even if readonly, sendKeys works once focused)
		    WebElement inputBox = wait.until(ExpectedConditions.presenceOfElementLocated(
		        By.xpath("//*[@class='react-datepicker__current-month']")
		    ));

		    // 3. Wait for suggestion option & click it
		
		    WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(
			        By.xpath(" //*[@class='react-datepicker__navigation react-datepicker__navigation--next']")
			    ));
		    suggestion.click();
		    WebElement suggestion1 = wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//*[@aria-label=\"day-1\"]")
		    ));
		    suggestion1.click();
			    extTest.log(Status.PASS, "Availability Date selected ");
			}
			catch (Exception e) {
				extTest.log(Status.FAIL, "Failed to select Date: " + e.getMessage());
			}
		
	}
	public boolean redirectedAmenitiesPage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amenities")));
			extTest.log(Status.PASS, "Redirected to Amenities page sucessfully");
			return true;
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Fail to redirect Amenities page" + e.getMessage());
			return false;
		}
	}

	public void clicksFinishPosting() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//button[text()='Finish Posting']"))).click();
			extTest.log(Status.PASS, "posting Finished successfully");
		  }catch (Exception e) {
		extTest.log(Status.FAIL, "Failed to click finish posting button: " + e.getMessage());
	  }		
		
	}

	public void checksfinalpage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[text()='Congratulations!']"))).click();
			extTest.log(Status.PASS, "property has been posted");
		  }catch (Exception e) {
		extTest.log(Status.FAIL, "Failed to select PgDetails: " + e.getMessage());
	  }		
		
		
	}

	public void clickPreviewProperty() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					By.id("previewListing"))).click();
			extTest.log(Status.PASS, "Clicked the preview button to view the property ");
		  }catch (Exception e) {
		extTest.log(Status.FAIL, "Failed to click the preview button: " + e.getMessage());
	  }		
		
	}

	public boolean ispropertyVisible() {
		try {
	        // Switch to the latest opened tab
	        String currentHandle = driver.getWindowHandle();
	        for (String handle : driver.getWindowHandles()) {
	            if (!handle.equals(currentHandle)) {
	                driver.switchTo().window(handle);
	            }
	        }
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='resaleLogoDiv']")));
			extTest.log(Status.PASS, "Posted property has been checked");
			return true;
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Fail to post the property" + e.getMessage());
			return false;
		}
		
	}

	
	
	
}

