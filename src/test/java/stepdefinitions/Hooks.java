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

public class Hooks extends Base {
	
	static ExtentSparkReporter spark;
	static ExtentReports extReports;
	static ExtentTest extTest;
	
	@BeforeAll
	public static void beforeAll(){
		spark=new ExtentSparkReporter("report/ExtendsReport.html");
		extReports=new ExtentReports();
		extReports.attachReporter(spark);
	}
	
<<<<<<< HEAD
	
=======
>>>>>>> 7f55e8c1ecec4269fb2e56e35dd8805186458bce
	@AfterAll
	public static void afterAll(){
		extReports.flush();
	}
	
	@Before
	public void setup(Scenario scenario){
<<<<<<< HEAD
		launchBrowser();
=======
		lanchBrowser();
>>>>>>> 7f55e8c1ecec4269fb2e56e35dd8805186458bce
		extTest=extReports.createTest(scenario.getName());
	}
	
	@After
	public static void tearDown(){
		Base.sleep();
		driver.quit();
	}
<<<<<<< HEAD
	
=======
>>>>>>> 7f55e8c1ecec4269fb2e56e35dd8805186458bce
}
