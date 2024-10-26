package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath = "(//a[normalize-space()='Login'])[1]")
	WebElement lnkLogin;
	
	@FindBy(xpath = "//span[normalize-space()='Shopping Cart']")
	WebElement LnkShoppingCart;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement lnkSearch;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;
	
	public void clickMyAccount() {
		lnkMyaccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		lnkLogin.click();
	}
	
	public void clickShoppingCart() {
		LnkShoppingCart.click();
	}
	
	public void searchItem(String item) {
		lnkSearch.sendKeys(item);
	}
	
	public void clickSearchBtn() {
		btnSearch.click();
	}
	
	public void clearSearchBar() {
		lnkSearch.clear();
	}
}
