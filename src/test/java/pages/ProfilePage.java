package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wrappers.GenericWrappers;

public class ProfilePage extends GenericWrappers {

	private WebDriver driver;
	String nameErr1, nameErr2, DOBerr, mobilenoErr1, mobilenoErr2, regionerr1, regionErr2, DOBplaceholder,
			Mobilenumberplacceholder, Regionplaceholder, specialcharacter, passerrmsg1, passerrmsg2, passerrmsg3,
			passerrmsg4, passerrmsg5, CPerrmsg1, CPerrmsg2, PasswordData;
	{

		nameErr1 = "Name cannot be empty";
		nameErr2 = "Name should not contain space, numbers and special characters";
		DOBerr = "Date of birth cannot be empty";
		mobilenoErr1 = "Mobile number cannot be empty";
		mobilenoErr2 = "Mobile number is not valid";
		regionerr1 = "Region cannot be empty";
		regionErr2 = "Region should not contain space, numbers and special characters";

		specialcharacter = "@#$%&*";
		PasswordData = "Welcome@123";
		passerrmsg1 = "Password is required";
		passerrmsg2 = "Password must have a capital letter";
		passerrmsg3 = "Password must have a small letter";
		passerrmsg4 = "Password must have a number";
		passerrmsg5 = "Password must have a special character";
		CPerrmsg1 = "Confirm password is required";
		CPerrmsg2 = "Passwords do not match";

	}

	@FindBy(xpath = "(//div[contains(@class,'Header_Component_icon_Link_View__')])[2]")
	private WebElement ProfileIcon;

	@FindBy(xpath = "//div[contains(@class,'Profile_profile_Title__')]")
	private WebElement Profiletitle;

	@FindBy(xpath = "//div[contains(@class,'Profile_edit_Profile_Button__')]")
	private WebElement EditProfileBtn;

	@FindBy(xpath = "(//div[contains(@class,'Profile_profile_Data_Title__')])[1]")
	private WebElement DOBtitle;

	@FindBy(xpath = "(//div[contains(@class,'Profile_profile_Data_Title__')])[2]")
	private WebElement MobileNumbertitle;

	@FindBy(xpath = "(//div[contains(@class,'Profile_profile_Data_Title__')])[3]")
	private WebElement Regiontilte;

	@FindBy(xpath = "(//div[contains(@class,'Profile_profile_Data_Content__')])[1]")
	private WebElement DOBdata;

	@FindBy(xpath = "(//div[contains(@class,'Profile_profile_Data_Content__')])[2]")
	private WebElement Mobilenumberdata;

	@FindBy(xpath = "(//div[contains(@class,'Profile_profile_Data_Content__')])[3]")
	private WebElement Regiondata;

	@FindBy(xpath = "(//div[contains(@class,'Profile_button_Name__')])[1]")
	private WebElement Editpasswordlink;

	@FindBy(xpath = "(//div[contains(@class,'Profile_button_Name__')])[2]")
	private WebElement Logoutlink;

	@FindBy(xpath = "//div[contains(@class,'Profile_profile_Email__')]")
	private WebElement emaildata;

	@FindBy(xpath = "//div[contains(@class,'Profile_profile_Name__')]")
	private WebElement userNamedata;

	@FindBy(xpath = "(//input[contains(@class,'Edit_Profile_textInput_Style__')])[1]")
	private WebElement nameTextbox;

	@FindBy(xpath = "(//input[contains(@class,'Edit_Profile_textInput_Style__')])[2]")
	private WebElement DOBtextbox;

	@FindBy(xpath = "(//input[contains(@class,'Edit_Profile_textInput_Style__')])[3]")
	private WebElement mobileNumberTextbox;

	@FindBy(xpath = "(//input[contains(@class,'Edit_Profile_textInput_Style__')])[4]")
	private WebElement regionTextbox;

	@FindBy(xpath = "//div[contains(@class,'Edit_Profile_button_Style__')]")
	private WebElement SaveButtonProfilepage;

	@FindBy(xpath = "(//div[contains(@class,'Edit_Profile_formikErrorText__')])[2]")
	private WebElement DOBerrmsg;

	@FindBy(xpath = "(//div[contains(@class,'Edit_Profile_formikErrorText__')])[1]")
	private WebElement nameErrmsg;

	@FindBy(xpath = "(//div[contains(@class,'Edit_Profile_formikErrorText__')])[3]")
	private WebElement mobilenoerrmsg;

	@FindBy(xpath = "(//div[contains(@class,'Edit_Profile_formikErrorText__')])[4]")
	private WebElement Regionerrmsg;

	@FindBy(xpath = "//div[contains(text(),'Edit Profile')]")
	private WebElement EditProfiletitle;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]")
	private WebElement exploreourcourses;

	@FindBy(xpath = "//input[contains(@class,'Edit_Profile_upload_image_input__')]")
	private WebElement editiconeditprofilepage;

	@FindBy(xpath = "//div[contains(@class,'Edit_Profile_button_Style__iSFOU')]")
	private WebElement savebtnEditprofilepage;

	@FindBy(xpath = "//div[contains(@class,'Otp_signInText__')]")
	private WebElement OTPVerificationtext;

	@FindBy(xpath = "//div[contains(text(),'Verified & Proceed')]")
	private WebElement OTPVerifiedandProceedbtn;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[6]/div[1]")
	private WebElement ResendOTP;

	@FindBy(xpath = "(//input[contains(@class,'Otp_otpInput__')])[1]")
	private WebElement OTPbox1;

	@FindBy(xpath = "(//input[contains(@class,'Otp_otpInput__')])[2]")
	private WebElement OTPbox2;

	@FindBy(xpath = "(//input[contains(@class,'Otp_otpInput__')])[3]")
	private WebElement OTPbox3;

	@FindBy(xpath = "(//input[contains(@class,'Otp_otpInput__')])[4]")
	private WebElement OTPbox4;

	@FindBy(xpath = "(//input[contains(@class,'Otp_otpInput__')])[5]")
	private WebElement OTPbox5;

	@FindBy(xpath = "(//input[contains(@class,'Otp_otpInput__')])[6]")
	private WebElement OTPbox6;

	@FindBy(xpath = "//div[contains(@class,'Otp_otp_Error_Text__')]")
	private WebElement OTPerrtext;

	@FindBy(xpath = "//div[contains(text(),'Explore Our Course')]")
	private WebElement Explorecourse;

	@FindBy(xpath = "//div[contains(@class,'Registation_signInText__')]")
	private WebElement changePasswordtitle;

	@FindBy(xpath = "//div[contains(@class,'Registation_signInText__')]")
	private WebElement changepasswordtitle;

	@FindBy(xpath = "//input[contains(@name,'password')]")
	private WebElement passwordtextboxPP;

	@FindBy(xpath = "//input[contains(@name,'confirm_password')]")
	private WebElement confirmpPasswordtextboxPP;

	@FindBy(xpath = "//div[contains(@class,'Registation_signInButton__')]")
	private WebElement resetpasswordBtn;

	@FindBy(xpath = "(//div[contains(@class,'Registation_formikErrorText__')])[1]")
	private WebElement Passworderrtxt;

	@FindBy(xpath = "(//div[contains(@class,'Registation_formikErrorText__')])[2]")
	private WebElement CPerrtxt;

	@FindBy(xpath = "//*[@role='status']")
	private WebElement ToastMessage;

	public ProfilePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.jsExecutor = (JavascriptExecutor) driver;
	}

	public void checkProfilePagenavigation() {
		clickbyXpath(ProfileIcon, "Profileicon");
		verifyTextContainsByXpath(Profiletitle, "Profile", "Profile page title");
	}

	public void checkEditProfilenavigation() {
		clickbyXpath(EditProfileBtn, "Editprofile");
		verifyTextContainsByXpath(EditProfiletitle, "Edit Profile", "Edit profile page title");

	}

	public void backnavigationtohomepage() {

		backnavigation(exploreourcourses, "Explore Our Course");
	}

	public void backnavigationtoProfilepage() {

		backnavigation(Profiletitle, "Profile");
	}

	public void compareEmail(String email) {

		verifyTextContainsByXpath(emaildata, email, "Pre-entered Email ");
	}

	public void compareDOBplaceholder(String text) {

		verifyTextContainsByXpath(DOBdata, text, " DOB placeholder");// DOBplaceholder
	}

	public void compareMobilenumberplaceholder(String text) {

		verifyTextContainsByXpath(Mobilenumberdata, text, " Mobile number placeholder");// Mobilenumberplacceholder
	}

	public void compareRegionplaceholder(String text) {

		verifyTextContainsByXpath(Regiondata, text, " Region placeholder");// Regionplaceholder
	}

	public void clicksLogoutProfilepage() {

		verifyTextContainsByXpath(Logoutlink, "Log Out", "Logout link");
		scrollToElementAndClick(Logoutlink);
	}

	public void clickEditPasswordProfilepage() {

		verifyTextContainsByXpath(Editpasswordlink, "Edit Password", "Edit password link");
		scrollToElementAndClick(Editpasswordlink);
	}

	public void checkDOBerrmessage1() {

		verifyTextContainsByXpath(scrollToElement(DOBerrmsg), DOBerr, "Error message ");
	}

	public void checkMobilenoErrmsg1() {

		verifyTextContainsByXpath(scrollToElement(mobilenoerrmsg), mobilenoErr1, "Error message ");
	}

	public void checkMobilenoErrmsg2() {

		verifyTextContainsByXpath(scrollToElement(mobilenoerrmsg), mobilenoErr2, "Error message ");
	}

	public void checkRegionerrmsg1() {

		verifyTextContainsByXpath(scrollToElement(Regionerrmsg), regionerr1, "Error message ");
	}

	public void checkRegionerrmsg2() {

		verifyTextContainsByXpath(scrollToElement(Regionerrmsg), regionErr2, "Error message ");
	}

	public void checkNameerrmsg1() {

		verifyTextContainsByXpath(scrollToElement(nameErrmsg), nameErr1, "Error message ");
	}

	public void checkNameerrmsg2() {

		verifyTextContainsByXpath(scrollToElement(nameErrmsg), nameErr2, "Error message ");
	}

	public void clickEditicon() {

//	    	scrollToElementAndClick(editiconeditprofilepage);
		clickbyXpath(editiconeditprofilepage, "Edit icon");
	}

	public void clickSaveEditprofilepage() {
		scrollToElementAndClick(savebtnEditprofilepage);
//	    	clickbyXpath(savebtnEditprofilepage, "Savebtn of EditProfile page");
	}

	public void checknamefieldallerrmsg() {

		clearfield(nameTextbox);
		clickSaveEditprofilepage();
		checkNameerrmsg1();
		enterValuebyXpath(nameTextbox, "Namefield", specialcharacter);
		clickSaveEditprofilepage();
		checkNameerrmsg2();
	}

	public void checkmobilenumberfieldallerrmsg() {

		clearfield(mobileNumberTextbox);
		clickSaveEditprofilepage();
		checkMobilenoErrmsg1();
		enterValuebyXpath(mobileNumberTextbox, "MobileNumberfield", specialcharacter);
		clickSaveEditprofilepage();
		checkMobilenoErrmsg2();
	}

	public void checkRegionfieldallerrmsg() {

		clearfield(regionTextbox);
		clickSaveEditprofilepage();
		checkRegionerrmsg1();
		enterValuebyXpath(regionTextbox, "MobileNumberfield", specialcharacter);
		clickSaveEditprofilepage();
		checkRegionerrmsg2();
	}

	public void sendimage(String sendkeys) {

		enterValuebyXpath(editiconeditprofilepage, "editiconprofilepage", sendkeys);
	}

	public void senddate(String sendkeys) {

		enterValuebyXpath(DOBtextbox, "DOBtextbox", sendkeys);
	}

	public void sendMobilenumber(String sendkeys) {

		enterValuebyXpath(mobileNumberTextbox, "Mobilenumber", sendkeys);
	}

	public void sendRegion(String sendkeys) {

		enterValuebyXpath(regionTextbox, "Regiontextbox", sendkeys);
	}

	public void clearDOBfield() {

		clearfield(DOBtextbox);
	}

	public void clearMobileNumberfield() {

		clearfield(mobileNumberTextbox);
	}

	public void clearRegionfield() throws Exception {

		clearfield(regionTextbox);
	}

	// Click OTP field

	public void entercorrectOTPbox() {

		enterValuebyXpath(OTPbox1, "OTPbox", "1");
		enterValuebyXpath(OTPbox2, "OTPbox", "2");
		enterValuebyXpath(OTPbox3, "OTPbox", "3");
		enterValuebyXpath(OTPbox4, "OTPbox", "4");
		enterValuebyXpath(OTPbox5, "OTPbox", "5");
		enterValuebyXpath(OTPbox6, "OTPbox", "6");

	}

	public void enter5OTP() {

		enterValuebyXpath(OTPbox1, "OTPbox", "1");
		enterValuebyXpath(OTPbox2, "OTPbox", "2");
		enterValuebyXpath(OTPbox3, "OTPbox", "3");
		enterValuebyXpath(OTPbox4, "OTPbox", "4");
		enterValuebyXpath(OTPbox5, "OTPbox", "5");

	}

	public void clickOTPsubmit() {

		clickbyXpath(OTPVerifiedandProceedbtn, "Verify and proceed ");

	}

	public void OTPerrtext(String text) {
		verifyTextContainsByXpath(OTPerrtext, text, "Error message ");

	}

	public void enterincorrect6OTP() {

		enterValuebyXpath(OTPbox1, "OTPbox", "1");
		enterValuebyXpath(OTPbox2, "OTPbox", "2");
		enterValuebyXpath(OTPbox3, "OTPbox", "3");
		enterValuebyXpath(OTPbox4, "OTPbox", "4");
		enterValuebyXpath(OTPbox5, "OTPbox", "p");
		enterValuebyXpath(OTPbox6, "OTPbox", "6");

	}

	public void clickonresendbutton() {

		clickbyXpathlongwait(ResendOTP, "ResendOTP");
	}

	public void checkOTPverificationpage() {

		verifyTextContainsByXpath(OTPVerificationtext, "OTP Verification", "OTP verification title");
	}

	public void checkexplorecourse() {
		verifyTextContainsByXpath(Explorecourse, "Explore Our Course", "Explore course text");
	}

	public void checkOTPfieldallerrmsg() throws Exception {

		// will click verify and proceed button without entering OTP and check error
		// toast
		clickbyXpath(OTPVerifiedandProceedbtn, "verifyandproceedbutton");
		verifyTextContainsByXpath(OTPerrtext, "Please enter the valid OTP", "Error message ");
		// will enter only 5 OTP and cick on verify and proceed to check the error
		// message
		enter5OTP();
		clickbyXpath(OTPVerifiedandProceedbtn, "verifyandproceedbutton");
		verifyTextContainsByXpath(OTPerrtext, "Please enter the valid OTP", "Error message ");

		// going back to profile page and retuning to OTP verification page
		backnavigation(Profiletitle, "Profile");
		clickEditPasswordProfilepage();
		// will clear OTP field and enter in-correct 6 OTP and check or the page error
		// toast

		enterincorrect6OTP();
		clickbyXpath(OTPVerifiedandProceedbtn, "verifyandproceedbutton");
//		    	particulartoastreaderlong("invalidOTPscreen.png", "invalidOTPscreen.png", "Invalid OTP", "Invalid OTP toast occurred", 1000);
		verifyTextContainsByXpath(ToastMessage, "Invalid OTP", "Toast message ");

		clickonresendbutton();
//				particulartoastreaderlong("toast.png", "subtoast.png", "OTP has been sent to user registered", "OTP resent to respected EmailAddress",2000);

		verifyTextContainsByXpath(ToastMessage, "OTP has been sent to user registered Email-Id", "Toast message ");

	}

	public void checkcorrectotpchecknavigation() {

		// will go back to profilepge and enter into OPT verification page
		backnavigation(Profiletitle, "Profile");
		clickEditPasswordProfilepage();
		// will enter correct 6 OTP and check the page navigation to
		entercorrectOTPbox();
		clickbyXpath(OTPVerifiedandProceedbtn, "verifyandproceedbutton");

		verifyTextContainsByXpath(changePasswordtitle, "Change Password", "Change Password title");
	}

//		CHANGE PASSWORD PAGE

	public void checkChangePasswordpageerrormessage() {

		// click on reset button without entering data
		clickbyXpath(resetpasswordBtn, "Reset password button");
		verifyTextContainsByXpath(Passworderrtxt, passerrmsg1, "Error message ");
		verifyTextContainsByXpath(CPerrtxt, CPerrmsg1, "Error message ");

		// entering only small letter and check err msg
		enterValuebyXpath(passwordtextboxPP, "Password Textbox", "smallletters");
		clickbyXpath(resetpasswordBtn, "Reset password button ");
		verifyTextContainsByXpath(Passworderrtxt, passerrmsg2, "Error message ");

		// entering only capital letter and check err msg
		clearfield(passwordtextboxPP);
		enterValuebyXpath(passwordtextboxPP, "Password Textbox", "CAPITALLETTERS");
		clickbyXpath(resetpasswordBtn, "Reset password button ");
		verifyTextContainsByXpath(Passworderrtxt, passerrmsg3, "Error message ");

		// entering both small and capital letter and check err msg
		clearfield(passwordtextboxPP);
		enterValuebyXpath(passwordtextboxPP, "Password Textbox", "smallCAPS");
		clickbyXpath(resetpasswordBtn, "Reset password button ");
		verifyTextContainsByXpath(Passworderrtxt, passerrmsg4, "Error message ");

		// entering small,caps and number nd check err msg
		clearfield(passwordtextboxPP);
		enterValuebyXpath(passwordtextboxPP, "Password Textbox", "smallCAPS123");
		clickbyXpath(resetpasswordBtn, "Reset password button ");
		verifyTextContainsByXpath(Passworderrtxt, passerrmsg5, "Error message ");

		// entering only password field and check CPerr msg
		clearfield(passwordtextboxPP);
		enterValuebyXpath(passwordtextboxPP, "Password Textbox", PasswordData);
		clickbyXpath(resetpasswordBtn, "Reset password button ");
		verifyTextContainsByXpath(CPerrtxt, CPerrmsg1, "Error message ");

		// enter wrong password in CPfield compare to password field nd check err msg
		clearfield(confirmpPasswordtextboxPP);
		enterValuebyXpath(confirmpPasswordtextboxPP, "ConfirmPassword Textbox", specialcharacter);
		clickbyXpath(resetpasswordBtn, "Reset password button ");
		verifyTextContainsByXpath(CPerrtxt, CPerrmsg2, "Error message ");

	}

	// enter correct passwords in both field and check page navigation
	public void Resetnewpassword() {

		clearfield(passwordtextboxPP);
		enterValuebyXpath(passwordtextboxPP, "PasswordTextbox", PasswordData);
		clearfield(confirmpPasswordtextboxPP);
		enterValuebyXpath(confirmpPasswordtextboxPP, "ConfirmPassword Textbox", PasswordData);
		clickbyXpath(resetpasswordBtn, "Reset password button ");
		try {
			checktoast("Password has been updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

		verifyTextContainsByXpath(Profiletitle, "Profile", "Profile title ");
	}

	public void checktoast(String toast) {

		verifyTextContainsByXpath(ToastMessage, toast, "Toast message ");
	}

	public void clearandsavefield() {

		clearfield(DOBtextbox);
		clearfield(regionTextbox);
		clearfield(mobileNumberTextbox);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		scrollToElementAndClick(savebtnEditprofilepage);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (DOBerrmsg.isDisplayed()) {
			System.out.println("Error msg displayed ");
		} else {
			System.out.println("error message not displayed");
		}
	}

}
