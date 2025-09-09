package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.Base;


public class LoginSteps {
	static boolean isLoggedIn = false;
	WebDriver driver = Hooks.driver;
	ExtentTest extTest = Hooks.extTest;

	LoginPage loginPage;
	
	

	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		String expResult = "https://www.nobroker.in/";
		String actResult = driver.getCurrentUrl();
		Assert.assertEquals(actResult, expResult);
	}

	@When("the user enters a invalid phone number")
	public void the_user_enters_a_invalid_phone_number() {
		loginPage = new LoginPage(driver, extTest);
		loginPage.clickLogin();
		loginPage.enterMobileNumber("89765489");
		loginPage.clickContinue();
	}
	
	@Then("an invalid number message should be shown")
	public void an_invalid_number_message_should_be_shown() {
		boolean actualError = loginPage.getNumErrorMessage();
        Assert.assertTrue(actualError);
	}

	@When("the user enters a valid phone number")
	public void the_user_enters_a_valid_phone_number() {
		loginPage = new LoginPage(driver, extTest);
		loginPage.clickLogin();
		loginPage.enterMobileNumber("9003855489");  
	}
	
	@When("the user enters the invalid OTP")
	public void the_user_enters_the_invalid_otp() {
		loginPage.enterOtp("897654");
		loginPage.clickContinue();
	}
	
	@Then("an invalid otp message should be shown")
	public void an_invalid_otp_message_should_be_shown() {
		boolean actualError = loginPage.getOtpErrorMessage();
        Assert.assertTrue(actualError);
	}

	
    @When("waits until the OTP expires and clicks on resend button")
    public void waits_until_the_otp_expires_and_clicks_on_resend_button() {
        Base.sleep(35000); // wait until OTP expiry (adjust based on actual timeout)
        loginPage.clickResendOtp();
    }

    @Then("the login page should be loaded successfully")
    public void the_login_page_should_be_loaded_successfully() {
        loginPage = new LoginPage(driver, extTest);  // initialize here
        boolean pageLoaded = loginPage.pageLoadedSuccessfully();
        Assert.assertTrue(pageLoaded);
    }

    @When("the user enters the valid OTP")
	public void the_user_enters_the_valid_otp() {
		loginPage.enterOtpManually(driver); 
		Base.sleep();
		loginPage.clickContinue();
		Base.sleep();
	}

	@Then("the user should be logged in successfully")
	public void the_user_should_be_logged_in_successfully() {
		boolean actualError = loginPage.loginsuccessful();
        Assert.assertTrue(actualError);
	}
	
}