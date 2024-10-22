package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditInfoPage extends BasePage {

	public EditInfoPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "(//input[@id='input-firstname'])[1]")
	WebElement txtFirstName;

	@FindBy(xpath = "(//input[@id='input-lastname'])[1]")
	WebElement txtLastName;

	@FindBy(xpath = "(//input[@id='input-email'])[1]")
	WebElement txtEmail;

	@FindBy(xpath = "(//input[@id='input-telephone'])[1]")
	WebElement txtTelephone;

	@FindBy(xpath = "(//input[@value='Continue'])[1]")
	WebElement btnContinue;

	@FindBy(xpath = "(//a[normalize-space()='Back'])[1]")
	WebElement btnBack;

	public void setFirstName(String fname) {
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String tel) {
		txtTelephone.clear();
		txtTelephone.sendKeys(tel);
	}

	public void clickContinueButton() {
		btnContinue.click();
	}

	public void clickBackButton() {
		btnBack.click();
	}

}
