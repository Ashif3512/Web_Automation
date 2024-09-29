package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wrappers.GenericWrappers;

public class HomePage extends GenericWrappers{

    private WebDriver driver;
    
 // Locate all elements on the page
    
    @FindBy(xpath = "//div[text()='My Courses']")
    private WebElement myCourseButton;
    
    @FindBy(xpath = "//div[text()='All Courses']")
    private WebElement allCourseButton;
    
    @FindBy(xpath = "//div[text()='Sign up']")
    private WebElement signUpButton;
    
    
    
    
    public HomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    
    // Methods to interact with elements
    public void clickMyCourseButton() {
    	
    	clickbyXpath(myCourseButton," My Course ");
    }
    
 public void clickAllCourseButton() {
    	
    	clickbyXpath(allCourseButton," All Course ");
    }
    
    public void clickSignUpButton() {
    	clickbyXpath(signUpButton, " Sign Up " );
    }

}
