package stepdefinitions;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PostPropertyPage;
import pages.RentPage;
import utils.Base;

public class PostPropertySteps {
	WebDriver driver = Hooks.driver;
	ExtentTest extTest = Hooks.extTest;
	
	PostPropertyPage postpropertypage = new PostPropertyPage(driver, extTest);;
	
	
	@When("the user clicks on Post Free Property Ad")
	public void the_user_clicks_on_Post_Free_Property_Ad() {
		postpropertypage.clicksPostProperty();
		Base.sleep(1000);
	}

   
	@Then("the user should be redirected to the property Page")
	public void the_user_should_be_redirected_to_the_property_page() {
		postpropertypage = new PostPropertyPage(driver, extTest);
		boolean displaypostPropertyPage = postpropertypage.redirectedPostPropertyPage();
	    Assert.assertTrue(displaypostPropertyPage);
	    Base.sleep(1000);
	}

	@And("clicks the Post Now")
	public void clicks_the_post_now() {
		postpropertypage.clicksPostNow();
		  Base.sleep(1000);
	}

	@Then("the user should be redirected to the Post your property page")
	public void the_user_should_be_redirected_to_the_post_your_property_page() {
		boolean displayPropertyPage = postpropertypage.redirectedDetailsPage();
	    Assert.assertTrue(displayPropertyPage);
	    Base.sleep(1000);
	}

	@And("the user select city {string}")
	public void the_user_select_city(String City) {
		postpropertypage.enterCity(City);
		Base.sleep(1000);
	   
	}
	
	@And("the user select property type")
	public void the_user_select_property_type() {
		postpropertypage.selectPropertytype();
		Base.sleep(1000);
	}

	@And("the user select property Ad Type")
	public void the_user_select_property_ad_type() {
		postpropertypage.selectpropertyAdType();
		Base.sleep(1000);
	}

	@When("the user clicks on start posting Your Ad for FREE")
	public void the_user_clicks_on_start_posting_your_ad_for_free() {
		postpropertypage.clicksStartPostingNow();
		Base.sleep(1000);
	}

	@Then("the user should be redirected to the Room details page")
	public void the_user_should_be_redirected_to_the_room_details_page() {
		boolean displayPropertyDetailsPage = postpropertypage.redirectedRoomDetailsPage();
	    Assert.assertTrue(displayPropertyDetailsPage);
	    Base.sleep(1000);
	}

	@Then("the user clicks Yes")
	public void the_user_clicks_yes() {
		postpropertypage.clicksalertConfirmation();
		Base.sleep(1000);
	}
	
	@Given("the user is on the Room Details section")
	public void the_user_is_on_room_details_section() {
		boolean displayRoomDetailsPage = postpropertypage.redirectedRoomDetailsPage();
	    Assert.assertTrue(displayRoomDetailsPage);
	    Base.sleep(1000);
		
	}
	@Then("the user Select the type of rooms available")
	public void the_user_select_the_type_of_rooms_available() {
		postpropertypage.selectRoomtype();
		Base.sleep(1000);
		
	}
	@When("the user clicks Save & Continue")
	public void the_user_clicks_save_continue(){
		postpropertypage.clickSaveContinue();
		Base.sleep(1000);
		
	}
	@Then("the user should be redirected to the Locality Details")
	public void the_user_should_be_redirected_to_the_locality_details() {
		boolean displayLocalityDetailsPage = postpropertypage.redirectedLocalityDetailsPage();
	    Assert.assertTrue(displayLocalityDetailsPage);
	    Base.sleep(1000);
	}


}
