package testcases_profilePageModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import wrappers.WebApplicationWrappers;

public class TC_02_ProfilePage extends WebApplicationWrappers {

	LoginPage loginpage;
	LandingPage LandingPage;
	CreateAccountPage createacpage;
	ProfilePage profilepage;
	
	
	String email="ash@gmail.com";
	String password="Welcome@123";
	String DOBplaceholder,Mobilenumberplacceholder,Regionplaceholder;
	{
	DOBplaceholder="Your date of birth";
	Mobilenumberplacceholder="Your mobile number";
	Regionplaceholder="Your region";
	}
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC_02_ProfilePage-Placeholders and erorr message check ";
		testDescription = "check profilepage placeholders and error message check  ";
	}

//need to do
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
		profilepage.checkProfilePagenavigation();
		profilepage.checkEditProfilenavigation();
		profilepage.clearandsavefield();
		profilepage.checkDOBerrmessage1();
		profilepage.checkMobilenoErrmsg1();
		profilepage.checkRegionerrmsg1();
		profilepage.checknamefieldallerrmsg();
		profilepage.checkmobilenumberfieldallerrmsg();
		profilepage.checkRegionfieldallerrmsg();
		
	}
}
