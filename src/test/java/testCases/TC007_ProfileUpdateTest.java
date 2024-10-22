package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EditInfoPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC007_ProfileUpdateTest extends BaseClass {

	@Test
	public void verify_updateProfile() {

		logger.info("***** Starting TC007_ProfileUpdateTest Successfully *****");

		try {
			HomePage hp = new HomePage(driver);
			logger.info("clicking on myAccount link...");
			hp.clickMyAccount();
			logger.info("clicking on login link...");
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			logger.info("providing email...");
			lp.setEmail(p.getProperty("email"));
			logger.info("providing password...");
			lp.setPassword(p.getProperty("password"));
			logger.info("clicking on login button...");
			lp.clickLoginBtn();

			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();

			logger.info("Validating Successful Login.....");
			// Assert.assertEquals(targetPage, true, "Login Failed");
			Assert.assertTrue(targetPage);

			logger.info("clicking on edit Account Info link...");

			macc.clickEditAccountInfo();

			EditInfoPage ep = new EditInfoPage(driver);
			logger.info("updating last name...");
			ep.setLastName(p.getProperty("lastName"));
			logger.info("clicking on continue button...");
			ep.clickContinueButton();

			String msgUpdatedProfile = macc.isProfileUpdated();

			logger.info("validating success message...");
			if (msgUpdatedProfile.contains("Success: Your account")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed..");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("***** Finished TC007_ProfileUpdateTest Successfully *****");
	}

}
