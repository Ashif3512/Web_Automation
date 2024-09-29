package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import wrappers.GenericWrappers;

public class CreateAccountPage extends GenericWrappers {
	
		private WebDriver driver;
	 // Locate all elements on the page
	    
		@FindBy(xpath = "//input[@name='user_email']")
		private WebElement emailField;
		
		@FindBy(xpath = "//input[@name='user_name']")
		private WebElement usernameField;
		
		@FindBy(xpath = "//input[@name='password']")
		private WebElement passwordField;
		
		@FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[5]/input[1]")
		private WebElement confirmPasswordField;
		
		@FindBy(xpath = "//input[@name='term_and_condition']")
		private WebElement tcField;
		
	    @FindBy(xpath = "//div[contains(text(),'Submit')]")
	    private WebElement submitButton;
	    
	    @FindBy(xpath = "//div[@text()='Sign in']")
	    private WebElement signInButton;
	    
	    @FindBy(xpath = "//div[@text()='Terms and Conditions']")
	    private WebElement tcLink;
	    
	    @FindBy(xpath = "//div[contains(text(),'Create Account')]")
	    private WebElement CreateAccount;
	    
	    @FindBy(xpath = "//label[contains(text(),'Email')]")
	    private WebElement emailTxt;
//	    
	    @FindBy(xpath = "//label[contains(text(),'Name')]")
	    private WebElement nameTxt;
//	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[4]/label[1]")
	    private WebElement passwordtxt;
//	    
	    @FindBy(xpath = "//label[contains(text(),'Confirm Password')]")
	    private WebElement confirmPasswordtxt;
//	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]")
	    private WebElement emailErr;
//	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/div[1]")
	    private WebElement nameErr;
//	    
	    
	    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[4]/div[2]/div[2]")
	    private WebElement passwordErr;
	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[5]/div[2]")
	    private WebElement confirmpassErr;
	    
	    @FindBy(xpath = "//div[contains(text(),'Please accept terms and conditions')]")
	    private WebElement Tcerr;
	    
	    @FindBy(xpath = "//span[contains(text(),'Terms and Conditions')]")
	    private WebElement TClinktxt;
	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/*[1]")
	    private WebElement Passwordeyeicon;
	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[5]/div[1]/*[1]")
	    private WebElement ConfirmPasswordeyeicon;
	    
	    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]")
	    private WebElement OTPpage;
	    
	    @FindBy(xpath = "//div[contains(text(),'Try Again')]")
	    private WebElement nointernetpage;
	    
	    @FindBy(xpath = "//div[contains(text(),'OTP Verification')]")
	    private WebElement OTPVerificationtext;
	    
	    @FindBy(xpath = "//div[contains(text(),'Verified & Proceed')]")
	    private WebElement OTPVerifiedandProceedbtn;
	    
	    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[6]/div[1]")
	    private WebElement ResendOTP;
	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/input[1]")
	    private WebElement OTPbox1;
	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/input[2]")
	    private WebElement OTPbox2;
	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/input[3]")
	    private WebElement OTPbox3;
	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/input[4]")
	    private WebElement OTPbox4;
	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/input[5]")
	    private WebElement OTPbox5;
	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/input[6]")
	    private WebElement OTPbox6;
	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[5]")
	    private WebElement OTPerrtext ;
	    
	    @FindBy(xpath = "//*[@role='status']")
		private WebElement ToastMessage;
	    
	    @FindBy(xpath = "//div[text()='Sign up']")
	    private WebElement signUpButton;
	    
//	    @FindBy(xpath = "")
//	    private WebElement CreateAccount;
	    
//	    @FindBy(xpath = "")
//	    private WebElement CreateAccount;
	    
//	    @FindBy(xpath = "")
//	    private WebElement CreateAccount;
	    
	    // Constructor
	    
	    public CreateAccountPage(WebDriver driver) {
	    	
	        this.driver=driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    
//	    ERROR MESSAGES_____________________________________
	    String emailErr0,emailErr1,nameErr0,nameErr1,nameErr2,passErr0,passErr1,passErr2,passErr3,passErr4,cPasserr0,cPasserr1,tcErr;
	    {
	    	emailErr0="Mail ID cannot be empty";
	    	emailErr1="Mail ID not found";
	    	nameErr0="User Name is a required field";
	    	nameErr1="User name must be letters only";
	    	nameErr2="User name cannot be empty";
	    	passErr0="Password is a required field";		
	    	passErr1="Password must have a special characters";		
	    	passErr2="Password must have a small letter";		
	    	passErr3="Password must have a capital letter";		
	    	passErr4="Password must bse at least 8 characters";
	    	cPasserr0="Confirm Password is a required field";
	    	cPasserr1="Passwords do not match";
	    	tcErr="Please accept terms and conditions";
	    }
	    
	    
	    
	    
	    // Methods to interact with elements
	    
		public void enterEmailId(String emailId) {
			enterValuebyXpath(emailField, " Email ID ", emailId);
		}

		
		public void enterUserName(String userName) {
			enterValuebyXpath(usernameField, " User Name ", userName);
		}

		public void enterPassword(String password) {
			enterValuebyXpath(passwordField, " Password ", password);
		}

		
		public void enterConfirmPassword(String confirmPassword) {
			enterValuebyXpath(confirmPasswordField, "Confirm Password", confirmPassword);
		}

		
		public void clickTCCheckbox() {
			clickbyXpath(tcField, " Terms and Conditions check box ");
		}

		
		public void clickTcLink() {
			clickbyXpath(tcLink, " Terms and Conditions check Link ");
		}

		
		public void clickSignInButton() {
			clickbyXpath(signInButton, " Sign In");
		}

		
		public void clickSubmitButton() {
			clickbyXpath(submitButton, " Submit Button ");
		}
		
		public void checkacnttxt() throws Exception {
			verifyTextContainsByXpath(CreateAccount,"Create Account","Create account title");
			
		}
		
		public void checknametxt() throws Exception {
			verifyTextContainsByXpath(nameTxt,"Name","Name header");
		}
		
		public void checkemailtxt() throws Exception {
			verifyTextContainsByXpath(emailTxt,"Email","email header");
		}
			
		public void checkpasswordtxt() throws Exception {
			verifyTextContainsByXpath(passwordtxt, "Password","Password header");
		}

		public void checkconfirmpasswordtxt() throws Exception {
			verifyTextContainsByXpath(confirmPasswordtxt, "Confirm Password","Confirm password header");

		}

		public void checkTCtext() throws Exception {
			verifyTextContainsByXpath(TClinktxt, "Terms and Conditions","terms and Conditions header");

		}

		public void checkEmailErrMsg0() throws Exception {
			verifyTextContainsByXpath(emailErr, emailErr0,"Error message");

		}

		public void checkEmailErrMsg1() throws Exception {
			verifyTextContainsByXpath(emailErr, emailErr1,"Error message");

		}

		public void checkNameErrMsg0() throws Exception {
			verifyTextContainsByXpath(nameErr, nameErr0,"Error message");

		}

		public void checkNameErrMsg1() throws Exception {
			verifyTextContainsByXpath(nameErr, nameErr1,"Error message");
		}

		public void checkNameErrMsg2() throws Exception {
			verifyTextContainsByXpath(nameErr, nameErr2,"Error message");

		}

		public void checkPasswordErrMsg0() throws Exception {
			verifyTextContainsByXpath(passwordErr, passErr0,"Error message");

		}

		public void checkPasswordErrMsg1() throws Exception {
			verifyTextContainsByXpath(passwordErr, passErr1,"Error message");

		}

		public void checkPasswordErrMsg2() throws Exception {
			verifyTextContainsByXpath(passwordErr, passErr2,"Error message");

		}

		public void checkPasswordErrMsg3() throws Exception {
			verifyTextContainsByXpath(passwordErr, passErr3,"Error message");

		}

		public void checkPasswordErrMsg4() throws Exception {
			verifyTextContainsByXpath(passwordErr, passErr4,"Error message");

		}

		public void checkConfirmPasswordErrMsg0() throws Exception {
			verifyTextContainsByXpath(confirmpassErr, cPasserr0,"Error message");

		}

		public void checkConfirmPasswordErrMsg1() throws Exception {
			verifyTextContainsByXpath(confirmpassErr, cPasserr1,"Error message");

		}

		public void checkTCerrmsg() throws Exception {
			verifyTextContainsByXpath(Tcerr, tcErr,"Error message");

		}

		public void clearemailfield() throws Exception {
			clearfield(emailField);

		}

		public void clearnamefield() throws Exception {
			clearfield(usernameField);

		}

		public void clearPasswordfield() throws Exception {
			clearfield(passwordField);

		}

		public void clearConfirmPasswordfield() throws Exception {
			clearfield(confirmPasswordField);

		}

		public void clickpasswordeyeicon() throws Exception {
			clickeyeicon(Passwordeyeicon);
			attributevalue(passwordField, "type", "text");

		}

		public void clickConfrimPasswordeyeicon() throws Exception {
			clickeyeicon(ConfirmPasswordeyeicon);

		}

		public void enablewifi() {
			enableWifi();

		}

		public void disablewifi() {

			disableWifi();

		}

		public void nointernetpage() {

			verifyTextContainsByXpath(nointernetpage, "Try Again","No internet error message");
		}

		public void checkOTPverificationpage() {
			verifyTextContainsByXpath(OTPVerificationtext, "OTP Verification","OTP verfication page");

		}

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
			verifyTextContainsByXpath(OTPerrtext, text,"OTP error message");

		}

		public void enterincorrect6OTP() {

			enterValuebyXpath(OTPbox1, "OTPbox", "1");
			enterValuebyXpath(OTPbox2, "OTPbox", "2");
			enterValuebyXpath(OTPbox3, "OTPbox", "3");
			enterValuebyXpath(OTPbox4, "OTPbox", "4");
			enterValuebyXpath(OTPbox5, "OTPbox", "0");
			enterValuebyXpath(OTPbox6, "OTPbox", "6");

		}

		public void clickonresendbutton() {

			clickbyXpathlongwait(ResendOTP, "ResendOTP");
		}

		public void clearOTPfieldOTP1() {

			clearfield(OTPbox1);

		}

		public void clearOTPfieldOTP2() {

			clearfield(OTPbox2);

		}

		public void clearOTPfieldOTP3() {

			clearfield(OTPbox3);

		}

		public void clearOTPfieldOTP4() {

			clearfield(OTPbox4);

		}

		public void clearOTPfieldOTP5() {

			clearfield(OTPbox5);

		}

		public void clearOTPfieldOTP6() {

			clearfield(OTPbox6);

		}

		public void checkToast(String toast) {

			verifyTextContainsByXpath(ToastMessage, toast,"Toast");
		}

		public void backtocreateacnt() {

			backnavigation(CreateAccount, "Create Account");
		}

		public void CreateAccount() throws Exception {

			clickbyXpath(signUpButton, " Sign Up ");
			enterEmailId(randomnames(4) + "@gmail.com");
			enterUserName(randomnames(4));
			enterPassword("Welcome@123");
			clickpasswordeyeicon();
			enterConfirmPassword("Welcome@123");
			clickConfrimPasswordeyeicon();
			clickTCCheckbox();

			clickSubmitButton();
			Thread.sleep(1000);
			checkToast("OTP has been sent to user registered Email-Id");
		}
}
