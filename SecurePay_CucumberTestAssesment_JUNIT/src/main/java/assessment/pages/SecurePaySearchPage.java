package assessment.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assessment.generic.DriverSetup;

public class SecurePaySearchPage {
	private WebDriver driver;

	@FindBy(xpath = "//input[@class='gLFyf gsfi']")
	private WebElement googleSearch;

	@FindBy(xpath = "//cite[.='https://www.securepay.com.au/']")
	private WebElement securePayURL;

	// Initialization
	public SecurePaySearchPage() {
		// TODO Auto-generated constructor stub
		driver = DriverSetup.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void searchSecurePay(String arg1) {
		// TODO Auto-generated method stub
		googleSearch.sendKeys(arg1, Keys.ENTER);
	}

	public void selectSecurePayWebsite() {
		// TODO Auto-generated method stub
		securePayURL.click();

	}

	public void navigateToGoolgeSearch(String arg2) {
		// TODO Auto-generated method stub
		System.out.println(driver.getTitle());
		System.out.println(driver);
//		System.out.println(arg2);
		DriverSetup.getDriver().get(arg2);
	}

}
