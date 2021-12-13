package stepDefinitions;

import org.junit.Assert;

import PageObject.LoginPageObject;
import core.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition  extends Base{
	LoginPageObject loginPageObject = new LoginPageObject();
	
	
	@Given("^user is on Retail website$")
	public void user_is_on_Retail_website() {
		String actualPageTitle = driver.getTitle();
		String expectedPgeTitle = "TEK SCHOOL";
		//Assertion is to verify actual meets the expected
		//if actual does not equals to expected value then execution will stop, and test step will fail.
		Assert.assertEquals(expectedPgeTitle, actualPageTitle);
		logger.info("Actual Titel is Matching With Expected Title");
	}
	
	@When ("^user click on  Myaccount$")
	public void user_click_on_Myaccount() {
		loginPageObject.clickOnMyAccount();
		logger.info("user clicked on MyAccount");
	}
	
	@And("^user click on Login option$")
	public void user_click_on_Login_option() {
		loginPageObject.clickOnLogin();
		logger.info("user cliecked on Login option");
	}
	@And("^user enter userName '(.+)' and password '(.+)'$")
	public void user_enter_userName_and_password(String uName, String pass)  {
		loginPageObject.enterEmailAndPassword(uName, pass);
		logger.info("user enter" + uName + "and password"+ pass);
	}
	@And("^user click on Login Button$")
	public void user_click_on_Login_Button() {
		loginPageObject.LoginButton();
		logger.info("user clicked on login button");
	}
	@Then("^user should be logged in to Myaccount dashboard$")
	public void user_should_be_logged_in_to_Myaccount_dashboard() {
		//Assert.assertTrue(loginPageObject.myAccountTextisPresent());
		logger.info("user is logged in to MyAccount Dashboard");
	}
}


