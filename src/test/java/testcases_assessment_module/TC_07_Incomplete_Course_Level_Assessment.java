package testcases_assessment_module;

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

public class TC_07_Incomplete_Course_Level_Assessment extends WebApplicationWrappers {
	LoginPage loginpage;
	HomePage homepage;
	CreateAccountPage createacpage;
	CourseContentPage coursecontentpage;
	MyCoursePage mycoursepage;
	AssessmentPage assessmentpage;
	LandingPage landingpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC06_ Check User able to submit Course Level Incomplete Assessment ";
		testDescription = " Check user is able to submit Incomplete Course Level Assessment ";
	}


	@Test
	public void inCompleteCourseAssessment() throws InterruptedException {
		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		homepage= new HomePage(driver);
		createacpage= new CreateAccountPage(driver);
		coursecontentpage= new CourseContentPage(driver);
		mycoursepage=new MyCoursePage(driver);
		assessmentpage=new AssessmentPage(driver);
		landingpage = new LandingPage(driver);
		
		landingpage.clickSignInButton();
		loginpage.enterEmailId("testuser5@gmail.com");
		loginpage.enterPassword("Welcome@123");
		loginpage.clickSubmitButton();
		homepage.clickMyCourseButton();
		mycoursepage.clickGotoCourseButton(2);
		Thread.sleep(3000);
		coursecontentpage.clickCourseAssessmentButton();
		coursecontentpage.clickStartExam();
		assessmentpage.enterFillQuestion("1");
		assessmentpage.clickSubmitButton();
		assessmentpage.enterFillQuestion("1");
		assessmentpage.clickSubmitButton();
		assessmentpage.enterMcqOption("1");
		assessmentpage.clickMCQSubmitButton();
		assessmentpage.enterMcqOption("1");
		assessmentpage.clickMCQSubmitButton();
		assessmentpage.enterFillQuestion("1");
		assessmentpage.clickSubmitButton();
		
		assessmentpage.clickoverAllSubmitButton();
		assessmentpage.clickCheckBox();
		//assessmentpage.clickReadytoSubmitButton();
		//assessmentpage.clickOkayButton();
		// TODO Auto-generated method stub
	}

}
