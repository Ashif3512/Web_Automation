package testcases_general;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AssessmentPage;
import pages.CourseContentPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyCoursePage;
import wrappers.WebApplicationWrappers;


public class TC_03_CompleteVideo extends WebApplicationWrappers {
	LoginPage loginpage;
	HomePage homepage;
	CreateAccountPage createacpage;
	CourseContentPage coursecontentpage;
	MyCoursePage mycoursepage;
	AssessmentPage assessmentpage;
	LandingPage landingpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC03 - Goto My Course and Complete Video ";
		testDescription = " Goto my Course and Takeup chapter 1 Assessment ";
	}


	@Test
	public void createAccount() throws InterruptedException {
		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		homepage= new HomePage(driver);
		createacpage= new CreateAccountPage(driver);
		coursecontentpage= new CourseContentPage(driver);
		mycoursepage=new MyCoursePage(driver);
		assessmentpage=new AssessmentPage(driver);
		landingpage = new LandingPage(driver);
		
		landingpage.clickSignInButton();
		loginpage.enterEmailId("testuser6@gmail.com");
		loginpage.enterPassword("Welcome@123");
		loginpage.clickSubmitButton();
		homepage.clickMyCourseButton();
		mycoursepage.clickGotoCourseButton(1);
		Thread.sleep(4000);
		//coursecontentpage.clickChaptertitle("2");
		coursecontentpage.clickTopictitle("2");
		coursecontentpage.clickPlayVideo();
		coursecontentpage.completeVideoandVerifyGreenTick();
		Thread.sleep(10000);
	}

}
