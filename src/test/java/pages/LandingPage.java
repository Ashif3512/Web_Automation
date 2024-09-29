package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Reporter;
import wrappers.GenericWrappers;

public class LandingPage extends GenericWrappers{
	    
	    private WebDriver driver;
	    
	 // Locate all elements on the page
	    
	    @FindBy(xpath = "//div[text()='Sign in']")
	    private WebElement signInButton;
	    
	    @FindBy(xpath = "//div[text()='Sign up']")
	    private WebElement signUpButton;

	    @FindBy(xpath = "//div[contains(text(),'Explore Our Course')]")
	    private WebElement Explorecourse;
	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]")
	    private WebElement Explorebutton;
	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]")
	    private WebElement Signintitle;
	    
	    @FindBy(xpath = "//div[contains(text(),'See all Courses')]")
	    private WebElement Seeallcourselink;
	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/input[1]")
	    private WebElement emailtextboxsigin;
	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[1]/div[2]/div[1]/div[3]/input[1]")
	    private WebElement passwordtextboxsignin;
	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[3]")
	    private WebElement Ourcoursesframe;
	    
	    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/div[2]/div[2]/div[1]/div[1]")
	    private WebElement seeAllCourses;
	    
	    @FindBy(xpath = ".//div[contains(@class, 'Landing_Screen_course_Card_Direction__')]")
	    
	    private List<WebElement> coursecardslocatorLandingpage;
	    
	    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]")
	    private WebElement firstcoursecardlandingpage;
	    
	    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]")
	    private WebElement firstcoursecardExplorebuttonlandingpage;
	    

	    public LandingPage(WebDriver driver) {
	        this.driver=driver;
	        PageFactory.initElements(driver, this);
	        this.jsExecutor = (JavascriptExecutor) driver;
	    }
	    
	    
	    public boolean clickExploreButtonOnCourseCard(List<WebElement> cardContainerLocator) throws Exception {

	    	

	        // Locate all cards within the container
	        List<WebElement> courseCards = cardContainerLocator;

	        if (!courseCards.isEmpty()) {
	            // Get the first course card element
	            WebElement firstCourseCard = courseCards.get(0);

	            // Locate the "Explore" button on the first course card
	            WebElement exploreButton = firstCourseCard.findElement(By.xpath(".//div[contains(@class,'Landing_Screen_course_Button_View__')]"));

	            // Scroll the page to the bottom first to ensure the button is in view
	            jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	            // Wait to ensure the scroll happens before interacting with the element
	            Thread.sleep(2000); // Preferably replace with WebDriverWait for better handling

	            // Scroll to the "Explore" button and click it
	            jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", exploreButton);
	            scrollToElementAndClick(exploreButton);  // Assuming scrollToElementAndClick() clicks after scrolling

	            // Check if the page navigated by verifying the URL or another condition
	            Thread.sleep(2000); // Add explicit wait in a real scenario

	            String currentUrl = driver.getCurrentUrl();
	            if (!currentUrl.equals("https://studentlu-8b934.web.app/")) { // Replace with original URL
	                System.out.println("Page navigated to the next page: " + currentUrl);
	                Reporter.reportStep("Url changed ", "PASS");
	                return true;
	            } else {
	                System.out.println("Page did not navigate.");
	                Reporter.reportStep("Url not changed ", "FAIL");
	                return false;
	            }
	        } else {
	            Reporter.reportStep("No course cards found.", "FAIL");
	            System.out.println("No course cards found.");
	            return false;
	        }
	    }
	    
	    public void clickSeemoreLinkAndCheckCount(WebElement seeAllCoursesButton, WebElement cardContainerLocator) {
	        // Step 1: Get initial count of course cards
	        int initialCardCount = getCountOfCourseCards(cardContainerLocator);
	        System.out.println("Initial number of course cards: " + initialCardCount);

	        // Step 2: Scroll to the "See All Courses" button and click it
	        scrollToElementAndClick(seeAllCoursesButton);

	        // Step 3: Click the "See All Courses" button until all courses are loaded
	        clickSeeMoreUntilAllCoursesAreLoaded(seeAllCoursesButton, cardContainerLocator);

	        // Step 4: Get the updated count of course cards
	        int updatedCardCount = getCountOfCourseCards(cardContainerLocator);
	        System.out.println("Updated number of course cards: " + updatedCardCount);

	        // Step 5: Check if the course card count has increased
	        checkCountOfCards(initialCardCount, updatedCardCount);
	    }

	    public int getCountOfCourseCards(WebElement cardContainerLocator) {
	        List<WebElement> courseCards = cardContainerLocator.findElements(By.xpath(".//div[contains(@class, 'Landing_Screen_course_Card_Direction__')]")); // Adjust the locator to match your card structure

	        // Return the count of course cards
	        return courseCards.size();
	    }

	    public void clickSeeMoreUntilAllCoursesAreLoaded(WebElement seeAllCoursesButton, WebElement cardContainerLocator) {
	        int previousCardCount;
	        int currentCardCount = getCountOfCourseCards(cardContainerLocator);

	        do {
	            previousCardCount = currentCardCount;

	            // Scroll to the "See All Courses" button and click it
	            scrollToElementAndClick(seeAllCoursesButton);

	            // Get the updated count of course cards
	            currentCardCount = getCountOfCourseCards(cardContainerLocator);

	        } while (currentCardCount > previousCardCount); // Loop until no more new courses are loaded
	    }

	    public void checkCountOfCards(int initialCount, int updatedCount) {
	        if (updatedCount > initialCount) {
	            Reporter.reportStep("The number of course cards increased from " + initialCount + " to " + updatedCount, "PASS");
	            System.out.println("The number of course cards increased.");
	        } else {
	            Reporter.reportStep("The number of course cards did not increase.", "FAIL");
	            System.out.println("The number of course cards did not increase.");
	        }
	    }
	    public boolean compareurl(WebElement ele) {

	    	String text = ele.getText();
	    	String currentUrl = driver.getCurrentUrl();
	    	System.out.println(currentUrl);
	    	scrollToElementAndClick(ele);
	    	System.out.println(text);
	    	
	    	String currentUrl2 = driver.getCurrentUrl();
	    	if (!currentUrl.equals(currentUrl2)) {
	    		
	    		Reporter.reportStep("Url changed ", "PASS");
	    		System.out.println("Page navigated to the next page: " + currentUrl2);
	            return true;
	        } else {
	        	Reporter.reportStep("URL not changed ", "FAIL");
	            System.out.println("Page did not navigated to next page.");
	            return false;
	        }
			
	    	
		}
	    public void clickSignInButton() {
	    	
	    	clickbyXpath(signInButton,"Sign In");
	    }
	    public void clickSignUpButton() {
	    	clickbyXpath(signUpButton, " Sign Up " );
	    }
	    

	    public void checkexplorecourse() {
	    	
	    	jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", Explorecourse);
            verifyTextContainsByXpath(Explorecourse, "Explore Our Course","Explore course text ");
		}
	     
	    public void clickexplorecourse() {
	    	jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", Explorecourse);
	    	clickbyXpath(Explorecourse, "Explore Our Course" );
	    }
	   
	    public void verifySigintitle() {
	    	verifyTextContainsByXpath(Signintitle, "Sign in","SignIn title ");
	    }
	    public void navigateback() {
 
	    	backnavigation(Explorecourse, "Explore Our Course");
	    }
	   
	    public void clickSeeallcourseslink() {

	    	scrollToElementAndClick(Seeallcourselink);
		}
	    public void clickExplorebutton() {
	    	
	    	scrollToElementAndClick(Explorebutton);
	    }
	    
	    //sigin page
	    public void enterEmailsigin(String email) {
	    	enterValuebyXpath(emailtextboxsigin, "emailtextbox", email);
	    }
	    public void enetrpasswordsignin(String password) {
	    	enterValuebyXpath(passwordtextboxsignin, "passwordtextbox", password);
	    }
	    
	    public void clickseeallcourselinkhomepage() {
	    	
	    	compareurl(Seeallcourselink);
	    	}
	    
	    public void clickonexplorebuttoncheckpagenavigation() throws Exception {

	    	clickExploreButtonOnCourseCard(coursecardslocatorLandingpage);
		}  
	    

}
