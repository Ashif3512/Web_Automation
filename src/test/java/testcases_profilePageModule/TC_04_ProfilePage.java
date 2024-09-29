package testcases_profilePageModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import wrappers.WebApplicationWrappers;

public class TC_04_ProfilePage extends WebApplicationWrappers {

	LoginPage loginpage;
	LandingPage LandingPage;
	CreateAccountPage createacpage;
	ProfilePage profilepage;
	
	String email="ash@gmail.com";
	String password="Welcome@123";
	String date="12/04/2001";
	String mobileNumber="9876543211";
	String region="singapore";
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC_04_Provide Proper input and check the placeholder of ProfilePage ";
		testDescription = "Providing Proper input and check the placeholder of ProfilePage ";
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
		profilepage.sendimage("C:\\Users\\Invcuser_45\\Desktop\\office\\Pizigani_1367_Chart_10MB.jpg");
		
		//senddatein editprofilepage
		profilepage.clearDOBfield();
		profilepage.senddate(date);
		
		//sendmobilenumberin editprofilepage
		profilepage.clearMobileNumberfield();
		profilepage.sendMobilenumber(mobileNumber);
		
		//sendregionin editprofilepage
		profilepage.clearRegionfield();
		profilepage.sendRegion(region);
		
		//saving edit profilepage and check the saved datas are displaying properly in profilepage placeholders or not .
		profilepage.clickSaveEditprofilepage();
//		profilepage.particulartoastreaderlong("profileupdated.png", "profileupdated.png", "Profile updated successfully", "page navigated to Profilepage ",3000);
		profilepage.checktoast("Profile updated successfully");
		profilepage.checkProfilePagenavigation();
		profilepage.compareDOBplaceholder(date);
		profilepage.compareMobilenumberplaceholder(mobileNumber);
		profilepage.compareRegionplaceholder(region);
		
	}
}
