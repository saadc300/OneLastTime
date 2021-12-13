package stepDefinitions;

import core.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Initializer extends Base{
	
	// In this class we define Before Hooks and After Hooks of Cucumber
	//Before Hooks will run before each scenario
	//After Hooks will run after each scenario
	
	
	@Before
	public void beforeHooks(Scenario scenario) {
		logger.info("Scenario" + scenario.getName()+"Started");
		browser();// this method comes from base class browser
		openBrowser();// this comes from bas class for url 
		
	}

	@After
	public void afterHooks(Scenario scenario) {
		tearDown();//this will close the browser after
		logger.info("Scnario" +scenario.getName()+" " +scenario.getStatus());
	}
}
