package testcases_allcoursemodule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AllCoursePage;
import pages.CartPage;
import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import wrappers.WebApplicationWrappers;

public class TC_01_AllcoursePage extends WebApplicationWrappers{

		LoginPage loginpage;
		LandingPage LandingPage;
		CreateAccountPage createacpage;
		ProfilePage profilepage;
		CartPage cartPage;
		AllCoursePage allcoursepage;
		
		//OTP has been sent to user rregistered Email-ID
		String email="auto0@gmail.com";//changed new user
		String password="Welcome@123";
		String date="12/04/2001";
		String mobileNumber="9876543211";
		String region="singapore";
		
		
		@BeforeClass
		public void startTestCase() {
			testCaseName = "TC_01_Allcourse page see more button check ";
			testDescription = "To check the See more button and course counts in All course page ,To check course cards listed in Allcourse page and selected dropdown page cards are matching or not , To check the Search box and total course found count";
		}


		@Test
		public void AllcoursePage() throws Exception {
			

			invokeApp("Chrome",loadProp().getProperty("URL"));
			loginpage= new LoginPage(driver);
			LandingPage= new LandingPage(driver);
			createacpage= new CreateAccountPage(driver);
			profilepage=new ProfilePage(driver);
			cartPage= new CartPage(driver);
			allcoursepage=new AllCoursePage(driver);
			
			//signins
			LandingPage.clickSignInButton();
			LandingPage.enterEmailsigin(email);
			LandingPage.enetrpasswordsignin(password);
			loginpage.clickSubmitButton();
			
			allcoursepage.verifyCourseCountsAcrossContainers();//it will verify course count and also see all courses button
			//It will compare the courses count displaying in all coursepage and Dropdown courses
			//It will verify the dropdown functionality ,
			allcoursepage.verifyDropdownAndItsCourses();
			allcoursepage.checksearchbox();
			
		}
}


