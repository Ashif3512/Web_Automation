package testcases_profilePageModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import wrappers.WebApplicationWrappers;

public class TC_03_ProfilePage extends WebApplicationWrappers {

	LoginPage loginpage;
	LandingPage LandingPage;
	CreateAccountPage createacpage;
	ProfilePage profilepage;
	
	String email="ash@gmail.com";
	String password="Welcome@123";
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC_03_ProfilePage-check imageupload and error  toast message ";
		testDescription = "check Edit profilepage dialogbox and error toast message  ";
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
		
		
		profilepage.checkProfilePagenavigation();
		profilepage.checkEditProfilenavigation();
	    profilepage.sendimage("C:\\Users\\Invcuser_45\\Desktop\\office\\8192px-Pizigani_1367_Chart_10MB.jpg");
        profilepage.checktoast("Image size should not be more than 10MB");
       
       
	}
}
