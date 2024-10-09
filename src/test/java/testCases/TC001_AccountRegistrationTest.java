package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrartionPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"Regression","Master"})
	public void verify_account_registration() {

		logger.info("***** Starting TC001_AccountRegistrationTest *****");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link");
			hp.clickRegister();
			logger.info("Clicked on Register Link");

			AccountRegistrartionPage regpage = new AccountRegistrartionPage(driver);

			logger.info("Proving Customer Details.......");
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString() + "@gmail.com");
			regpage.setTelephone(randomNumber());

			String pwd = randomAlphaNumeric();

			regpage.setPassword(pwd);
			regpage.setConfirmPassword(pwd);
			regpage.setPrivacyPolicy();
			regpage.clickContinue();

			logger.info("Validating expected message...");
			String confmsg = regpage.getConfirmationMsg();

			if (confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed..");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}
			// Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");

		} catch (Exception e) {

			Assert.fail();
		}

		logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}

}
