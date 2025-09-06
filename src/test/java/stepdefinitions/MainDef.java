package stepdefinitions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class MainDef {
	
	WebDriver driver=Hooks.driver;
	ExtentTest extTest=Hooks.extTest;
}