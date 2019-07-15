package assessment.generic;

import java.io.File;
import java.util.Date;

import org.junit.BeforeClass;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseTest {


	@Before
	public void preCondition() {
		DriverSetup.initDriver();
	}

	@After
	public void exitCondition(Scenario scenarioStatus) {
		Utilities.captureScreenShot(scenarioStatus);
		DriverSetup.tearDown();
	}
}
