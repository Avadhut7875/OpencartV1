package pageObjects;

import java.io.IOException;
import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasePage {
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	@FindBy(xpath = "(//span[normalize-space()='Add to Cart'])[1]")
	WebElement btnFirstAddToCart;
	
	@FindBy(xpath = "(//button[@id='button-cart'])[1]")
	WebElement btnSecondAddToCart;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement msgHeading;
	
	@FindBy(xpath = "(//input[@name='option[218]'])[1]")
	WebElement chooseSizeRadioBtn;
	
	@FindBy(xpath = "(//input[@value='10'])[1]")
	WebElement checkBox;
	
	@FindBy(xpath = "(//select[@id='input-option217'])[1]")
	WebElement selectColor;
	
	@FindBy(xpath = "(//textarea[@id='input-option209'])[1]")
	WebElement textArea;
	
	@FindBy(xpath = "(//button[normalize-space()='Upload File'])[1]")
	WebElement uploadBtn;
	
	@FindBy(xpath = "(//button[@type='button'])[11]")
	WebElement iconDate;
	
	@FindBy(xpath = "(//th[@class='prev'][contains(text(),'‹')])[1]")
	WebElement prevArroW;
	
	@FindBy(xpath = "(//td[contains(text(),'10')])[2]")
	WebElement chooseDate;
	
	@FindBy(xpath = "(//input[@id='input-option221'])[1]")
	WebElement textTime;
	
	@FindBy(xpath = "(//input[@id='input-option220'])[1]")
	WebElement textDateAndTime;
	
	@FindBy(xpath = "(//input[@id='input-quantity'])[1]")
	WebElement textQty;
	
	@FindBy(xpath = "//a[normalize-space()='shopping cart']")
	WebElement lnkShoppingCart;
	
	@FindBy(xpath = "(//a[normalize-space()='Apple Cinema 30\"'])[1]")
	WebElement appleProduct;
	
	@FindBy(xpath = "//div[@id='tab-description']//p[1]")
	WebElement productDescription;
	
	public void setDateAndTime(String dateAndTime) {
		textDateAndTime.clear();
		textDateAndTime.sendKeys(dateAndTime);
	}
	
	public void setTime(String t) {
		textTime.clear();
		textTime.sendKeys(t);
	}
	
	public void setDate() {
		iconDate.click();
		for(int i=0;i<6;i++) {
			prevArroW.click();
		}
		chooseDate.click();
	}
	
	public void selectSize() {
		chooseSizeRadioBtn.click();
	}
	
	public void selectCheckBox() {
		checkBox.click();
	}
	
	public void setQuantity(String qty) {
		textQty.clear();
		textQty.sendKeys(qty);
	}
	
	public void selectProductColor(String value) {
		Select select = new Select(selectColor);
		select.selectByValue(value);
	}
	
	public void provideText(String text) {
		textArea.sendKeys(text);
	}
	
	@SuppressWarnings("deprecation")
	public void uploadFile() {
		uploadBtn.click();
		try {
			Runtime.getRuntime().exec("../OpencartV1/autoIt/FileUpload_Opencart.exe");
			wait.until(ExpectedConditions.alertIsPresent()).accept();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void clickFirstAddToCart() {
		btnFirstAddToCart.click();
	}
	
	public void clickSecondAddToCart() {
		btnSecondAddToCart.click();
	}
	
	public void openShoppingCart() {
		lnkShoppingCart.click();
	}
	
	public String msgHeading() {
		try {
			return (msgHeading.getText());
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public boolean isAppleProductShowing() {
		try {
			return appleProduct.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public String msgProcductDescription() {
		try {
			return (productDescription.getText());
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public void clickAppleProduct() {
		appleProduct.click();
	}

}
