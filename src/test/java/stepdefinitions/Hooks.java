

 package stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.*;
import pages.LoginPage;
import utils.Base;

public class Hooks extends Base {
	 static ExtentSparkReporter spark;
	    static ExtentReports extReports;
	    public static ExtentTest extTest;
	    public static WebDriver getDriver() {
	        return driver;
	    }

	    
	    // Instance variables for specific hook functionality
	    LoginPage loginPage;

	    @BeforeAll
	    public static void beforeAll(){
	        spark = new ExtentSparkReporter("report/ExtendsReport.html");
	        extReports = new ExtentReports();
	        extReports.attachReporter(spark);
	    }

	    @AfterAll
	    public static void afterAll(){
	        extReports.flush();
	    }

	    // General setup for all scenarios
	    @Before(order = 1)
	    public void setup(Scenario scenario){
	        lanchBrowser();
	        extTest = extReports.createTest(scenario.getName());
	        
	        // Initialize loginPage for tag-specific hooks
	        if (driver != null) {
	            loginPage = new LoginPage(driver, extTest);
	        }
	    }
	    @Before("@rent")
		public void loginBeforeHome(Scenario scenario) {
			loginPage = new LoginPage(driver, extTest);
			loginPage.clickLogin();
			loginPage.enterMobileNumber("9003855489");  
			loginPage.enterOtpManually(driver); 
			loginPage.clickContinue();
		}
	    
	    @After(order = 1)
	    public void tearDown(Scenario scenario){
	        Base.sleep(1000);

	        // ✅ If it's a @post_property scenario, keep the browser alive
	        if (scenario.getSourceTagNames().contains("@post_property")) {
	            System.out.println("Keeping session alive for @post_property scenario: " + scenario.getName());
	            return; // do not quit
	        }

	        // For all other scenarios, close the driver
	        if (driver != null) {
	            driver.quit();
	        }
	    }

	   

	    // Before each LOGIN feature scenario - ensure fresh start
	    @Before(value = "@login", order = 2)
	    public void beforeLoginScenario(Scenario scenario) {
	        System.out.println("Starting login scenario: " + scenario.getName());
	        
	        // Clear browser state for login tests
	        if (loginPage != null && loginPage.loginsuccessful()) {
	            // If logged in, logout or clear session
	            driver.manage().deleteAllCookies();
	            driver.get("your-login-page-url"); // Navigate to fresh login page
	        }
	    }

	    // Before PROPERTY feature - no action needed, will use background
	    @Before(value = "@property", order = 2) 
	    public void beforePropertyScenario(Scenario scenario) {
	        System.out.println("Starting property scenario: " + scenario.getName());
	        // Don't clear anything - let background handle login once
	    }

	    // After LOGIN feature scenarios - clean up if needed
	    @After(value = "@login", order = 2)
	    public void afterLoginScenario(Scenario scenario) {
	        System.out.println("Completed login scenario: " + scenario.getName());
	        // Optional: Could clear browser state after each login test
	        // if you want complete isolation
	    }

	    // After PROPERTY feature - keep session alive
	    @After(value = "@property", order = 2)
	    public void afterPropertyScenario(Scenario scenario) {
	        // Don't close browser or clear cookies - maintain session
	        System.out.println("Property scenario completed, maintaining session");
	    }

	    // General teardown for all scenarios
	    @After(order = 1)
	    public void tearDown(){
	        Base.sleep(1000);
	        
	        // Only quit driver if not maintaining session for property scenarios
	        // Check if current scenario has @property tag
	        // Note: You might need to pass scenario to this method to check tags
	        driver.quit();
	        
	    }
	    @Before("@login")
	    public void loginBeforeSearch() {
	        LoginPage loginPage = new LoginPage(driver, Hooks.extTest);
	        driver.get("https://www.nobroker.in/");
	
	        loginPage.clickLogin();
	        loginPage.enterMobileNumber("9003855489");
	
	        // Enter OTP manually in console
	        loginPage.enterOtpManually(driver);
	        loginPage.clickContinue();
	        
	    }
	   

}