package testcases_general;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AllCoursePage;
import pages.AssessmentPage;
import pages.CourseContentPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyCoursePage;
import wrappers.WebApplicationWrappers;

public class TC_07_TakeChapterlevelAssessment extends WebApplicationWrappers {
	
	LoginPage loginpage;
	LandingPage landingpage;
	CreateAccountPage createacpage;
	HomePage homepage;
	AllCoursePage allcoursepage;
	MyCoursePage mycoursepage;
	AssessmentPage assessmentpage;
	CourseContentPage coursecontentpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC03 - Take Topic Level Assessement ";
		testDescription = " Take Topic Level Assessment ";
	}


	@Test
	public void SelectSubject() throws InterruptedException {
		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		landingpage= new LandingPage(driver);
		createacpage= new CreateAccountPage(driver);
		homepage= new HomePage(driver);
		allcoursepage= new AllCoursePage(driver);
		assessmentpage= new AssessmentPage(driver);
		mycoursepage= new MyCoursePage(driver);
		coursecontentpage= new CourseContentPage(driver);
		
		landingpage.clickSignInButton();
		loginpage.enterEmailId("testuser6@gmail.com");
		loginpage.enterPassword("Welcome@123");
		loginpage.clickSubmitButton();
		homepage.clickMyCourseButton();
		mycoursepage.clickGotoCourseButton(1);
		Thread.sleep(1000);
		coursecontentpage.clickAssessmentButton();
		assessmentpage.enterFillQuestion("1");
		assessmentpage.clickSubmitButton();
		assessmentpage.enterFillQuestion("1");
		assessmentpage.clickSubmitButton();
		assessmentpage.clickReadytoSubmitButton();
		assessmentpage.clickPopUpCheckBox();
		assessmentpage.clickPopUpSubmitButton();
		Thread.sleep(2000);
		assessmentpage.VerifyPercentage("18%");
		assessmentpage.clickOkayButton();
		
		
		Thread.sleep(5000);
		
	}

}

