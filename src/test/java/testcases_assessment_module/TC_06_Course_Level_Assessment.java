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

public class TC_06_Course_Level_Assessment extends WebApplicationWrappers {
	LoginPage loginpage;
	HomePage homepage;
	CreateAccountPage createacpage;
	CourseContentPage coursecontentpage;
	MyCoursePage mycoursepage;
	AssessmentPage assessmentpage;
	LandingPage landingpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC06_ Take Course Level Assessment ";
		testDescription = " Check user is able to take up course level Assessment ";
	}


	@Test
	public void courseLevelAssessment() throws InterruptedException {
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
		assessmentpage.completeCourseAssessment();
		
		
	}

}
