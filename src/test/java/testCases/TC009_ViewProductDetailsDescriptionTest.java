package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import testBase.BaseClass;

public class TC009_ViewProductDetailsDescriptionTest extends BaseClass {
	
	@Test
	public void verify_productDetails() {
		logger.info("***** Starting TC009_ViewProductDetailsDescriptionTest Successfully *****");
		try {
			HomePage hp = new HomePage(driver);
			logger.info("typing product name in search bar...");
			hp.searchItem(p.getProperty("item2"));
			logger.info("clicking on search button...");
			hp.clickSearchBtn();

			SearchResultPage sp = new SearchResultPage(driver);
			Thread.sleep(1000);
			logger.info("verifying product is visible or not...");
			boolean res = sp.isAppleProductShowing();

			if (res == true) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed..");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}
			
			logger.info("clicking on product to get details...");
			sp.clickAppleProduct();
			Thread.sleep(1000);
			String desc = sp.msgProcductDescription();
			logger.info("verifying details are visible or not...");
			
			if (desc.contains(p.getProperty("appleProductDescription"))) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed..");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("***** Starting TC009_ViewProductDetailsDescriptionTest Successfully *****");
	}
}
