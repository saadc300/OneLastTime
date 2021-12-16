package stepDefinitions;

import core.Base;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.UtilityClasses;

import org.junit.Assert;
import PageObject.HomePageObject;

public class HomePageStepDefinitions extends Base{

		HomePageObject home = new HomePageObject();
		
		@When("User click on Currency")
		public void user_click_on_currency() {
		   home.clickCurrency();
		   logger.info("User successfully clicked on Currency button");
		   UtilityClasses.takeScreenShot();
		}
		@When("User Choose Euro from dropdown")
		public void user_chose_euro_from_dropdown() {
		    home.clickEuro();
		    logger.info("User successfully selected Euro as Currency");
		    UtilityClasses.takeScreenShot();
		}
		@Then("currency value should change to Euro")
		public void currency_value_should_change_to_euro() {
			UtilityClasses.takeScreenShot();
		    Assert.assertTrue(home.validateCurrencyEuro());
		    UtilityClasses.takeScreenShot();
		    logger.info("Valideted that currency is Euro now");
		}
		@When("User click on shopping cart")
		public void user_click_on_shopping_cart() {
		   home.clickShoppingCart();
		   logger.info("User clicked on Shopping Cart button");
		   UtilityClasses.takeScreenShot();
		}
		@Then("Your shopping cart is empty! message should display")
		public void message_should_display() {
			UtilityClasses.takeScreenShot();
			Assert.assertTrue(home.validateEmptyCart());
			UtilityClasses.takeScreenShot();
			logger.info("Validated that cart is empty");
		}
}
