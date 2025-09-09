package pages;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import objectrepository.Locators;



public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;

	public LoginPage(WebDriver driver, ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.extTest = extTest;
	}

	public void clickLogin() {
		driver.findElement(objectrepository.Locators.loginButton).click();
	}

	public void enterMobileNumber(String number) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement phoneInput = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.id("signUp-phoneNumber"))
	    );
	    phoneInput.clear();
	    phoneInput.sendKeys(number);
	}


    public void clickContinue() {
        driver.findElement(objectrepository.Locators.continueButton).click();
    }

	public void enterOtp(String otp) {
		WebElement otpField = driver.findElement(objectrepository.Locators.otpInputs);
		otpField.sendKeys(otp);
	}
	
	public void enterOtpManually(WebDriver driver) {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Enter OTP received in mobile SMS : ");
	    String otp = sc.nextLine();

	    // Wait until OTP input box is visible
	    wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    WebElement otpBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[aria-label*='verification code']")));
	    otpBox.sendKeys(otp);
	}

//
//    public void clickVerifyOtp() {
//        driver.findElement(verifyOtpButton).click();
//    }
//
//    public void clickResendOtp() {
//        driver.findElement(resendOtpLink).click();
//    }

	public boolean getNumErrorMessage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Please enter valid phone number')]")));
			return true;
		}
		catch(TimeoutException te) {
			return false;
		}
	}

	public boolean getOtpErrorMessage() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Please enter valid OTP')]")));
			return true;
		}
		catch(TimeoutException te) {
			return false;
		}
	}
	
	public boolean loginsuccessful() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile-icon")));
			return true;
		}
		catch(TimeoutException te) {
			return false;
		}
	}
    public void clickResendOtp() {
        driver.findElement(objectrepository.Locators.resendOtpLink).click();
    }

    public boolean pageLoadedSuccessfully() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.loginButton));
            return true;
        } catch (TimeoutException te) {
            return false;
        }
    }

	
}