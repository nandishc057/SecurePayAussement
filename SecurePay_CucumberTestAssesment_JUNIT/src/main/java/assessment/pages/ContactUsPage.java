package assessment.pages;

import java.util.ArrayList;
import java.util.Locale;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import assessment.generic.DriverSetup;
import assessment.generic.Utilities;

public class ContactUsPage {

	private WebDriver driver;
	// -----------------Random
	// Data-----------------------------------------------------------------
	String firstNameStr;
	String lastnameStr;
	String emailAddresStr;
	String cellPhoneNumberStr;
	String companyUrlStr;
	String companyNameStr;

	// ---------------------------------------------------------------------------------------------

	WebDriverWait explicitWait = new WebDriverWait(DriverSetup.getDriver(), 10);

	@FindBy(xpath = "//nav[@id='main-nav']//a[@href='https://www.securepay.com.au/support/']")
	private WebElement support;
	@FindBy(xpath = "//nav[@id='main-nav']//a[@href='https://www.securepay.com.au/support/contact-us/']")
	private WebElement contactUs;

	@FindBy(css = "input[name='first-name']")
	private WebElement firstName;

	@FindBy(css = "input[name='last-name']")
	private WebElement lastName;

	@FindBy(css = "input[type='email']")
	private WebElement email;

	@FindBy(css = "input[name='phone-number']")
	private WebElement phoneNumber;

	@FindBy(css = "input[type='url']")
	private WebElement url;

	@FindBy(css = "input[name='business-name']")
	private WebElement company;

	@FindBy(css = "select[name='reason-for-enquiry']")
	private WebElement selectTag;

	public ContactUsPage() {
		driver = DriverSetup.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void navigateContactUsPage() throws InterruptedException {
		Utilities.movetoMenu(support);
		explicitWait.until(ExpectedConditions.visibilityOf(contactUs));
		contactUs.click();

	}

	// WebElement is passed as argument, In order to check Page is loaded
	public void verifyPageIsLoaded() {
		boolean status = Utilities.verifyPageisLoaded(firstName);
		Assert.assertEquals("Page is loaded Completely", true, status);
	}

	public void generateRandomData() {

		firstNameStr = new Faker(new Locale("en-AU")).name().firstName();
		lastnameStr = new Faker(new Locale("en-AU")).name().lastName();
		emailAddresStr = new Faker(new Locale("en-AU")).internet().emailAddress();
		cellPhoneNumberStr = new Faker(new Locale("en-AU")).phoneNumber().cellPhone();
		companyUrlStr = new Faker(new Locale("en-AU")).company().url();
		companyNameStr = new Faker(new Locale("en-AU")).company().name();

	}

	public void fillForm() throws InterruptedException {

		firstName.sendKeys(firstNameStr);
		lastName.sendKeys(lastnameStr);
		email.sendKeys(emailAddresStr);
		phoneNumber.sendKeys(cellPhoneNumberStr);
		url.sendKeys(companyUrlStr);
		company.sendKeys(companyNameStr);
		Utilities.selectByValue(selectTag, "Support");
		Thread.sleep(10000);
		
		//Random Data Generation using for loop
/*		String[] enquiryString = { "Support", "Accounts", "Support", "Accounts", "Support", "Accounts" };
		for (int i = 0; i < 6; i++) {

			firstName.sendKeys(new Faker(new Locale("en-AU")).name().firstName());
			lastName.sendKeys(new Faker(new Locale("en-AU")).name().lastName());
			email.sendKeys(new Faker(new Locale("en-AU")).internet().emailAddress());
			phoneNumber.sendKeys(new Faker(new Locale("en-AU")).phoneNumber().cellPhone());
			url.sendKeys(new Faker(new Locale("en-AU")).company().url());
			company.sendKeys(new Faker(new Locale("en-AU")).company().name());
			Utilities.selectByValue(selectTag, enquiryString[i]);
			Thread.sleep(7000);
			DriverSetup.getDriver().navigate().refresh();
		}*/
	}

	public void dontSubmit() throws InterruptedException {
		Thread.sleep(5000);
	}

}
