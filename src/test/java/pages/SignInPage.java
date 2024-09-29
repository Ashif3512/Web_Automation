package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import wrappers.WebApplicationWrappers;

public class SignInPage extends WebApplicationWrappers {

	static ExtentTest test;
	static ExtentReports report;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.jsExecutor = (JavascriptExecutor) driver;
	}

	@FindBy(xpath = "//div[contains(@class,'Header_Component_login_Text')]")
	private WebElement SignInbtn;

	@FindBy(xpath = "//input[@name='user_email']")
	private WebElement Emailtxtbox;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement Passwordtxtbox;

	@FindBy(xpath = "//div[contains(@class,'Login_signInButton')]")
	private WebElement Submit;

	@FindBy(xpath = "//div[contains(@class,'Login_signRegNav')]")
	private WebElement createAccount;

	@FindBy(xpath = "//div[contains(@class,'Login_forgetPassword')]")
	private WebElement forgetpasswordbtn;

	@FindBy(xpath = "//div[contains(text(),'Email is a required field')]")
	private WebElement emailerrtxt0;

	@FindBy(xpath = "//div[contains(text(),'Email cannot be empty')]")
	private WebElement emailerrtxt1;

	@FindBy(xpath = "//div[contains(text(),'Invalid email')]")
	private WebElement emailerrtxt2;

	@FindBy(xpath = "//div[contains(text(),'Password is a required field')]")
	private WebElement passworderrtxt0;

	@FindBy(xpath = "//div[contains(text(),'Password cannot be empty')]")
	private WebElement passworderrtxt1;

	@FindBy(xpath = "//input[contains(@class,'Login_fieldInput')]")
	private WebElement Forgetpassemailfield;

	@FindBy(xpath = "//div[contains(@class,'Login_signInButton')]")
	private WebElement generateOTP;

	@FindBy(xpath = "//div[contains(@class,'Login_formikErrorText')]")
	private WebElement Forgetpassemailerrtxt;

	@FindBy(xpath = "//div[contains(@class,'Landing_Screen_button_Text')]")
	private WebElement landingpageexplorecourse;

	@FindBy(xpath = "//*[@role='status']")
	private WebElement ToastMessage;
//	  
	@FindBy(xpath = "//div[contains(@class,'Login_signInText')]")
	private WebElement forgetpasswordTile;
//	  
	@FindBy(xpath = "//input[contains(@class,'Otp_otpInput')][1]")
	private WebElement OTPbox1;
//	  
	@FindBy(xpath = "//input[contains(@class,'Otp_otpInput')][2]")
	private WebElement OTPbox2;

	@FindBy(xpath = "//input[contains(@class,'Otp_otpInput')][3]")
	private WebElement OTPbox3;

	@FindBy(xpath = "//input[contains(@class,'Otp_otpInput')][4]")
	private WebElement OTPbox4;

	@FindBy(xpath = "//input[contains(@class,'Otp_otpInput')][5]")
	private WebElement OTPbox5;

	@FindBy(xpath = "//input[contains(@class,'Otp_otpInput')][6]")
	private WebElement OTPbox6;

	@FindBy(xpath = "//div[contains(@class,'Otp_signInButton')]")
	private WebElement verifiedandproceed;

	@FindBy(xpath = "//div[contains(@class,'Otp_signInButton')]")
	private WebElement resendOtp;

	@FindBy(xpath = "//div[contains(@class,'Otp_signInText')]")
	private WebElement OTPverificationttile;

	@FindBy(xpath = "//div[contains(@class,'Otp_otp_Error_Text')]")
	private WebElement OTPpageErrtxt;

	@FindBy(xpath = "//div[contains(@class,'Otp_resend_OTP')]")
	private WebElement OTPtimer;

	@FindBy(xpath = "//div[contains(@class,'Registation_signInText')]")
	private WebElement ChangePasswordtitle;

	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/input[1]")
	private WebElement Passwordfield_CPP;

	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/input[1]")
	private WebElement confirmpasswordfield_CPP;

	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/*[1]")
	private WebElement eyeiconpassword_CPP;

	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/*[1]")
	private WebElement eyeiconconfrimpassword_CPP;

	@FindBy(xpath = "//div[contains(@class,'Registation_signInButton')]")
	private WebElement Resetmypassword_CPP;

	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]")
	private WebElement passworderrtxt_CPP;

	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[2]")
	private WebElement confirmPasserrtxt_CPP;

	@FindBy(xpath = "//div[contains(@class,'Login_signInText')]")
	private WebElement Signintitle;

	String passerrmsg1, passerrmsg2, passerrmsg3, passerrmsg4, passerrmsg5, CPerrmsg1, CPerrmsg2, PasswordData;
	{
		passerrmsg1 = "Password is required";
		passerrmsg2 = "Password must have a capital letter";
		passerrmsg3 = "Password must have a small letter";
		passerrmsg4 = "Password must have a number";
		passerrmsg5 = "Password must have a special character";
		CPerrmsg1 = "Confirm password is required";
		CPerrmsg2 = "Passwords do not match";
		PasswordData = "Welcome@123";
	}

	String email = "auto0@gmail.com";
	String password = "Welcome@123";

	public void checkemailfield() {

		// navigate to signin page and check page title
		clickbyXpath(SignInbtn, "click on SignIn button ");
		verifyTitle("Sign in");

		// check placeholder
		attributevalue(Emailtxtbox, "placeholder", "Enter your email");

		// check error message without entering data
		clickbyXpath(Submit, "submit button");
		verifyTextContainsByXpath(emailerrtxt0, "Email is a required field","Error message ");

		// check error message entering only space
		enterValuebyXpath(Emailtxtbox, "To enter only space on Emailfield", "  ");
		clickbyXpath(Submit, "submit button");
		verifyTextContainsByXpath(emailerrtxt1, "Email cannot be empty","Error message ");

		// check error message entering only characters
		enterValuebyXpath(Emailtxtbox, "To enter only characters  on Emailfield", "abcd");
		clickbyXpath(Submit, "submit button");
		verifyTextContainsByXpath(emailerrtxt2, "Invalid email","Error message ");

	}

	public void checkpasswordfield() {

		// check error message without entering any data
		attributevalue(Passwordtxtbox, "placeholder", "Enter your password");

		clickbyXpath(Submit, "submit button");
		verifyTextContainsByXpath(passworderrtxt0, "Password is a required field","Error message ");

		// check password error message
		enterValuebyXpath(Passwordtxtbox, "To enter space on passwordfield", "  ");
		clickbyXpath(Submit, "submit button");
		verifyTextContainsByXpath(passworderrtxt1, "Password cannot be empty","Error message ");

	}

	public void checkunregisteredemail() {

		clearfield(Emailtxtbox);
		enterValuebyXpath(Emailtxtbox, "To enter unregisteredemail on Emailfield", randomnames(3) + "@gmail.com");

		clearfield(Passwordtxtbox);
		enterValuebyXpath(Passwordtxtbox, "To enter password ", randomnames(6));
		clickbyXpath(Submit, "submit button");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		verifyTextContainsByXpath(ToastMessage, "EmailId not exist","Toast message ");

	}

	public void checkvalidemailandpasswordfield() {

		clearfield(Emailtxtbox);
		enterValuebyXpath(Emailtxtbox, "To enter email on Emailfield", email);

		clearfield(Passwordtxtbox);
		enterValuebyXpath(Passwordtxtbox, "To enter password ", password);
		clickbyXpath(Submit, "submit button");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		verifyTextContainsByXpath(ToastMessage, "login successful","Toast message ");

	}

	public void checkToast(String toast) {

		verifyTextContainsByXpath(ToastMessage, toast,"Toast message ");
	}

	String Forgetpasswordemailerrtxt0 = "Email is a required field";
	String Forgetpasswordemailerrtxt1 = "Email cannot be empty";
	String Forgetpasswordemailerrtxt2 = "Invalid email";

	public void checkforgetpasswordpage() {

		// navigate to signin page and check page title
		clickbyXpath(SignInbtn, "click on SignIn button ");
		verifyTitle("Sign in");

		// click on Forgetpassword and check page navigation
		clickbyXpath(forgetpasswordbtn, "Forget password field");
		verifyTextContainsByXpath(forgetpasswordTile, "Forget Password","Forget password title ");

		// check emailtextbox placeholder name
		attributevalue(Forgetpassemailfield, "placeholder", "Enter your user email");

		// verify error message of forget password page
		clickbyXpath(generateOTP, "Generate OTP button ");
		verifyTextContainsByXpath(Forgetpassemailerrtxt, Forgetpasswordemailerrtxt0,"Forget password email field");

		enterValuebyXpath(Forgetpassemailfield, "Forget password email field", "  ");
		clickbyXpath(generateOTP, "Generate OTP button ");
		verifyTextContainsByXpath(Forgetpassemailerrtxt, Forgetpasswordemailerrtxt1,"Forget password error message");

		clearfield(Emailtxtbox);
		enterValuebyXpath(Forgetpassemailfield, "Forget password email field", randomnames(4));
		clickbyXpath(generateOTP, "Generate OTP button ");
		verifyTextContainsByXpath(Forgetpassemailerrtxt, Forgetpasswordemailerrtxt2,"Forget password error message");

		clearfield(Emailtxtbox);
		enterValuebyXpath(Forgetpassemailfield, "Forget password email field", randomnames(4) + "@yopmail.com");
		clickbyXpath(generateOTP, "Generate OTP button ");
		checkToast("EmailId not exist");

		clearfield(Emailtxtbox);
		enterValuebyXpath(Forgetpassemailfield, "Forget password email field", email);
		clickbyXpath(generateOTP, "Generate OTP button ");
		checkToast("OTP has been sent to user registered Email-Id");
//		  

	}

	public void checkOTPverificationpage() throws Exception {

		// navigate to signin page and check page title
		clickbyXpath(SignInbtn, "click on SignIn button ");
		verifyTitle("Sign in");

		// click on Forgetpassword and check page navigation
		clickbyXpath(forgetpasswordbtn, "Forget password field");
		verifyTextContainsByXpath(forgetpasswordTile, "Forget Password","Forget password title");

		// entering valid mailID and navigate from Forget password page to OTP
		// verification page
		clearfield(Emailtxtbox);
		enterValuebyXpath(Forgetpassemailfield, "Forget password email field", email);
		clickbyXpath(generateOTP, "Generate OTP button ");
		Thread.sleep(3000);
		checkToast("OTP has been sent to user registered Email-Id");

		// check title of OTP verification page
		verifyTextContainsByXpath(OTPverificationttile, "OTP Verification","OTP verification title");
		verifyTextContainsByXpath(OTPtimer, "Resend Code","Resend code");

		// check OTPpage error message
		OTPbox1.sendKeys("1");
		OTPbox2.sendKeys("1");
		OTPbox3.sendKeys("1");
		OTPbox4.sendKeys("1");
		OTPbox5.sendKeys("1");
		clickbyXpath(verifiedandproceed, "verified and proceed button");
		Thread.sleep(3000);

		verifyTextContainsByXpath(OTPpageErrtxt, "Please enter the valid OTP","OTP page error text");

		// check OTP page error toast
		OTPbox1.sendKeys("1");
		OTPbox2.sendKeys("1");
		OTPbox3.sendKeys("1");
		OTPbox4.sendKeys("1");
		OTPbox5.sendKeys("1");
		OTPbox6.sendKeys("1");
		clickbyXpath(verifiedandproceed, "verified and proceed button");
		Thread.sleep(3000);
		verifyTextContainsByXpath(ToastMessage, "Invalid OTP","Toast message");

		Thread.sleep(3000);

		// check OTP page toast
		clickbyXpathlongwait(resendOtp, "Resend OTP button ");
		Thread.sleep(3000);
		verifyTextContainsByXpath(ToastMessage, "OTP has been sent to user registered Email-Id","Toast message");

		// check OTP page navigation to Password page
		backnavigation(forgetpasswordTile, "Forget Password");
		clearfield(Emailtxtbox);
		enterValuebyXpath(Forgetpassemailfield, "Forget password email field", email);
		clickbyXpath(generateOTP, "Generate OTP button ");
		Thread.sleep(3000);
		checkToast("OTP has been sent to user registered Email-Id");

		// check title of OTP verification page
		verifyTextContainsByXpath(OTPverificationttile, "OTP Verification","OTP verifiction title");
		verifyTextContainsByXpath(OTPtimer, "Resend Code","Resend code");
		Thread.sleep(3000);

		OTPbox1.sendKeys("1");
		OTPbox2.sendKeys("2");
		OTPbox3.sendKeys("3");
		OTPbox4.sendKeys("4");
		OTPbox5.sendKeys("5");
		OTPbox6.sendKeys("6");
		clickbyXpath(verifiedandproceed, "verified and proceed button");
		Thread.sleep(3000);

		checkToast("OTP has been sent to user registered Email-Id");

		// check Change password page navigation
		verifyTextContainsByXpath(ChangePasswordtitle, "Change Password","Change password title ");

	}

	public void checkChangePasswordpageerrormessage() throws Exception {

		// navigate to signin page and check page title
		clickbyXpath(SignInbtn, "click on SignIn button ");
		verifyTitle("Sign in");

		// click on Forgetpassword and check page navigation
		clickbyXpath(forgetpasswordbtn, "Forget password field");
		verifyTextContainsByXpath(forgetpasswordTile, "Forget Password","Forget password title ");

		// entering valid mailID and navigate from Forget password page to OTP
		// verification page
		clearfield(Emailtxtbox);
		enterValuebyXpath(Forgetpassemailfield, "Forget password email field", email);
		clickbyXpath(generateOTP, "Generate OTP button ");
		Thread.sleep(3000);
		checkToast("OTP has been sent to user registered Email-Id");

		// enter OTP data and navigate to pssword page
		OTPbox1.sendKeys("1");
		OTPbox2.sendKeys("2");
		OTPbox3.sendKeys("3");
		OTPbox4.sendKeys("4");
		OTPbox5.sendKeys("5");
		OTPbox6.sendKeys("6");
		clickbyXpath(verifiedandproceed, "verified and proceed button");

		// click on reset button without entering data
		clickbyXpath(Resetmypassword_CPP, "Reset password button");
		verifyTextContainsByXpath(passworderrtxt_CPP, passerrmsg1,"Error message ");
		verifyTextContainsByXpath(confirmPasserrtxt_CPP, CPerrmsg1,"Error message ");

		// entering only small letter and check err msg
		enterValuebyXpath(Passwordtxtbox, "Password Textbox", "smallletters");
		clickbyXpath(Resetmypassword_CPP, "Reset password button ");
		verifyTextContainsByXpath(passworderrtxt_CPP, passerrmsg2,"Error message ");

		// entering only capital letter and check err msg
		clearfield(Passwordfield_CPP);
		enterValuebyXpath(Passwordfield_CPP, "Password Textbox", "CAPITALLETTERS");
		clickbyXpath(Resetmypassword_CPP, "Reset password button ");
		verifyTextContainsByXpath(passworderrtxt_CPP, passerrmsg3,"Error message ");

		// entering both small and capital letter and check err msg
		clearfield(Passwordfield_CPP);
		enterValuebyXpath(Passwordfield_CPP, "Password Textbox", "smallCAPS");
		clickbyXpath(Resetmypassword_CPP, "Reset password button ");
		verifyTextContainsByXpath(passworderrtxt_CPP, passerrmsg4,"Error message ");

		// entering small,caps and number nd check err msg
		clearfield(Passwordfield_CPP);
		enterValuebyXpath(Passwordfield_CPP, "Password Textbox", "smallCAPS123");
		clickbyXpath(Resetmypassword_CPP, "Reset password button ");
		verifyTextContainsByXpath(passworderrtxt_CPP, passerrmsg5,"Error message ");

		// entering only password field and check CPerr msg
		clearfield(Passwordfield_CPP);
		enterValuebyXpath(Passwordfield_CPP, "Password Textbox", PasswordData);
		clickbyXpath(Resetmypassword_CPP, "Reset password button ");
		verifyTextContainsByXpath(confirmPasserrtxt_CPP, CPerrmsg1,"Error message ");

		// enter wrong password in CPfield compare to password field nd check err msg
		clearfield(confirmpasswordfield_CPP);
		enterValuebyXpath(confirmpasswordfield_CPP, "ConfirmPassword Textbox", "@#$%");
		clickbyXpath(Resetmypassword_CPP, "Reset password button ");
		verifyTextContainsByXpath(confirmPasserrtxt_CPP, CPerrmsg2,"Error message ");

	}

	// enter correct passwords in both field and check page navigation
	public void Resetnewpassword() {

		clearfield(Passwordfield_CPP);
		enterValuebyXpath(Passwordfield_CPP, "PasswordTextbox", PasswordData);
		clearfield(confirmpasswordfield_CPP);
		enterValuebyXpath(confirmpasswordfield_CPP, "ConfirmPassword Textbox", PasswordData);
		clickbyXpath(Resetmypassword_CPP, "Reset password button ");
		try {
			Thread.sleep(3000);
			verifyTextContainsByXpath(ToastMessage, "Password has been updated successfully","Toast message ");
		} catch (Exception e) {
			e.printStackTrace();
		}

		verifyTextContainsByXpath(Signintitle, "Sign in","SignIn title");
	}

}
