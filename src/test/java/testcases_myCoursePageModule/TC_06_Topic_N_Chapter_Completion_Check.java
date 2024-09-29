package testcases_myCoursePageModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CourseContentPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyCoursePage;
import wrappers.WebApplicationWrappers;

public class TC_06_Topic_N_Chapter_Completion_Check extends WebApplicationWrappers {

	LoginPage loginpage;
	HomePage homepage;
	LandingPage LandingPage;
	CourseContentPage coursecontentpage;
	MyCoursePage mycoursepage;
	LandingPage landingpage;
	
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC_06 - Complete topic and chapter level assessments and check greent tick  ";
		testDescription = " Complete topic and chapter level assessments and check greent tick ";
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
		loginpage.enterPassword("Welcome@123");
		loginpage.clickSubmitButton();
		homepage.clickMyCourseButton();
		mycoursepage.clickGotoCourseButton(1);
		coursecontentpage.clickPlayVideo();
		Thread.sleep(3000);
		coursecontentpage.completeVideoandVerifyGreenTick();
		coursecontentpage.clickTopictitle("2");
		coursecontentpage.clickPlayVideo();
		Thread.sleep(3000);
		coursecontentpage.completeVideoandVerifyGreenTick();
		coursecontentpage.clickChatpterAssessmentButton();
		coursecontentpage.clickStartExam();
		coursecontentpage.checkAssessmentCompletedToast();
		Thread.sleep(2000);
		coursecontentpage.checkChapterAssessmentVerifyGreenTick();
		Thread.sleep(3000);
	}
}
