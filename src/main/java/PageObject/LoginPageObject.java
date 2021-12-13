package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class LoginPageObject extends Base {
	
	public LoginPageObject () {
		PageFactory.initElements(driver, this);
	}
		@FindBy (xpath = "//a[@title='My Account']") 
		private WebElement MyAccount;
		
		@FindBy (xpath = "//a[text()='Login']")
		private WebElement login;
		
		@FindBy (xpath ="//input[@id='input-email']")
		private WebElement email;
		
		@FindBy (xpath ="//input[@id='input-password']")
		private WebElement password;
		
		@FindBy (xpath ="//input[@value='Login']")
		private WebElement LoginButton;
		
		public void clickOnMyAccount() {
			MyAccount.click();
			
			}
		public void clickOnLogin() {
			login.click();
		}
		
		public void enterEmailAndPassword(String emailAdd,String passwd) {
			email.sendKeys(emailAdd);
		password.sendKeys(passwd);
		}
		
		public void LoginButton() {
			LoginButton.click();

}
}
