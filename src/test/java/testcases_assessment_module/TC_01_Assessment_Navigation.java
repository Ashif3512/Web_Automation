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


public class TC_01_Assessment_Navigation extends WebApplicationWrappers {
	LoginPage loginpage;
	HomePage homepage;
	CreateAccountPage createacpage;
	CourseContentPage coursecontentpage;
	MyCoursePage mycoursepage;
	AssessmentPage assessmentpage;
	LandingPage landingpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC01 - Assessment Page navigation check ";
		testDescription = " Go to Assessment Page and Check all navigation are working fine ";
	}


	@Test
	public void navigation() throws InterruptedException {
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
		assessmentpage.clickNextButton();
		assessmentpage.validateQuestionAnswered(1);
		assessmentpage.selectQuestionNumber(1);
		Thread.sleep(3000);
		assessmentpage.enterFillQuestion("1");
		assessmentpage.clickSubmitButton();
		Thread.sleep(2000);
		assessmentpage.validateQuestionAnswered(1);
		assessmentpage.selectQuestionNumber(5);
		driver.navigate().back();
		coursecontentpage.verifyCourseContentPage();
		Thread.sleep(1000);
	}

}
