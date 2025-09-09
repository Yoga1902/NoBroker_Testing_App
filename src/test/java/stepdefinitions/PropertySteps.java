package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PropertyPage;
import utils.ExcelReader;

public class PropertySteps {

    WebDriver driver = Hooks.driver;
    ExtentTest extTest = Hooks.extTest;
    PropertyPage propertypage = new PropertyPage(driver, extTest);

    @When("the user clicks on Post Free Property Ad")
    public void the_user_clicks_on_post_free_property_ad() {
        propertypage.clickPostProperty();
    }

    @When("the user clicks on Post a New Property Ad Free")
    public void the_user_clicks_on_post_a_new_property_ad_free() {
        PropertyPage propertyPage = new PropertyPage(driver, extTest);
        propertyPage.clickpostNow();
    }


    @Then("the Post Your Property page should be displayed")
    public void the_post_your_property_page_should_be_displayed() {
        boolean isPageLoaded = propertypage.propertypageLoadedSuccessfully();
        Assert.assertTrue(isPageLoaded, "Property page did not load successfully");
    }
    
    @Given("the Post Your Property page is open")
    public void the_post_your_property_page_is_open() {
        // Reuse existing logic to click Post Free Property Ad and Post a New Property Ad Free
        propertypage.clickPostProperty();
        propertypage.clickpostNow();
        boolean isPageLoaded = propertypage.propertypageLoadedSuccessfully();
        Assert.assertTrue(isPageLoaded, "Post Your Property page did not load successfully");
    }
	    String filePath = "src/test/resources/testdata/PropertyData.xlsx";
	    String sheetName = "Property";
	
	    String city = ExcelReader.getCellValue(filePath, sheetName, 1, 0);   // Row 1, Column 0
	    String propertyType = ExcelReader.getCellValue(filePath, sheetName, 1, 1);
	    String adType = ExcelReader.getCellValue(filePath, sheetName, 1, 2);
	
	   
	
	    @When("the user fills property details from excel row {int}")
	    public void the_user_fills_property_details_from_excel_row(Integer rowNum) {
	        String filePath = "src/test/resources/testdata/PropertyData.xlsx";
	        String sheetName = "Property";
	
	        String city = utils.ExcelReader.getCellValue(filePath, sheetName, rowNum, 0);
	        String propertyType = utils.ExcelReader.getCellValue(filePath, sheetName, rowNum, 1);
	        String adType = utils.ExcelReader.getCellValue(filePath, sheetName, rowNum, 2);
	
	        propertypage.fillPropertyDetails(city, propertyType, adType);
	    }
	
	
	    @When("the user clicks on Start Posting Your Ad For Free button")
	    public void the_user_clicks_on_start_posting_your_ad_for_free_button() {
	        propertypage.clickStartPosting();
	    }
	
	    @Then("the Property Details form should be displayed")
	    public void the_property_details_form_should_be_displayed() {
	        boolean formVisible = propertypage.isPropertyDetailsFormVisible();
	        Assert.assertTrue(formVisible, "Property Details form did not load!");
	    }
	
	    
	}
