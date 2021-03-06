package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utilities.CucumberReportingConfig;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".\\src\\test\\resource\\features",
		glue = "stepDefinitions",// to link to stepDefinitions folder
		tags = "@Test", // will run one scenario , or multiple scenarios, or entire feature
		dryRun= false, //checks if there are any missing steps in stepDefinition class for each scenario 
		monochrome= true,//Will make console to readable 
		strict = true,     // will mark scenario failed if there are any pending steps 
		plugin = {"pretty",
				"html:target/cucumber-reports/cucumber-pretty", 
				"json:target/cucmber-reports/CucumberTestReport.json", 
				"rerun:target/cucumber-reports/rerun.txt"},/// to make result readable 
		publish = true // to publish to console 
		)
public class TestRunner {
	@AfterClass 
 public static void generateReport() {
	 CucumberReportingConfig.reportConfig();
 }
}
