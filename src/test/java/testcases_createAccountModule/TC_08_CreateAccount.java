package testcases_createAccountModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import wrappers.WebApplicationWrappers;

public class TC_08_CreateAccount extends WebApplicationWrappers {

	LoginPage loginpage;
	LandingPage LandingPage;
	CreateAccountPage createacpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC08 -create account and  Navigate to OTP page";
		testDescription = "Enter all the inputs in required fields and check page navigated to OTP page or not ";
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

		createacpage.clickSubmitButton();
		Thread.sleep(1000);
		createacpage.checkToast("OTP has been sent to user registered Email-Id");
	}
	

	
}
