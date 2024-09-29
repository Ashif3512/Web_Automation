package testcases_general;

import java.io.FileNotFoundException;
import java.io.IOException;
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


public class TC_05_CheckAssessmentCompleted extends WebApplicationWrappers {
	LoginPage loginpage;
	LandingPage landingpage;
	HomePage homepage;
	CreateAccountPage createacpage;
	CourseContentPage coursecontentpage;
	MyCoursePage mycoursepage;
	AssessmentPage assessmentpage;
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = " TC05 - Check User completed Assessment ";
		testDescription = " Check User completed Assessment ";
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
		//coursecontentpage.clickChaptertitle("1");
		Thread.sleep(2000);
		
		coursecontentpage.clickChatpterAssessmentButton();
		coursecontentpage.clickStartExam();
	
		
		coursecontentpage.checkAssessmentCompletedToast();
		Thread.sleep(10000);
	}

}
