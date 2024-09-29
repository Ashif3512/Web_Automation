package testcases_landingPageModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AllCoursePage;
import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import wrappers.WebApplicationWrappers;

public class TC_02_LandingPage extends WebApplicationWrappers{

	LoginPage loginpage;
	LandingPage LandingPage;
	CreateAccountPage createacpage;
	AllCoursePage allcoursepage;
	
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
		allcoursepage= new AllCoursePage(driver);
		
		
		//sigining in to website
		LandingPage.clickSignInButton();
		LandingPage.enterEmailsigin("ash@gmail.com");
		LandingPage.enetrpasswordsignin("Welcome@123");
		loginpage.clickSubmitButton();
		
		
       //clicking in explore course btn navigating to All course  page 
	   //navigating back to home page
		LandingPage.clickexplorecourse();
		allcoursepage.verifySelectsubjecttext();
		LandingPage.navigateback();
		LandingPage.checkexplorecourse();//explore course text check in LandingPage
		
		//clicking in see all courses link and navigate to All course page
		//navigating back to home page
		
		LandingPage.clickseeallcourselinkhomepage();
		LandingPage.navigateback();
		LandingPage.checkexplorecourse();
		
		//clicking in explore course btn navigating to All course  page 
		//navigating back to home page
	    LandingPage.clickonexplorebuttoncheckpagenavigation();
	    LandingPage.navigateback();
		LandingPage.checkexplorecourse();
	}
}
