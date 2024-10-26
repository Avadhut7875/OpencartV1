package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC010_AddMultipleItemsToCartTest extends BaseClass {

	@Test
	public void verify_addMultipleItemsToCart() {
		logger.info("***** Starting TC010_AddMultipleItemsToCartTest Successfully *****");

		try {
			HomePage hp = new HomePage(driver);

			// Adding first item to the cart
			Thread.sleep(1000);
			logger.info("searching for first item...");
			hp.searchItem(p.getProperty("item"));
			Thread.sleep(1000);
			hp.clickSearchBtn();
			logger.info("clicked on search button for first item...");

			SearchResultPage sp = new SearchResultPage(driver);
			Thread.sleep(1000);
			sp.clickFirstAddToCart();
			logger.info("clicked on add to cart button for first item...");

			// Adding second item to the cart
			logger.info("searching for second item...");
			Thread.sleep(1000);
			hp.clearSearchBar();
			Thread.sleep(1000);
			hp.searchItem(p.getProperty("item3"));
			hp.clickSearchBtn();
			Thread.sleep(1000);
			logger.info("clicked on search button for second item...");
			sp.clickFirstAddToCart();
			Thread.sleep(1000);
			logger.info("clicked on add to cart button for second item...");

			// Verifying multiple items are added to cart
			sp.openShoppingCart();
			Thread.sleep(1000);
			ShoppingCartPage cp = new ShoppingCartPage(driver);

			int itemCount = cp.getItemCount();
			System.out.println(itemCount);
			logger.info("validating multiple items are added to the cart...");

			Assert.assertEquals(itemCount, 2, "The number of items in the cart is not correct!");

		} catch (Exception e) {
			Assert.fail("Exception occurred: " + e.getMessage());
		}

		logger.info("***** Finished TC017_AddMultipleItemsToCartTest *****");
	}
}
