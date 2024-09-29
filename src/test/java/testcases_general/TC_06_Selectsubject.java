package testcases_general;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AllCoursePage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import wrappers.WebApplicationWrappers;

public class TC_06_Selectsubject extends WebApplicationWrappers {
	
	LoginPage loginpage;
	LandingPage landingpage;
	CreateAccountPage createacpage;
	HomePage homepage;
	AllCoursePage allcoursepage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC02 - Filter By subject and select explore course ";
		testDescription = " Select subject from dropdwon ";
	}


	@Test
	public void SelectSubject() throws InterruptedException {
		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		landingpage= new LandingPage(driver);
		createacpage= new CreateAccountPage(driver);
		homepage= new HomePage(driver);
		allcoursepage= new AllCoursePage(driver);
		
		landingpage.clickSignInButton();
		loginpage.enterEmailId("testuser6@gmail.com");
		loginpage.enterPassword("Welcome@123");
		loginpage.clickSubmitButton();
		homepage.clickAllCourseButton();
		
		Thread.sleep(5000);
		//createacpage.clickSubmitButton();
		
	}

}
