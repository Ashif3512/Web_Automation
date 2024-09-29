package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Reporter;
import wrappers.GenericWrappers;

public class AssessmentPage extends GenericWrappers {
	
	 private WebDriver driver;
		
		@FindBy(xpath = "//input[contains(@class,'Assessment_answerInput')]")
		private WebElement enterFillQuestion;

		@FindBy(xpath = "//div[contains(@class,'Assessment_submitButton')]")
		private WebElement SubmitButton;

		@FindBy(xpath = "//div[contains(@class,'Assessment_nextButton')]")
		private WebElement nextButton;

		@FindBy(xpath = "//div[contains(@class,'Assessment_over_All_Submit_Button')]")
		private WebElement overAllSubmitButton;

		@FindBy(xpath = "(//div[contains(@class,'Assessment_optionKey')])[1]")
		private WebElement mcqOption1;

		@FindBy(xpath = "//input[@type='checkbox']")
		private WebElement popUpCheckbox;
	 
		@FindBy(xpath = "//div[contains(@class,'ModalComponent_submit_button_Text')]")
		private WebElement popUpSubmitButton;
		
		@FindBy(xpath = "(//div[contains(@class,'ScoreCardModal_percentage')])[3]")
		private WebElement checkPercentage;
		
		@FindBy(xpath = "//div[contains(@class,'ScoreCardModal_button_view')]")
		private WebElement okayButton;
		
		@FindBy(xpath = "// input[contains(@class,'Assessment_answerInput')]")
		private WebElement assessementInputBox;		
		
		@FindBy(xpath = "//div[text()='Submit']")
		private WebElement submitButton;
		
		@FindBy(xpath = "//input[@type='checkbox']")
		private WebElement checkBox;
		
		@FindBy(xpath = "//div[contains(@class,'ModalComponent_submit_button_Text')]")
		private WebElement readytoSubmitButton;
		
		@FindBy(xpath = "//div[contains(@class,'ScoreCardModal_modalButton_Text')]")
		private WebElement okButton;
		
		@FindBy(xpath = "//div[contains(@class,'ScoreCardModal_percentage')]")
		private WebElement percentageField;
		
		@FindBy(xpath = "//h2[contains(@class,'ScoreCardModal_resultTitle')]")
		private WebElement resultField;
		
		public WebElement selectQuestion(int qno) {
	        String xpath = String.format("(//div[contains(@class,'Assessment_questionNumber_Text')]/div)["+qno+"]");
	        return driver.findElement(By.xpath(xpath));
	    }
		
		
		
		public WebElement getAnswerField(String option) {
	        String xpath = String.format("(//div[contains(@class,'Assessment_optionKey')])["+option+"]");
	        return driver.findElement(By.xpath(xpath));
	    }
		
		public AssessmentPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		public void enterAssessmentInput(String ans) {
			enterValuebyXpath(assessementInputBox," Assessment Answer Input ", ans);
		}
		
		public void enterMcqOption(String ans) {
			scrollToElements(getAnswerField(ans));
			clickbyXpath(getAnswerField(ans)," Assessment Answer Input ");
		}
		
		
		public void clickSubmitButton1() {
			scrollToElement(submitButton);
			clickbyXpath(submitButton, " Submit Button ");
			
		}
		
		public void clickoverAllSubmitButton() {
			scrollToElement(overAllSubmitButton);
			clickbyXpath(overAllSubmitButton, " Over All Submit Button ");
			
		}
		
		public void clickCheckBox() {
			clickbyXpath(checkBox, " Review Checkbox ");
			
		}
		
		public void clickReadytoSubmitButton() {
			clickbyXpath(readytoSubmitButton, " Ready to Submit ");
			
		}
		
		public void clickOkButton() {
			clickbyXpath(okButton, " Ok Button ");
			
		}
		
		
		public void checkResult(String result) {
			verifyTextContainsByXpath(resultField, result," Check Result ");
			
		}
		
		public void clickMCQSubmitButton() {
			scrollToElements(submitButton);
			clickbyXpath(submitButton, " Submit Button ");
			
		}

		public void enterFillQuestion(String Answer) {
			enterFillQuestion.clear();
			enterValuebyXpath(enterFillQuestion, " Enter Fill Question field ", Answer);
		}

		public void clickSubmitButton() {
			scrollToElements(SubmitButton);
			clickbyXpath(SubmitButton, " Submit Button ");
		}

		public void clickNextButton() {
			clickbyXpath(nextButton, " Next Button ");
		}

		public void enterMCQQuestion(String Answer) {
			enterValuebyXpath(mcqOption1, " Enter MCQ Question ", Answer);
		}

		public void clickPopUpSubmitButton() {
			clickbyXpath(popUpSubmitButton, " Pop up Submit Button ");
		}

		public void clickPopUpCheckBox() {
			clickbyXpath(popUpCheckbox, " Popup Check box ");
		}

		public void clickOkayButton() {
			clickbyXpath(okayButton, " Okay Button ");
		}

		public void VerifyPercentage(String Percentage) {
			verifyTextContainsByXpath(checkPercentage, Percentage, " The Score Percentage ");
		}
		
		public void selectQuestionNumber(int qno) {
			clickbyXpath(selectQuestion(qno), " Question Number "+qno+ "  ");
		}
		
		public void validateQuestionAnswered(int qno) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        String backgroundColor = (String) js.executeScript("return window.getComputedStyle(arguments[0]).backgroundColor;", selectQuestion(qno));
        System.out.println(backgroundColor);
        try {
        	if(backgroundColor.equals("rgb(33, 124, 88)"))
        	{
        		Reporter.reportStep("The question is answered", "PASS");
        	}
        	else {
        		Reporter.reportStep("The question is not answered", "PASS");
        	}
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
		}
		

		public void completeCourseAssessment() {
			
			enterFillQuestion("1");
			clickSubmitButton();
			enterFillQuestion("1");
			clickSubmitButton();
			enterMcqOption("1");
			clickMCQSubmitButton();
			enterMcqOption("1");
			clickMCQSubmitButton();
			enterFillQuestion("1");
			clickSubmitButton();
			enterFillQuestion("1");
			clickSubmitButton();
			enterFillQuestion("1");
			clickSubmitButton();
			enterFillQuestion("1");
			clickSubmitButton();
			enterFillQuestion("1");
			clickSubmitButton();
			enterMcqOption("1");
			clickMCQSubmitButton();
			enterFillQuestion("1");
			clickSubmitButton();
			enterFillQuestion("1");
			clickSubmitButton();
			clickoverAllSubmitButton();
			clickCheckBox();
			//clickReadytoSubmitButton();
			//clickOkayButton();
			// TODO Auto-generated method stub
			
		}
	}
