package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
<<<<<<< HEAD
	features="src\\test\\resources\\features\\property.feature",
=======
	features="src\\test\\resources\\features\\login.feature",
>>>>>>> 7f55e8c1ecec4269fb2e56e35dd8805186458bce
	glue="stepdefinitions",
	plugin= {"pretty","html:reports/cucumber-html-report.html"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
	
<<<<<<< HEAD
}
=======
}
>>>>>>> 7f55e8c1ecec4269fb2e56e35dd8805186458bce
