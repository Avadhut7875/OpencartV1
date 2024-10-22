package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import testBase.BaseClass;

public class TC008_SearchProductTest extends BaseClass {

	@Test
	public void verify_searchProduct() {
		logger.info("***** Starting TC008_SearchProductTest Successfully *****");

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
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("***** Finished TC008_SearchProductTest Successfully *****");
	}
}
