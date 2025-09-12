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
	
	
	@When("the owner clicks on Post Free Property Ad")
	public void the_owner_clicks_on_Post_Free_Property_Ad() {
		postpropertypage.clicksPostProperty();
		Base.sleep(1000);
	}

   
	@Then("the owner should be redirected to the property Page")
	public void the_owner_should_be_redirected_to_the_property_page() {
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

	@Then("the owner should be redirected to the Post your property page")
	public void the_owner_should_be_redirected_to_the_post_your_property_page() {
		boolean displayPropertyPage = postpropertypage.redirectedDetailsPage();
	    Assert.assertTrue(displayPropertyPage);
	    Base.sleep(1000);
	}

	@And("the owner select city {string}")
	public void the_owner_select_city(String PropertyCity) {
		postpropertypage.enterCity(PropertyCity);
		Base.sleep(1000);
	   
	}
	
	@And("the owner select property type")
	public void the_owner_select_property_type() {
		postpropertypage.selectPropertytype();
		Base.sleep(1000);
	}

	@And("the owner select property Ad Type")
	public void the_owner_select_property_ad_type() {
		postpropertypage.selectpropertyAdType();
		Base.sleep(1000);
	}

	@When("the owner clicks on start posting Your Ad for FREE")
	public void the_owner_clicks_on_start_posting_your_ad_for_free() {
		postpropertypage.clicksStartPostingNow();
		Base.sleep(1000);
	}

	@Then("the owner should be redirected to the Room details page")
	public void the_owner_should_be_redirected_to_the_room_details_page() {
		boolean displayPropertyDetailsPage = postpropertypage.redirectedRoomDetailsPage();
	    Assert.assertTrue(displayPropertyDetailsPage);
	    Base.sleep(1000);
	}

	@Then("the owner clicks Yes")
	public void the_owner_clicks_yes() {
		postpropertypage.clicksalertConfirmation();
		Base.sleep(1000);
	}
	
	@Given("the owner is on the Room Details section")
	public void the_owner_is_on_room_details_section() {
		boolean displayRoomDetailsPage = postpropertypage.redirectedRoomDetailsPage();
	    Assert.assertTrue(displayRoomDetailsPage);
	    Base.sleep(1000);
		
	}
	@Then("the owner Select the type of rooms available")
	public void the_owner_select_the_type_of_rooms_available() {
		postpropertypage.selectRoomtype();
		Base.sleep(1000);
		
	}
	@When("the owner clicks Save & Continue")
	public void the_owner_clicks_save_continue(){
		postpropertypage.clickSaveContinue();
		Base.sleep(1000);
		
	}
	@Then("the owner enters expected rent {string}")
	public void the_owner_enters_expected_rent(String rent) {
		postpropertypage.enterexpectedrent(rent);
		Base.sleep(1000);
	}
	@Then("the owner enters expected deposit {string}")
	public void the_owner_enters_expected_deposit(String deposit) {
		postpropertypage.enterExpectedDeposit(deposit);
		Base.sleep(1000);
	}
	    
	@Then("the owner selects the amenities")
	public void the_owner_selects_the_amenities() {
		postpropertypage.selectAmenities();
		Base.sleep(1000);
	   	}
	@Then("the owner clicks on Save & Continue")
	public void the_owner_clicks_on_save_continue() {
		postpropertypage.clickSaveContinue();
		Base.sleep(1000);
	}
	@Then("the owner should be redirected to the Locality Details page")
	public void the_owner_should_be_redirected_to_the_locality_details_page() {
		boolean displayLocalityDetailsPage = postpropertypage.redirectedLocalityDetailsPage();
	    Assert.assertTrue(displayLocalityDetailsPage);
	    Base.sleep(1000);
	}
	
	@And("the owner enter Landmark {string}")
	public void the_owner_enter_Landmark(String Landmark) {
		postpropertypage.enterLanmark(Landmark);
		Base.sleep(1000);
	}
	@And("the owner enter the Locality {string}")
	public void the_owner_enter_the_locality(String Locality) {
		postpropertypage.enterlocality(Locality);
		Base.sleep(1000);
	}
	
	@Then("the owner should be redirected to the PG Details page")
	public void the_owner_should_be_redirected_to_the_pg_details_page() {
		boolean displaypgDetailsPage = postpropertypage.redirectedPGDetailsPage();
	    Assert.assertTrue(displaypgDetailsPage);
	    Base.sleep(1000);
	}
	@Then("the owner fills the Pg Details")
	public void the_owner_fills_the_pg_details() {
	   postpropertypage.selectPGdetails();
	   Base.sleep(1000);
	   
	}
	@Then("the owner select the prefered guests {string}")
	public void the_owner_select_the_prefered_guests(String Guest) {
	    postpropertypage.selectPreferredGuest(Guest);
	    Base.sleep(1000);
	}
	@Then("the owner enter the available date")
	public void the_owner_enter_the_available_date() {
	    postpropertypage.selectAvailableDate();
	    Base.sleep(1000);
	}
	@Then("the owner should be redirected to the Amenities Details page")
	public void the_owner_should_be_redirected_to_the_amenities_details_page() {
		boolean displaypgDetailsPage = postpropertypage.redirectedPGDetailsPage();
	    Assert.assertTrue(displaypgDetailsPage);
	    Base.sleep(1000);
	}
	@And("the owner clicks on Finish posting")
	public void the_owner_clicks_on_finish_posting() {
		postpropertypage.clicksFinishPosting();
		Base.sleep(1000);
	}
	
	@Then("the owner should be redirected to the final page")
	public void the_owner_should_be_redirected_to_the_final_page() {
	   postpropertypage.checksfinalpage();
	}
	@When("the owner clicks the preview property")
	public void the_owner_clicks_the_preview_property() {
	   postpropertypage.clickPreviewProperty();
	}
	@Then("the owner should be redirected to the posted property page")
	public void the_owner_should_be_redirected_to_the_posted_property_page() {
		boolean displayPost = postpropertypage.ispropertyVisible();
	    Assert.assertTrue(displayPost);
	    Base.sleep(1000);
	}

}
