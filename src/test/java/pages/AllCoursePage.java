package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import wrappers.WebApplicationWrappers;

public class AllCoursePage extends WebApplicationWrappers{

	static ExtentTest test;
	static ExtentReports report;
	
	public AllCoursePage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver, this);
        this.jsExecutor = (JavascriptExecutor) driver;
	}
	
	//Locate all the elements on the page
	
	  @FindBy(xpath = "//div[contains(text(),'Select Subject')]")
	    private WebElement Selectsubject;
	  
	  @FindBy(xpath = "//div[contains(@class,' css-hlgwow')]") 
	  private WebElement dropdown;
	  	  
	  @FindBy(xpath = "//div[contains(@class,'All_Courses_subject_Text__9qR9e')]")
	  private List<WebElement> subjectHeading;
	  
	  @FindBy(xpath = "//div[contains(@class,'All_Courses_course_Container__XYjdI')]")
	  private List<WebElement> allcoursecontainer;
	  
	  @FindBy(xpath = "//div[contains(@class,'All_Courses_see_All_Course_Text__e+bpn')]")
	  private List<WebElement> seemorebutton;
	  @FindBy(xpath = ".//div[contains(@class,'All_Courses_allCourse_Container__h7B8x')]")
	  private List<WebElement> overallcoursecontainerxpath;
	  
	  @FindBy(xpath = "//div[contains(text(),'All Courses')]")
	  private WebElement allcoursebtn;
	  
	  @FindBy(xpath = "//div[contains(@class,'All_Courses_sort_Dropdown_View')]/div/div[2]/div/div")
	  private List<WebElement> dropdownxpath;
	  
	  @FindBy(xpath = "//input[contains(@class,'All_Courses_search_input__')]")
	  private WebElement searchboxXpath;

	  
	  public void verifySelectsubjecttext() {

		  verifyTextContainsByXpath(Selectsubject, "Select Subject" , "Select Subject text ");
	}
	    
	    
	    
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public void verifyCourseCountsAcrossContainers() throws InterruptedException {

		clickbyXpath(allcoursebtn, "All course button ");

		// Define XPaths for locating elements
		String containerXPath = "//div[contains(@class,'All_Courses_course_Direction__pD+Ti')]"; // Subject container
																									// locator
		String courseCardXPath = ".//div[contains(@class,'All_Courses_card_View__CEiCh')]"; // Course card locator
																							// within a container
		String seeAllButtonXPath = ".//div[contains(@class,'All_Courses_see_All_Course_Text__e+bpn')]";

		// Get all subject containers on the page
		List<WebElement> subjectContainers = driver.findElements(By.xpath(containerXPath));

		for (int i = 0; i < subjectContainers.size(); i++) {

			WebElement currentContainer = subjectContainers.get(i);

			// Scroll to the current container
			js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", currentContainer);
			Thread.sleep(2000); // Wait for the page to settle

			// Count the number of courses displayed initially
			List<WebElement> initialCourses = currentContainer.findElements(By.xpath(courseCardXPath));
			int initialCourseCount = initialCourses.size();
			System.out.println("Initial number of courses in container " + (i + 1) + ": " + initialCourseCount);

			// Check if the "See All Courses" button is present
			List<WebElement> seeAllButtons = currentContainer.findElements(By.xpath(seeAllButtonXPath));

			if (!seeAllButtons.isEmpty() && seeAllButtons.get(0).isDisplayed()) {
				// Click the "See All Courses" button if present
				WebElement seeAllButton = seeAllButtons.get(0);
//	                seeAllButton.click();
				clickbyXpath(seeAllButton, "SeeAll button is clicked on ALL COURSE page");
				Thread.sleep(3000); // Wait for the courses to load after clicking "See All"

				// Recount the number of courses after clicking "See All Courses"
				List<WebElement> expandedCourses = currentContainer.findElements(By.xpath(courseCardXPath));
				int expandedCourseCount = expandedCourses.size();
				System.out.println("Expanded number of courses in container " + (i + 1) + ": " + expandedCourseCount);

				// Compare the counts and validate
				if (expandedCourseCount > initialCourseCount) {
					pass("See All Courses button is working for container "+ (i + 1));
				}

			} else {
				// Log a message if there is no "See All Courses" button
				pass("No 'See All Courses' button for container"+ (i + 1) +" due to fewer courses.");
			}
		}
	}

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

	// XPaths
	String overallCoursesContainerXPath = "//div[contains(@class,'All_Courses_allCourse_Container__h7B8x')]";
//	    String dropdownXPath = "//div[contains(@class,' css-hlgwow')]";
	String subjectContainerXPath = "//div[contains(@class,'All_Courses_course_Direction__')]";
	String courseCardXPath = ".//div[contains(@class,'All_Courses_card_View__CEiCh')]";
	String seeAllButtonXPath = ".//div[contains(@class,'All_Courses_see_All_Course_Text__e+bpn')]";
	String subjectNamesXPath = "//div[contains(@class,'All_Courses_subject_Text__9qR9e')]"; // Subject names XPath

	public void verifyDropdownAndItsCourses() throws Exception {

		clickbyXpath(allcoursebtn, "All Course Button");

		List<WebElement> subjectcontainers = driver.findElements(By.xpath(subjectContainerXPath));

		// Loop through each subject name
		for (int i = 0; i < subjectcontainers.size(); i++) {

			// Get the subject name
			WebElement currentContainer = subjectcontainers.get(i);

			js.executeScript("arguments[0].scrollIntoView(true);", currentContainer);
			Thread.sleep(2000);

			List<WebElement> subjectElement = currentContainer
					.findElements(By.xpath("//div[contains(@class,'All_Courses_subject_Text__9qR9e')]"));
			WebElement webElement = subjectElement.get(i);
			String subjectText = webElement.getText();
			System.out.println("Subject: " + subjectText);

			// Initialize the course counts for the all-courses and dropdown pages
			int allCoursesPageCount = 0;
			int dropdownPageCount = 0;

			// Count the courses initially visible
			List<WebElement> initialCourses = currentContainer.findElements(By.xpath(courseCardXPath));
			int initialCourseCount = initialCourses.size();
			System.out.println("Initial number of courses in container " + (i + 1) + ": " + initialCourseCount);

			// Click on "See All Courses" until all courses are visible
			boolean seeAllVisible = true;
			while (seeAllVisible) {
				try {
					WebElement seeAllButton = currentContainer.findElement(By.xpath(seeAllButtonXPath));

					// Scroll to the button to ensure visibility and check if clickable
					js.executeScript("arguments[0].scrollIntoView(true);", seeAllButton);
					wait.until(ExpectedConditions.elementToBeClickable(seeAllButton));

					// Click using JavaScript to avoid intercept issues
					js.executeScript("arguments[0].click();", seeAllButton);
					Thread.sleep(3000); // Wait for courses to load
					pass("clicked on see all button");
				} catch (Exception e) {
					pass("See all button is not visible due to few courses");
					seeAllVisible = false; // Button no longer available
				}
			}

			// Count all expanded courses in "All Courses" page
			List<WebElement> expandedCourses = currentContainer.findElements(By.xpath(courseCardXPath));
			allCoursesPageCount = expandedCourses.size();
			System.out.println("Expanded number of courses in container " + (i + 1) + ": " + allCoursesPageCount);

			// **Scroll back up to the top of the page before selecting from the dropdown**
			js.executeScript("window.scrollTo(0, 0);");
			Thread.sleep(2000); // Allow some time for the page to scroll to the top

			// Open the dropdown by clicking it
			clickbyXpath(dropdown, "Click on Subject dropdown ");
			Thread.sleep(1000); // Small wait to ensure dropdown is opened

			for (WebElement option : dropdownxpath) {
				if (option.getText().equals(subjectText)) {
					option.click();
					pass(subjectText+"is clicked on dropdown");
					break;
				}
			}

			Thread.sleep(2000);

			subjectcontainers = driver.findElements(By.xpath(subjectContainerXPath));
//		            subjectContainers.size()
			for (int k = 0; k < subjectcontainers.size(); k++) {
				WebElement currentContainerloop2 = subjectcontainers.get(k);
				js.executeScript("arguments[0].scrollIntoView(true);", currentContainerloop2);
				Thread.sleep(2000); // Allow time for scrolling and loading

				// Count the initially visible courses in the dropdown page
				List<WebElement> initialCoursesDropdown = currentContainerloop2.findElements(By.xpath(courseCardXPath));

				int initialDropdownCount = initialCoursesDropdown.size();
				System.out.println(
						"Initial number of courses in dropdown container " + (k + 1) + ": " + initialDropdownCount);

				// Click on "See All Courses" until all courses are visible
				boolean seeAllVisibleDropdown = true;
				while (seeAllVisibleDropdown) {
					try {
						WebElement seeAllButtonDropdown = currentContainerloop2
								.findElement(By.xpath(seeAllButtonXPath));

						// Scroll to the button and check if clickable
						js.executeScript("arguments[0].scrollIntoView(true);", seeAllButtonDropdown);
						wait.until(ExpectedConditions.elementToBeClickable(seeAllButtonDropdown));

						// Click using JavaScript to avoid intercept issues
						js.executeScript("arguments[0].click();", seeAllButtonDropdown);
						pass("clicked See all button");
						Thread.sleep(3000); // Wait for courses to load
					} catch (Exception e) {
						pass("See all button not visible in dropdown courses due to few courses");
						seeAllVisibleDropdown = false; // Button no longer available
					}
				}

				// Count the expanded courses in the dropdown page
				List<WebElement> expandedCoursesDropdown = currentContainerloop2
						.findElements(By.xpath(courseCardXPath));
				dropdownPageCount = expandedCoursesDropdown.size();
				pass("Expanded number of courses in dropdown container " + (k + 1) + ": " + dropdownPageCount);
//				System.out.println("Expanded number of courses in dropdown container " + (k + 1) + ": " + dropdownPageCount);
			}
			// Compare the course counts between "All Courses" page and Dropdown
			if (allCoursesPageCount != dropdownPageCount) {
				fail("Mismatch: counts of Courses in 'All Courses' page and selected subject '"+ subjectText + "' do not match.");
//				System.out.println("Mismatch: counts of Courses in 'All Courses' page and selected subject '"+ subjectText + "' do not match.");
			} else {
				pass("Match: Count of Courses in 'All Courses' page and selected subject '" + subjectText+ "' are the same.");
//				System.out.println("Match: Count of Courses in 'All Courses' page and selected subject '" + subjectText+ "' are the same.");
			}

			js.executeScript("window.scrollTo(0, 0);");
			Thread.sleep(2000); // Allow some time for the page to scroll to the top

			// Open the dropdown by clicking it
			clickbyXpath(dropdown, "Click on Subject dropdown ");
			Thread.sleep(1000);

			for (WebElement option : dropdownxpath) {
				if (option.getText().equals("All Subjects")) {
					option.click();
					pass("clicked on ALL SUBJECTS from dropdown");
					break;
				}
				else {
					fail("unable to click on ALL SUBJECTS from dropdown");
				}
			}
			Thread.sleep(3000);
			subjectcontainers = driver.findElements(By.xpath(subjectContainerXPath));

		}
	}

	String cardsnames = "//div[contains(@class,'All_Courses_course_Name__eEN81')]";
	String results = "//div[contains(@class,'Search_Screen_results_Found_Text__Dlmaf')]";

	// searchbox testing
	public void checksearchbox() throws Exception {

		ArrayList<String> cards = new ArrayList<String>();

		clickbyXpath(allcoursebtn, "All Course Button");

		List<WebElement> subjectcontainers = driver.findElements(By.xpath(subjectContainerXPath));

		// Loop through each subject name
		for (int i = 0; i < subjectcontainers.size(); i++) {

			// Get the subject name
			WebElement currentContainer = subjectcontainers.get(i);

			js.executeScript("arguments[0].scrollIntoView(true);", currentContainer);
			Thread.sleep(2000);

			List<WebElement> subjectElement = currentContainer
					.findElements(By.xpath("//div[contains(@class,'All_Courses_subject_Text__9qR9e')]"));
			WebElement webElement = subjectElement.get(i);
			String subjectText = webElement.getText();
			System.out.println("Subject: " + subjectText);

			// Initialize the course counts for the all-courses and dropdown pages
			int allCoursesPageCount = 0;
			int dropdownPageCount = 0;

			// Count the courses initially visible
			List<WebElement> initialCourses = currentContainer.findElements(By.xpath(courseCardXPath));
			int initialCourseCount = initialCourses.size();
			System.out.println("Initial number of courses in container " + (i + 1) + ": " + initialCourseCount);

			// Click on "See All Courses" until all courses are visible
			boolean seeAllVisible = true;
			while (seeAllVisible) {
				try {
					WebElement seeAllButton = currentContainer.findElement(By.xpath(seeAllButtonXPath));

					// Scroll to the button to ensure visibility and check if clickable
					js.executeScript("arguments[0].scrollIntoView(true);", seeAllButton);
					wait.until(ExpectedConditions.elementToBeClickable(seeAllButton));

					// Click using JavaScript to avoid intercept issues
					js.executeScript("arguments[0].click();", seeAllButton);
					pass("clicked on SeeALLButton");
					Thread.sleep(3000); // Wait for courses to load
				} catch (Exception e) {
					pass("Unable to click on See all button due to Few courses");
					seeAllVisible = false; // Button no longer available
				}
			}

			// Count all expanded courses in "All Courses" page
			List<WebElement> expandedCourses = currentContainer.findElements(By.xpath(courseCardXPath));
			allCoursesPageCount = expandedCourses.size();
			System.out.println("Expanded number of courses in container " + (i + 1) + ": " + allCoursesPageCount);

			List<WebElement> elements = currentContainer.findElements(By.xpath(cardsnames));

			for (WebElement webElement2 : elements) {

				String text = webElement2.getText();
//                	System.out.println(text);
				cards.add(text);
			}

			// **Scroll back up to the top of the page before selecting from the dropdown**
			js.executeScript("window.scrollTo(0, 0);");
			Thread.sleep(2000); // Allow some time for the page to scroll to the top

			searchboxXpath.sendKeys(cards.get(i));
			searchboxXpath.sendKeys(Keys.ENTER);
			
			pass("entered Search data on search box field");
			Thread.sleep(2000);

			WebElement resultcount = driver.findElement(By.xpath(results));
			String text = resultcount.getText();
			int a = extractintvalue(text);
			if (a <= 0) {
				System.out.println("NO course found");
				fail("No courses found");
			} else {
				System.out.println("Count of Courses Found:" + text);
				pass("Courses found");
			}

			clickbyXpath(allcoursebtn, "All Course Button");
			Thread.sleep(3000);
			js.executeScript("window.scrollTo(0, 0);");
			Thread.sleep(3000);
			subjectcontainers = driver.findElements(By.xpath(subjectContainerXPath));

		}

	}

}