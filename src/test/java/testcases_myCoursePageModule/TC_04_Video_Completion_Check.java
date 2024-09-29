package testcases_myCoursePageModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CourseContentPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyCoursePage;
import wrappers.WebApplicationWrappers;

public class TC_04_Video_Completion_Check extends WebApplicationWrappers {

	LoginPage loginpage;
	HomePage homepage;
	LandingPage LandingPage;
	CourseContentPage coursecontentpage;
	MyCoursePage mycoursepage;
	LandingPage landingpage;
	
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC_05 - Check user able to play and Complete Topic videos  ";
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
		loginpage.enterPassword("Welcome@123");
		loginpage.clickSubmitButton();
		homepage.clickMyCourseButton();
		mycoursepage.clickGotoCourseButton(1);
		Thread.sleep(3000);
		coursecontentpage.clickChapterTitle("2");
		coursecontentpage.clickTopictitle("1");
		coursecontentpage.clickChapterTitle("1");
		coursecontentpage.clickTopictitle("1");
		coursecontentpage.playTopicVideo();
		coursecontentpage.completeVideoandVerifyGreenTick();
		//coursecontentpage.clickChaptertitle("1");
		
		Thread.sleep(2000);
				
	}
}
