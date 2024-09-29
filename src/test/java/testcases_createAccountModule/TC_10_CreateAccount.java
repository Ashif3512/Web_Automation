package testcases_createAccountModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import wrappers.WebApplicationWrappers;

public class TC_10_CreateAccount extends WebApplicationWrappers{

	LoginPage loginpage;
	LandingPage LandingPage;
	CreateAccountPage createacpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC10- check OTP verification  page ";
		testDescription = "To Check the OTP error message ,OTP toast,OTP textbox functions";
	}


	@Test
	public void createAccount() throws Exception {
		

		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		LandingPage= new LandingPage(driver);
		createacpage= new CreateAccountPage(driver);

		createacpage.CreateAccount();
		
		// error message check
		createacpage.checkOTPverificationpage();
		createacpage.enter5OTP();
		createacpage.clickOTPsubmit();
		createacpage.OTPerrtext("Please enter the valid OTP");
		createacpage.backtocreateacnt();
		createacpage.CreateAccount();
		createacpage.enterincorrect6OTP();
		createacpage.clickOTPsubmit();
		Thread.sleep(1000);
		createacpage.checkToast("Invalid OTP");
		createacpage.backtocreateacnt();
		createacpage.CreateAccount();
		createacpage.clickonresendbutton();
		Thread.sleep(1000);
		createacpage.checkToast("OTP has been sent to user registered Email-Id");
        createacpage.entercorrectOTPbox();
        createacpage.clickOTPsubmit();
        LandingPage.checkexplorecourse();
		
	}
}
