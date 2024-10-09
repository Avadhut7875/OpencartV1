package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[text()='Add to Cart']")
	WebElement btnAddToCart;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement msgHeading;
	
	public void clickAddToCart() {
		btnAddToCart.click();
	}
	
	public String msgHeading() {
		try {
			return (msgHeading.getText());
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
