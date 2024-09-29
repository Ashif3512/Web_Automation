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

public class TC_05_Chapter_Incomplete_Assessment extends WebApplicationWrappers {
	LoginPage loginpage;
	HomePage homepage;
	CreateAccountPage createacpage;
	CourseContentPage coursecontentpage;
	MyCoursePage mycoursepage;
	AssessmentPage assessmentpage;
	LandingPage landingpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC05 - Chapter Level Assessment  - In complete Assessment ";
		testDescription = " Go to Assessment Page and Check user able to submit incomplete Assessment ";
	}


	@Test
	public void chapterIncompleteAssessment() throws InterruptedException {
		invokeApp("chrome",loadProp().getProperty("URL"));
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
		Thread.sleep(3000);
		coursecontentpage.clickChapterTitle("2");
		coursecontentpage.clickChatpterAssessmentButton();
		coursecontentpage.clickStartExam();
		assessmentpage.enterMcqOption("1");
		assessmentpage.clickMCQSubmitButton();
		
		assessmentpage.clickoverAllSubmitButton();
		assessmentpage.clickCheckBox();
		//assessmentpage.clickReadytoSubmitButton();
		
		//assessmentpage.checkResult("PASS");
		//assessmentpage.clickOkayButton();
		driver.navigate().back();
		
		coursecontentpage.verifyCourseContentPage();
	}

}
