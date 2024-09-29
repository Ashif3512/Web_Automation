package testcases_profilePageModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import wrappers.WebApplicationWrappers;

public class TC_05_ProfilePage extends WebApplicationWrappers {

	LoginPage loginpage;
	LandingPage LandingPage;
	CreateAccountPage createacpage;
	ProfilePage profilepage;
	
	//OTP has been sent to user rregistered Email-ID
	String email="ash@gmail.com";
	String password="Welcome@123";
	String date="12/04/2001";
	String mobileNumber="9876543211";
	String region="singapore";
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC_05_check OTP verification page  ";
		testDescription = "To check OTP verification  page after clicking on EDIT password link";
	}


	@Test
	public void Profilepage() throws Exception {
		

		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		LandingPage= new LandingPage(driver);
		createacpage= new CreateAccountPage(driver);
		profilepage=new ProfilePage(driver);
		
		//signin
		LandingPage.clickSignInButton();
		LandingPage.enterEmailsigin(email);
		LandingPage.enetrpasswordsignin(password);
		loginpage.clickSubmitButton();
		
		//entering into EDIT PASSWORD page and check the TOAST message for OTP
		profilepage.checkProfilePagenavigation();
		profilepage.clickEditPasswordProfilepage();
		profilepage.checktoast("OTP has been sent to user registered Email-Id");
        profilepage.checkOTPverificationpage();
        profilepage.checkOTPfieldallerrmsg();
        profilepage.checkcorrectotpchecknavigation();
        //check the error messages of CHANGE PASSWORD page 
        profilepage.checkChangePasswordpageerrormessage();
        
        //check the page navigation after resetting the password.
		profilepage.Resetnewpassword();
	}
}
