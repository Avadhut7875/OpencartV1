package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import testBase.BaseClass;

public class TC004_AddToCartTest extends BaseClass {

	@Test
	public void verify_AddToCart() {

		logger.info("***** Starting TC004_AddToCartTest *****");

		try {
			HomePage hp = new HomePage(driver);
			logger.info("searching for item...");
			hp.searchItem(p.getProperty("item"));
			hp.clickSearchBtn();
			logger.info("clicked on search button...");

			SearchResultPage sp = new SearchResultPage(driver);
			sp.clickAddToCart();
			logger.info("clicked on add to cart button...");

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
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("***** Finished TC004_AddToCartTest *****");
	}
}
