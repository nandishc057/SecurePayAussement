package assessment.test.stepDefinition;

import assessment.pages.ContactUsPage;
import assessment.pages.SecurePaySearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FillContactUSFormUsingRandomDataStepFile {

	// object creation for Page object model Design pattern
	SecurePaySearchPage securePayPage = new SecurePaySearchPage();
	ContactUsPage contactUsPage = new ContactUsPage();

	@Given("^Searches for \"([^\"]*)\" on \"([^\"]*)\"$")
	public void searches_for_on(String arg1, String arg2) throws Throwable {
		securePayPage.navigateToGoolgeSearch(arg2);
		securePayPage.searchSecurePay(arg1);
	}

	@When("^Clicks through to the SecurePay website$")
	public void clicks_through_to_the_SecurePay_website() throws Throwable {
		securePayPage.selectSecurePayWebsite();
	}

	@When("^Navigates to the contact us page$")
	public void navigates_to_the_contact_us_page() throws Throwable {
		contactUsPage.navigateContactUsPage();
	}

	@Then("^Verifies that the contact us page is loaded$")
	public void verifies_that_the_contact_us_page_is_loaded() throws Throwable {
		contactUsPage.verifyPageIsLoaded();
	}

	@Then("^Generates random data using an open-source library$")
	public void generates_random_data_using_an_open_source_library() throws Throwable {
		contactUsPage.generateRandomData();
	}

	@Then("^Uses the generated data to fill in the contact us form$")
	public void uses_the_generated_data_to_fill_in_the_contact_us_form() throws Throwable {
		contactUsPage.fillForm();

	}

	@Then("^The test must not submit the form$")
	public void the_test_must_not_submit_the_form() throws Throwable {
		contactUsPage.dontSubmit();
	}

}
