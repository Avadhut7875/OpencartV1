package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "(//i[@class='fa fa-times-circle'])[1]")
	WebElement cancelItemBtn;

	@FindBy(xpath = "(//i[@class='fa fa-refresh'])[1]")
	WebElement updateProductBtn;

	@FindBy(xpath = "(//a[normalize-space()='Continue Shopping'])[1]")
	WebElement continueShoppingBtn;

	@FindBy(xpath = "(//a[normalize-space()='Estimate Shipping & Taxes'])[1]")
	WebElement lnkShippingDropDown;

	@FindBy(xpath = "//select[@id='input-country']")
	WebElement selCountry;

	@FindBy(xpath = "(//select[@id='input-zone'])[1]")
	WebElement selState;

	@FindBy(xpath = "//input[@id='input-postcode']")
	WebElement textPincode;

	@FindBy(xpath = "//button[@id='button-quote']")
	WebElement btnGetQuote;

	@FindBy(xpath = "//input[@name='shipping_method']")
	WebElement btnShippingMethod;

	@FindBy(xpath = "//input[@id='button-shipping']")
	WebElement btnApplyShipping;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement btnCancelShipping;

	@FindBy(xpath = "(//a[@class='btn btn-primary'])[1]")
	WebElement checkoutBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement msgShippingSuccess;

	@FindBy(xpath = "(//span[@id='cart-total'])[1]")
	WebElement cartTotal;

	public void setShippingDetails(String countryName, String stateValue, String pincode) throws InterruptedException {
		lnkShippingDropDown.click();
		Select select = new Select(selCountry);
		select.selectByVisibleText(countryName);
		Thread.sleep(1000);
		try {
			Select select2 = new Select(selState);
			select2.selectByValue(stateValue);
		} catch (Exception e) {
			System.out.println(e);
		}
		textPincode.sendKeys(pincode);
	}

	public void getQuote() {
		btnGetQuote.click();
	}

	public void setShippingMethod() {
		btnShippingMethod.click();
	}

	public void applyShipping() {
		btnApplyShipping.click();
	}

	public void cancelShipping() {
		btnCancelShipping.click();
	}

	public String shippingMsg() {
		try {
			return msgShippingSuccess.getText();

		} catch (Exception e) {
			return e.getMessage();

		}
	}

	public void updateProduct() {
		updateProductBtn.click();
	}

	public void cancelProduct() {
		cancelItemBtn.click();
	}

	public void continueShopping() {
		continueShoppingBtn.click();
	}

	public void checkOut() {
		checkoutBtn.click();

	}

	public int getItemCount() {
		String string = cartTotal.getText();
		System.out.println(string);
		if (string.startsWith("1")) {
			return 1;
		} else if (string.startsWith("2")) {
			return 2;
		} else {
			return 0;
		}

	}

}
