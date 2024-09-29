package testcases_cartPageModule;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CreateAccountPage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProfilePage;
import wrappers.WebApplicationWrappers;

public class TC_01_cartPage extends WebApplicationWrappers {

	LoginPage loginpage;
	LandingPage LandingPage;
	CreateAccountPage createacpage;
	ProfilePage profilepage;
	CartPage cartPage;
	
	//OTP has been sent to user rregistered Email-ID
	String email="auto0@gmail.com";//changed new user
	String password="Welcome@123";
	String date="12/04/2001";
	String mobileNumber="9876543211";
	String region="singapore";
	
	
	@BeforeClass
	public void startTestCase() {
		testCaseName = "TC_05_check OTP verification page  ";
		testDescription = "To check OTP verification  page after clicking on EDIT password link";
	}


	@Test
	public void Cartpage() throws Exception {
		

		invokeApp("Chrome",loadProp().getProperty("URL"));
		loginpage= new LoginPage(driver);
		LandingPage= new LandingPage(driver);
		createacpage= new CreateAccountPage(driver);
		profilepage=new ProfilePage(driver);
		cartPage= new CartPage(driver);
		
		//signins
		LandingPage.clickSignInButton();
		LandingPage.enterEmailsigin(email);
		LandingPage.enetrpasswordsignin(password);
		loginpage.clickSubmitButton();
		
		cartPage.verifyaddedcoursesandcountofcarticonwithcartpage();
		
		//verify subtotal values with courses value 
		//Add subtotal values and verify  total 
		cartPage.verifysubtotalwithcoursepriceandchecktotal();
		
		
		//verify clicking on courses taking to coursecontent page or not
		cartPage.verifycoursecontentpage();
		
		
		//verify payment screen 
		cartPage.verifypaymentscreen();
		//click on remove and check the courses decreasing or not 
		 cartPage.verifyremovebtn_placeholder_carticon();
		 
	}
}
	
