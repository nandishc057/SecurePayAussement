package assessment.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverSetup implements AutoConstants {

	private static DriverSetup driverSetup;
	public static WebDriverWait wait;
	public static WebDriver driver;

	private DriverSetup() {
		System.setProperty(chromeKey, chromeValue);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void initDriver() {
		if (driverSetup == null) {
			driverSetup = new DriverSetup();
		}
	}

	public static void tearDown() {
		if (driver != null) {
            driver.close();
            driver.quit();
		}
		driverSetup=null;
	}

}
