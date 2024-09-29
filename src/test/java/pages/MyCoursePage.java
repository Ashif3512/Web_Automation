package pages;


import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import wrappers.WebApplicationWrappers;

public class MyCoursePage extends WebApplicationWrappers {

	private WebDriver driver;

	static ExtentTest test;
	static ExtentReports report;

	@FindBy(xpath = "//div[text()='Home']//following-sibling::div[1]")
	private WebElement myCourseButton;
	
	public WebElement gotoCourseButton(int coursenum) {
	    	return driver.findElement(By.xpath("(//div[contains(@class,'My_Courses_myCourse_Button_Text')])["+coursenum+"]"));
	    }
	


	public MyCoursePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.jsExecutor = (JavascriptExecutor) driver;
	}

	@FindBy(xpath = "//div[contains(text(),'My Courses')]")
	private WebElement Mycoursebtn;

	@FindBy(xpath = "//div[contains(@class,'My_Courses_myCourse_Title')]")
	private WebElement Mycoursetitle;

	@FindBy(xpath = "//div[contains(@class,'My_Courses_myCourse_Body_Container')]")
	private List<WebElement> Mycoursebody;

	@FindBy(xpath = "//div[contains(@class,'My_Courses_myCourse_Card_View')]")
	private List<WebElement> coursecardviewer;

	@FindBy(xpath = "//div[contains(@class,'My_Courses_myCourse_Button_Text')]")
	private WebElement gotocoursebtn;

	@FindBy(xpath = "//div[contains(@class,'My_Courses_myCourse_Completion_Text')]")
	private WebElement completionpercent;

	@FindBy(xpath = "//div[contains(@class,'My_Courses_myCourse_Assets_Text')][1]")
	private WebElement totalVideos;

	@FindBy(xpath = "//div[contains(@class,'My_Courses_myCourse_Assets_Text')][2]")
	private WebElement completedVideos;

	@FindBy(xpath = "//div[contains(@class,'My_Courses_myCourse_Assets_Text')][3]")
	private WebElement pendingVideos;

	@FindBy(xpath = "//div[contains(@class,'My_Courses_myCourse_CourseName_Text')]")
	private WebElement coursenames;

	@FindBy(xpath = "//div[contains(@class,'Course_Content_course_Title')]")
	private WebElement coursenamecoursecontentpage;

	@FindBy(xpath = "//div[contains(@class,'Course_Content_course_Content_Section_2')]")
	private List<WebElement> coursecontentsection;

	@FindBy(xpath = "//div[contains(@class,'Cart_Screen_cart_Card_View')]")
	private List<WebElement> cartItems;

	@FindBy(xpath = "//div[contains(@class,'Header_Component_icon_Link_View')]")
	private WebElement cartIcon;

	public void verifymycoursesnotequalscartpagecourses() throws Exception {

		List<String> MyCourses = new ArrayList<>();
		List<String> CartCourses = new ArrayList<>();

		Thread.sleep(3000); // Wait for the page to load completely
		clickbyXpath(Mycoursebtn, "My course button"); // Click the "My Course" button
		verifyTextContainsByXpath(Mycoursetitle, "My Courses", "My course title "); // Verify the title is "My Courses"

		// Initialize the JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		int size = coursecardviewer.size();

		// Loop through each course card
		for (int i = 1; i <= coursecardviewer.size(); i++) {

			WebElement elements = driver
					.findElement(By.xpath("(//div[contains(@class,'My_Courses_myCourse_Card_View')])[" + i + "]"));

			js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", elements);

			WebElement courseNameElement = elements.findElement(
					By.xpath("(//div[contains(@class,'My_Courses_myCourse_CourseName_Text')])[" + i + "]"));

			String courseName = courseNameElement.getText();

			System.out.println("Course Name: " + courseName);

			MyCourses.add(courseName);

			String ele;

			WebElement totalVids = elements
					.findElement(By.xpath("(//div[contains(@class,'My_Courses_myCourse_Assets_Text')][1])[" + i + "]"));
			ele = totalVids.getText();
			int inttotalvids = extractintvalue(ele);
			System.out.println(inttotalvids);

			WebElement completedVids = elements
					.findElement(By.xpath("(//div[contains(@class,'My_Courses_myCourse_Assets_Text')][2])[" + i + "]"));
			ele = completedVids.getText();
			int intcompletedvids = extractintvalue(ele);
			System.out.println(intcompletedvids);

			WebElement pendingVids = elements
					.findElement(By.xpath("(//div[contains(@class,'My_Courses_myCourse_Assets_Text')][3])[" + i + "]"));
			ele = pendingVids.getText();
			int intpendingvids = extractintvalue(ele);
			System.out.println(intpendingvids);

			WebElement completionStatus = elements.findElement(
					By.xpath("(//div[contains(@class,'My_Courses_myCourse_Completion_Text')])[" + i + "]"));
			ele = completionStatus.getText();
			int intcompletionstatus = extractintvalue(ele);
			WebElement goToCourseBtn = elements
					.findElement(By.xpath("(//div[contains(@class,'My_Courses_myCourse_Button_Text')])[" + i + "]"));

			js.executeScript("arguments[0].click();", goToCourseBtn);

			// Wait for the course content page to load and verify the course name
			verifyTextContainsByXpath(coursenamecoursecontentpage, courseName, "Course Content page title");

			WebElement totalcourseCC = driver
					.findElement(By.xpath("(//div[contains(@class,'Course_Content_doc_Assests_num')])[1]"));
			ele = totalcourseCC.getText();
			int inttcCC = extractintvalue(ele);
			System.out.println(inttcCC);

			if (inttcCC != inttotalvids) {

				fail("Totalcourses counts are not same");
			} else {
				pass("TotalCourses counts are same");
			}

			// Navigate back to the "My Courses" page
			String currentUrl = driver.getCurrentUrl();
			driver.navigate().back();
			String currentUrl2 = driver.getCurrentUrl();
			if (currentUrl != currentUrl2) {
				System.out.println("page navigated back to Mycourse page ");
			} else {
				System.out.println("not navigted bck");
			}

			Thread.sleep(2000);

		}

		clickbyXpath(cartIcon, "clicking  on Carticon");

		for (int i = 0; i < cartItems.size(); i++) {
			if (i < cartItems.size()) {

				WebElement cart = cartItems.get(i);

				WebElement cartname = cart
						.findElement(By.xpath(".//div[contains(@class,'Cart_Screen_courseName_Text')]"));
				String cartCourseNames = cartname.getText();

				CartCourses.add(cartCourseNames);

			} else {
				System.out.println("cart items has lesser than 1 items ");
			}

		}

		boolean areequals = MyCourses.equals(CartCourses);

		if (areequals) {
			System.out.println("Courses are  same,Fail");
		} else {
			System.out.println("courses are not same,Pass ");
		}

	}

	public void clickMyCourseButton() {
		clickbyXpath(myCourseButton, " My Course Button ");
	}

	public void clickGotoCourseButton(int courseNo) {
		clickbyXpath(gotoCourseButton(courseNo), " Goto Course Button ");
	}

}
