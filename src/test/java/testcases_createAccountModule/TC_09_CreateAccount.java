package testcases_createAccountModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import wrappers.WebApplicationWrappers;

public class TC_09_CreateAccount extends WebApplicationWrappers {

	LoginPage loginpage;
	LandingPage LandingPage;
	CreateAccountPage createacpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC09 - Checking nointernet page visibility";
		testDescription = "After entering all inputs turned off the internet and click submit button and check for No internet connection page ";
	}


	@Test
	public void createAccount() throws Exception {
		

		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		LandingPage= new LandingPage(driver);
		createacpage= new CreateAccountPage(driver);

		LandingPage.clickSignUpButton();
		createacpage.enterEmailId(randomnames(4)+"@gmail.com");
		createacpage.enterUserName(randomnames(4));
		createacpage.enterPassword("Welcome@123");
		createacpage.clickpasswordeyeicon();
		createacpage.enterConfirmPassword("Welcome@123");
		createacpage.clickConfrimPasswordeyeicon();
		createacpage.clickTCCheckbox();
		createacpage.disablewifi();
		createacpage.clickSubmitButton();
        createacpage.nointernetpage();
        createacpage.enablewifi();
		
	}
}
