package testcases_myCoursePageModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CourseContentPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyCoursePage;
import pages.ProfilePage;
import wrappers.WebApplicationWrappers;

public class TC_03_Course_Content_Page extends WebApplicationWrappers {

	LoginPage loginpage;
	HomePage homepage;
	LandingPage LandingPage;
	CourseContentPage coursecontentpage;
	MyCoursePage mycoursepage;
	LandingPage landingpage;
	
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC_04 - Check Course Content Page contents   ";
		testDescription = " Check contents of Course content page ";
	}


	@Test
	public void Mycoursepage() throws Exception {
		

		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		LandingPage= new LandingPage(driver);
		coursecontentpage= new CourseContentPage(driver);
		homepage= new HomePage(driver);
		mycoursepage= new MyCoursePage(driver);
		landingpage = new LandingPage(driver);
		
		
		landingpage.clickSignInButton();
		loginpage.enterEmailId("testuser6@gmail.com");
		loginpage.enterPassword("Welcome@124");
		loginpage.clickSubmitButton();
		homepage.clickMyCourseButton();
		mycoursepage.clickGotoCourseButton(1);
	
		coursecontentpage.checkvideosCount("5");
		coursecontentpage.checkAssessmentCount("9");
		coursecontentpage.playTopicVideo();
		//coursecontentpage.clickChaptertitle("1");
		Thread.sleep(2000);
				
	}
}
