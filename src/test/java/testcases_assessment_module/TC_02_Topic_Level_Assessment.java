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

public class TC_02_Topic_Level_Assessment extends WebApplicationWrappers {
	LoginPage loginpage;
	HomePage homepage;
	CreateAccountPage createacpage;
	CourseContentPage coursecontentpage;
	MyCoursePage mycoursepage;
	AssessmentPage assessmentpage;
	LandingPage landingpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC02 - Check User able to take on Topic level Assessment";
		testDescription = " Go to Assessment Page and User to take on Topic level Assessment";
	}


	@Test
	public void topicLevelAssessment() throws InterruptedException {
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
		//coursecontentpage.clickChaptertitle("1");
		Thread.sleep(2000);
		coursecontentpage.clickTopicAssessmentButton();
		assessmentpage.enterFillQuestion("1");
		assessmentpage.clickSubmitButton();
		
		assessmentpage.enterFillQuestion("1");
		assessmentpage.clickSubmitButton();
		
		assessmentpage.enterMcqOption("1");
		assessmentpage.clickMCQSubmitButton();
		
		assessmentpage.enterMcqOption("1");
		assessmentpage.clickMCQSubmitButton();
		
		assessmentpage.enterMcqOption("1");
		assessmentpage.clickMCQSubmitButton();
		
		assessmentpage.enterFillQuestion("1");
		assessmentpage.clickSubmitButton();	
		
		assessmentpage.clickoverAllSubmitButton();
		assessmentpage.clickCheckBox();
		assessmentpage.clickReadytoSubmitButton();
		
		assessmentpage.checkResult("Pass");
		assessmentpage.clickOkayButton();
		
		coursecontentpage.verifyCourseContentPage();
	}

}
