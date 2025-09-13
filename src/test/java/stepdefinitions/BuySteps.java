package stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import pages.BuyPage;
import pages.PostPropertyPage;
import pages.RentPage;
import utils.Base;

public class BuySteps {
	WebDriver driver = Hooks.driver;
	ExtentTest extTest = Hooks.extTest;
    BuyPage buypage=new BuyPage(driver, extTest); ;
    
    @Given("the user click the buy")
    public void the_user_click_the_buy() {
    	buypage.clickBuyButton();
    }
    @When("the user select location {string}")
    public void the_user_select_location(String city) {
    	buypage.selectCity(city);
    }
    @Then("the user should be redirected to the Buy Page")
	public void the_user_should_be_redirected_to_the_Buy_page() {
		boolean displayPropertyCard = buypage.redirectedBuyPage();
	    Assert.assertTrue(displayPropertyCard);
	}
    @And("the user clicks on Property Type")
    public void the_user_clicks_on_Property_Type() {
    	buypage.clickPropertyType();
    }
    @And("the user clicks on BHK type")
    public void the_user_clicks_on_BHK_type() {
    	buypage.clickApartmentButton();
    }
    @And("the clicks Apartment type")
    public void the_clicks_Apartment_type() {
    	buypage.clickApartmentType();
    }
    @And("the user clicks the Price Range")
    public void the_user_clicks_the_Price_Range() {
    	buypage.clickPriceRange();
    }
    @Then("the Property should be displayed")
    public void the_Property_should_be_displayed() {
    	boolean displayPropertyItems = buypage.isPropertyDisplayed();
	    Assert.assertTrue(displayPropertyItems);
    	
    }
    @Then("the user clicks the get Owner Details")
    public void the_user_clicks_the_get_Owner_Details() throws Exception {
    	buypage.clickgetOwnerDetails();
    }
    
    @Then("the Contact Page should be displayed")
    public void the_Contact_Page_should_be_displayed(){
    	boolean display = buypage.isdisplayConfimationPage();
	    Assert.assertTrue(display);
    }
}
