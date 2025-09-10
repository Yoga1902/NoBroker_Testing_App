package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.Base;
import pages.LoginPage;

public class Hooks extends Base {

    static ExtentSparkReporter spark;
    static ExtentReports extReports;
    public static ExtentTest extTest;
    
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
}