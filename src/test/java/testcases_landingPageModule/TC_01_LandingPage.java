package testcases_landingPageModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import wrappers.WebApplicationWrappers;

public class TC_01_LandingPage extends WebApplicationWrappers{

	LoginPage loginpage;
	LandingPage LandingPage;
	CreateAccountPage createacpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC01-Check Landing page navigation to SignIn page ";
		testDescription = "To check the navigation from landing page to SignIn page";
	}


	@Test
	public void landingpage() throws Exception {
		

		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		LandingPage= new LandingPage(driver);
		createacpage= new CreateAccountPage(driver);
       //clicking in explore course btn and navigating back to home page before signin
		LandingPage.clickexplorecourse();
		LandingPage.verifySigintitle();
		LandingPage.navigateback();
		LandingPage.checkexplorecourse();
		//clicking in see all courses link and navigating back to home page before signin
		
		LandingPage.clickSeeallcourseslink();
		LandingPage.verifySigintitle();
		LandingPage.navigateback();
		LandingPage.checkexplorecourse();
		
		//clicking in explore button on course cards and navigating back to home page before signin
		
		LandingPage.clickExplorebutton();
		LandingPage.verifySigintitle();
		LandingPage.navigateback();
		LandingPage.checkexplorecourse();
		
		 
		
		
	}
}
