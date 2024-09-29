package testcases_createAccountModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import wrappers.WebApplicationWrappers;

public class TC_01_CreateAccount extends WebApplicationWrappers {
	LoginPage loginpage;
	LandingPage LandingPage;
	CreateAccountPage createacpage;
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC01 - Create Account in Student Website ";
		testDescription = " Creating new  Account in Student Website ";
	}


	String password="Welcome@123";
	
	@Test
	public void createAccount() {
		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		LandingPage= new LandingPage(driver);
		createacpage= new CreateAccountPage(driver);
		
		LandingPage.clickSignUpButton();
		createacpage.enterEmailId(randomnames(3)+"@gmail.com");
		createacpage.enterUserName(randomnames(3));
		createacpage.enterPassword(password);
		createacpage.enterConfirmPassword(password);
		createacpage.clickTCCheckbox();
		createacpage.clickSubmitButton();
		createacpage.checkOTPverificationpage();
		
		
	}

}
