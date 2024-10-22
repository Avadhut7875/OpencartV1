package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement LnkLogout;
	
	@FindBy(xpath = "(//a[normalize-space()='Change your password'])[1]")
	WebElement LnkForgotPassword;
	
	@FindBy(xpath = "(//input[@id='input-password'])[1]")
	WebElement txtFieldPassword;
	
	@FindBy(xpath = "(//input[@id='input-confirm'])[1]")
	WebElement txtFieldConfirmPassword;
	
	@FindBy(xpath = "(//input[@value='Continue'])[1]")
	WebElement btnContinue;
	
	@FindBy(xpath = "(//div[@class='alert alert-success alert-dismissible'])[1]")
	WebElement msgPasswordSuccess;
	
	@FindBy(xpath = "(//div[@class='alert alert-success alert-dismissible'])[1]")
	WebElement msgProfileUpdateSuccess;
	
	@FindBy(xpath = "(//a[normalize-space()='Edit your account information'])[1]")
	WebElement lnkEditAccountInfo;

	public boolean isMyAccountPageExists() {

		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}

	}
	
	public void clickLogout() {
		LnkLogout.click();
	}
	
	public void clickForgotPassword() {
		LnkForgotPassword.click();
	}
	
	public void setNewPassword(String pwd) {
		txtFieldPassword.sendKeys(pwd);
	}
	
	public void setNewConfirmPassword(String cpwd) {
		txtFieldConfirmPassword.sendKeys(cpwd);
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public void clickEditAccountInfo() {
		lnkEditAccountInfo.click();
	}
	
	public String isPasswordChanged() {
		try {
			return msgPasswordSuccess.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String isProfileUpdated() {
		try {
			return msgProfileUpdateSuccess.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	

}
