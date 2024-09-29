package testcases_myCoursePageModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.MyCoursePage;
import pages.ProfilePage;
import wrappers.WebApplicationWrappers;

public class TC_01_MyCoursePage extends WebApplicationWrappers {

	LoginPage loginpage;
	LandingPage LandingPage;
	CreateAccountPage createacpage;
	ProfilePage profilepage;
	CartPage cartPage;
	MyCoursePage myCoursePage;
	
	//OTP has been sent to user rregistered Email-ID
	String email="ash@gmail.com";//changed new user
	String password="Welcome@123";
	String date="12/04/2001";
	String mobileNumber="9876543211";
	String region="singapore";
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC_01_check Mycourses page and cart page courses   ";
		testDescription = "To check my courses and cart page courses are not same";
	}


	@Test
	public void Mycoursepage() throws Exception {
		

		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		LandingPage= new LandingPage(driver);
		createacpage= new CreateAccountPage(driver);
		profilepage=new ProfilePage(driver);
		cartPage= new CartPage(driver);
		myCoursePage= new MyCoursePage(driver);
		
		
		//signins
		LandingPage.clickSignInButton();
		LandingPage.enterEmailsigin(email);
		LandingPage.enetrpasswordsignin(password);
		loginpage.clickSubmitButton();
		
		//verify courses completion status with total vids,and completed vids count
		//verify videos count with course content page count 
		//verify go to course button 
		myCoursePage.verifymycoursesnotequalscartpagecourses();
		
	}
}
