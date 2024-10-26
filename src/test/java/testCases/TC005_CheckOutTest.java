package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC005_CheckOutTest extends BaseClass {

	@Test
	public void verify_checkOutTest() {

		logger.info("***** Starting TC005_CheckOutTest Successfully  *****");

		try {
			HomePage hp = new HomePage(driver);
			logger.info("searching for item...");
			hp.searchItem(p.getProperty("item2"));
			hp.clickSearchBtn();
			logger.info("clicked on search button...");

			SearchResultPage sp = new SearchResultPage(driver);
			sp.clickFirstAddToCart();
			
			Thread.sleep(1000);
			logger.info("selecting size...");
			sp.selectSize();
			Thread.sleep(1000);
			logger.info("selecting checkBox...");
			sp.selectCheckBox();
			Thread.sleep(1000);
			logger.info("selecting product color...");
			sp.selectProductColor("4");
			Thread.sleep(1000);
			logger.info("providing Text...");
			sp.provideText("this is for testing purpose");
			Thread.sleep(1000);
			logger.info("uploading file...");
			sp.uploadFile();
			Thread.sleep(3000);
			logger.info("setting Date...");
			sp.setDate();
			Thread.sleep(1000);
			logger.info("setting time...");
			sp.setTime("10.30");
			Thread.sleep(1000);
			logger.info("setting both date and time");
			sp.setDateAndTime("2011-02-20 22:25");
			Thread.sleep(1000);
			logger.info("setting Quantity...");
			sp.setQuantity("3");
			Thread.sleep(1000);
			logger.info("clicking on Main Add to cart Button...");
			sp.clickSecondAddToCart();
			Thread.sleep(2000);

			String msg = sp.msgHeading();
			// System.out.println(msg);

			logger.info("validating expected msg...");
			Thread.sleep(2000);

			if (msg.contains("Success: You have added")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed..");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}
			Thread.sleep(1000);
			logger.info("opening Shopping Cart...");
			sp.openShoppingCart();
			
			ShoppingCartPage sc= new ShoppingCartPage(driver);
			
			Thread.sleep(1000);
			logger.info("Proving Shipping Details...");
			sc.setShippingDetails("Angola", "129", "21456");
			Thread.sleep(1000);
			logger.info("clicking on get Quote Button...");
			sc.getQuote();
			Thread.sleep(1000);
			logger.info("selecting shipping method...");
			sc.setShippingMethod();
			Thread.sleep(1000);
			logger.info("clicking on apply shipping Button...");
			sc.applyShipping();
			Thread.sleep(1000);
			
			logger.info("validating shipping msg Success");
			if(sc.shippingMsg().contains("Success: Your shipping")) {
				Assert.assertTrue(true);
			}else {
				logger.error("Test failed..");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}
			
			Thread.sleep(1000);
			logger.info("clicking on final Checkout Button...");
			sc.checkOut();

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}
		
		logger.info("***** Finished TC005_CheckOutTest Successfully  *****");

	}
}
