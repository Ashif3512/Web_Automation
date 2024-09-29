package testcases_signInPageModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.SignInPage;
import wrappers.WebApplicationWrappers;

public class TC_03_SignInpage extends WebApplicationWrappers {

	LoginPage loginpage;
	LandingPage LandingPage;
	CreateAccountPage createacpage;
	ProfilePage profilepage;
	CartPage cartPage;
	SignInPage signinpage;
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC_03_check signin OTPverification page  ";
		testDescription = "To check OTP verification  page and its all fields and error messages";
	}


	@Test
	public void SignInpage() throws Exception {
		

		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		LandingPage= new LandingPage(driver);
		createacpage= new CreateAccountPage(driver);
		profilepage=new ProfilePage(driver);
		cartPage= new CartPage(driver);
		signinpage= new SignInPage(driver);
		
		signinpage.checkOTPverificationpage();
	}
}
