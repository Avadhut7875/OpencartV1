package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC006_PasswordReset extends BaseClass {

	@Test
	public void verify_PasswordReset() {

		logger.info("***** Starting TC006_PasswordReset Successfully *****");
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

			logger.info("clicking on forgot Password link...");
			macc.clickForgotPassword();
			logger.info("setting up new password...");
			macc.setNewPassword(p.getProperty("newPassword"));
			logger.info("seeting up confirm password");
			macc.setNewConfirmPassword(p.getProperty("newPassword"));
			logger.info("clicking on continue button...");
			macc.clickContinue();

			logger.info("verifying password is changed or not...");
			String msg = macc.isPasswordChanged();

			if (msg.contains("Success: Your password")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed..");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("***** Finished TC006_PasswordReset Successfully *****");
	}
}
