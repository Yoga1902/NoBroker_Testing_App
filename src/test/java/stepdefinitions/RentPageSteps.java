package stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RentPage;

public class RentPageSteps {
	
	WebDriver driver = Hooks.driver;
	ExtentTest extTest = Hooks.extTest;
	
	RentPage rentPage=new RentPage(driver, extTest);
    
	@Given("the user click the rent")
	public void the_user_click_the_rent() {
		rentPage.clickRentButton();
	}
	
	@When("the user selects location {string}")
	public void the_user_selects_location(String location) {
		rentPage.selectCity(location);
	}
	
	@When("enters landmark {string}")
	public void enters_landmark(String locality) {
		rentPage.enterLocality(locality);
	}
	
	@When("clicks on search button")
	public void clicks_on_search_button() {
		rentPage.clickSearchButton();
	}
	
	@Then("an error message should be displayed")
	public void an_error_message_should_be_displayed() {
		boolean errorShown = rentPage.isLocalityErrorDisplayed();
	    Assert.assertTrue(errorShown);
	}
	
	@When("leaves the landmark field blank")
	public void leaves_the_landmark_field_blank() {
		rentPage.enterLocality("");
	}
	
	@Then("the user should be redirected to the Rent Page")
	public void the_user_should_be_redirected_to_the_rent_page() {
		boolean displayPropertyCard = rentPage.redirectedRentPage();
	    Assert.assertTrue(displayPropertyCard);
	}
	
	@When("the user returns to the home page")
    public void the_user_returns_to_the_home_page() {
        driver.navigate().to("https://www.nobroker.in/");  // or use your HomePage.openHomePage()
        driver.navigate();
    }

	@Then("the previous search should appear in search history")
	public void the_previous_search_should_appear_in_search_history() {
	    Assert.assertTrue(rentPage.isContinueLastSearchVisible());
	}

	
}