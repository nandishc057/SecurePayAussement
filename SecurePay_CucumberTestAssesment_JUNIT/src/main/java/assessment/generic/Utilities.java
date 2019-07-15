package assessment.generic;

import java.io.File;

import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;

public class Utilities {

	public static void captureScreenShot(Scenario scenarioStatus) {
		Reporter.loadXMLConfig(new File("./src/test/resources/ReportsConfig.xml"));
		if (scenarioStatus.isFailed()) {
			TakesScreenshot screenshot = (TakesScreenshot) DriverSetup.getDriver();
			byte[] scBytes = screenshot.getScreenshotAs(OutputType.BYTES);
			scenarioStatus.embed(scBytes, "image/png");

		}
	}

	public static boolean isElementPresent(WebElement webElement) {
		try {
			boolean isPresent = webElement.isDisplayed();
			return isPresent;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void movetoMenu(WebElement element) {
		try {
			Actions action = new Actions(DriverSetup.getDriver());
			action.moveToElement(element).perform();
		} catch (NoSuchElementException e) {
			// TODO: handle exception

		}
	}

	public static boolean verifyPageisLoaded(WebElement element) {
		WebDriverWait wait = new WebDriverWait(DriverSetup.getDriver(), 10);
		boolean status = false;
		JavascriptExecutor js = (JavascriptExecutor) DriverSetup.getDriver();

		String pageLoadStatus = (String) js.executeScript("return document.readyState");

		try {

			wait.until(ExpectedConditions.elementToBeClickable(element));
			while (pageLoadStatus.equals("complete")) {
				status = true;
				break;
			}

		} catch (Exception e) {
			// TODO: handle exception
			status = false;
		}

		return status;

	}

	public static void selectByValue(WebElement string2, String string) {
		// TODO Auto-generated method stub
		try {
			Select select = new Select(string2);
			select.selectByValue(string);
		} catch (InvalidSelectorException e) {
			// TODO: handle exception
		}

	}

}
