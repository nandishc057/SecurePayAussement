package assessment.test.TestRunner;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {
		"./src/test/java/assessment/test/feature/FillContactUSFormTestUsingRandomData.feature" },
		glue = {"assessment.test.stepDefinition", "assessment.generic" },
		plugin = { "html:test-output/Cucumber-report", "pretty", "com.cucumber.listener.ExtentCucumberFormatter:" }, 
		strict = true, 
		dryRun = false, 
		monochrome = true, 
		tags = {})
public class TestRunner {
	@BeforeClass
	public static void extentReportMth() {

		Date date = new Date();
		String dateString = date.toString().replace(":", "_").replace(" ", "_");
		String ExtentReport = "./ExtentReports/ExtentReport" + "-" + dateString;

		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath(ExtentReport + ".html");
	}

}
