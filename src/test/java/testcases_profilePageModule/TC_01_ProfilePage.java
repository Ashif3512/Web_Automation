package testcases_profilePageModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import wrappers.WebApplicationWrappers;

public class TC_01_ProfilePage extends WebApplicationWrappers{

	
	LoginPage loginpage;
	LandingPage LandingPage;
	CreateAccountPage createacpage;
	ProfilePage profilepage;
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC_01_ProfilePage-Navigation check ";
		testDescription = "check page navigation to profile page and edit profile page and back navigation ";
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
		LandingPage.enterEmailsigin("ash@gmail.com");
		LandingPage.enetrpasswordsignin("Welcome@123");
		loginpage.clickSubmitButton();
		
		
		profilepage.checkProfilePagenavigation();
		profilepage.checkEditProfilenavigation();
		profilepage.backnavigationtoProfilepage();
		profilepage.backnavigationtohomepage();
		
		
		
		
	}
}
