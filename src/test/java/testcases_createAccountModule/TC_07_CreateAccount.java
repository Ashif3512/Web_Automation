package testcases_createAccountModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import wrappers.WebApplicationWrappers;

public class TC_07_CreateAccount extends WebApplicationWrappers{

	LoginPage loginpage;
	LandingPage LandingPage;
	CreateAccountPage createacpage;
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC06 - Checking error toast of Confirm password field ";
		testDescription = "Checking error toast of Confirm password field in Create Account page";
	}


	@Test
	public void createAccount() throws Exception {
		

		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		LandingPage= new LandingPage(driver);
		createacpage= new CreateAccountPage(driver);
		//without entering characters check confirm password field error message
		LandingPage.clickSignUpButton();
		createacpage.enterEmailId("ash@gmail.com");
		createacpage.enterUserName("Ash");
		createacpage.enterPassword("Welcome@123");
		createacpage.enterConfirmPassword("Welcome@123");
		createacpage.clickSubmitButton();
		createacpage.checkTCerrmsg();
		
		
	}
}
