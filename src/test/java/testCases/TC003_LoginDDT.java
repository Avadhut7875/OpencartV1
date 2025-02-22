package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven") // getting DataProvider
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException {

		logger.info("***** Starting TC003_LoginDDT *****");
		
		try {
			
		// HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		// Login
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLoginBtn();

		// MyAccount
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();

		/*
		 * Data is valid - login success - test pass - logout 
		 *                 login fail - test fail
		 * 
		 * Data is Invalid - login success - test fail - logout 
		 *                   login fail - test pass
		 * 
		 */

		if (exp.equalsIgnoreCase("Valid")) {
			if (targetPage == true) {
				
				Assert.assertTrue(true);
				macc.clickLogout();
				
			} else {
				Assert.assertTrue(false);
			}
		}
		
		if (exp.equalsIgnoreCase("Invalid")) {
			if(targetPage==true) {
				
				macc.clickLogout();
				Assert.assertTrue(false);
				
			}else {
				Assert.assertTrue(true);
			}
		 }
		
		} catch (Exception e) {
			Assert.fail();
		}
		Thread.sleep(2000);
		logger.info("***** Finished TC003_LoginDDT *****");

	}

}
