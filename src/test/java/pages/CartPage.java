package pages;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.Reporter;
import java.util.List;

import wrappers.WebApplicationWrappers;

public class CartPage extends WebApplicationWrappers {
	private WebDriver driver;

	static ExtentTest test;
	static ExtentReports report;
	private WebDriverWait wait;

	public CartPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.jsExecutor = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//div[contains(@class,'Cart_Screen_cart_Section_2_Content_View__I7ffx')]")
	private WebElement Totalbox;

	@FindBy(xpath = "//div[contains(@class,'Header_Component_isShoppingCartCount__Tz9V2')]")
	private WebElement cartIconcount;

	@FindBy(xpath = "//div[contains(@class,'Header_Component_icon_Link_View__+uR-M')]")
	private WebElement cartIcon;

	@FindBy(xpath = "//div[contains(text(),'All Courses')]")
	private WebElement Allcoursebutton;

	@FindBy(xpath = "//div[contains(@class,'All_Courses_course_Container__XYjdI')]")
	private List<WebElement> Allcoursecontainer;

	@FindBy(xpath = "//div[contains(@class,'Course_Content_add_Cart_Button_View__f7mAH')]")
	private WebElement addToCartButton;

	@FindBy(xpath = "//div[contains(@class,'Cart_Screen_cart_Card_View__IZJXC')]")
	private List<WebElement> cartItems;

	@FindBy(xpath = ".//div[contains(@class,'Cart_Screen_courseName_Text__CQLJi')]")
	private WebElement cartname;

	@FindBy(xpath = "//div[contains(@class,'Cart_Screen_cart_Card_View__IZJXC')]")
	private List<WebElement> cartList;

	@FindBy(xpath = "//div[contains(@class,'Cart_Screen_cart_Section_2_Course_List__+UH8f')]")
	private List<WebElement> totalpanelcartpage;// Cart_Screen_cart_Section_2_Course_Price__j0oUV

	@FindBy(xpath = "//div[contains(@class,'Cart_Screen_total_Price_Text__Znzfe')]")
	private WebElement Totalvalue;

	@FindBy(xpath = "//div[contains(@class,'Cart_Screen_no_Item_Text__rQL5y')]")
	private WebElement cartplaceholder;

	@FindBy(xpath = "//div[contains(@class,'Cart_Screen_explore_Now_Text__54bV2')]")
	private WebElement exploreBtncartpage;

	@FindBy(xpath = "//div[contains(@class,'All_Courses_select_Grade_Text__yAteO')]")
	private WebElement Selectsubject;

	@FindBy(xpath = "//div[contains(@class,'Cart_Screen_buyNow_Button_Text__')]")
	private WebElement Buynowbtn;

	@FindBy(xpath = "//div[contains(@class,'Cart_Screen_cart_Title__')]")
	private WebElement PaymentOption;

	@FindBy(xpath = "//button[contains(@class,'Paypal_Payment_cancelButton__')]")
	private WebElement paymentCancelbtn;

	public void verifyaddedcoursesandcountofcarticonwithcartpage() {

		clickbyXpath(Allcoursebutton, "All course");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Get all the course elements inside the container
		List<WebElement> courseList = driver.findElements(By.xpath("//div[contains(@class,'All_Courses_card_View')]"));

		List<String> addedCourses = new ArrayList<>();

		// Loop through the first 5 courses
		for (int i = 0; i < 5; i++) {
			if (i < courseList.size()) {
				// Get the current course element
				WebElement course = courseList.get(i);

				// Scroll the course into view using JavaScript if it's not visible
				js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", course);

				// Extract and print course name for verification
				WebElement courseNameElement = course
						.findElement(By.xpath(".//div[contains(@class,'All_Courses_course_Name')]"));
				String courseName = courseNameElement.getText();

				addedCourses.add(courseName);

				WebElement exploreButton = course
						.findElement(By.xpath(".//div[contains(@class,'All_Courses_exploreButton_View')]"));
				exploreButton.click();
				pass("Navigating to course: " + courseName);

				try {
					Thread.sleep(3000); // Adjust the wait time based on page load speed
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				addToCartButton.click();
				driver.navigate().back();

				pass("Navigated back to AllCourse page");

				try {
					Thread.sleep(3000); // Adjust the wait time as needed
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// Re-fetch the course list to avoid stale elements after navigation
				courseList = driver.findElements(By.xpath("//div[contains(@class,'All_Courses_card_View')]"));

			} else {
				pass("Not enough courses available to repeat the process 5 times.");
				break;
			}
		}

		String cartcount = null;
		if (cartIconcount.isDisplayed()) {
			cartcount = cartIconcount.getText();
			pass(" Values displayed on cartcount : " + cartcount);
		} else {
			fail("No values Dislayed on cart count");
		}
		int cartCount = Integer.parseInt(cartcount);
		clickbyXpath(cartIcon, "clicking  on Carticon");
		List<String> cartCourseName = new ArrayList<>();
		for (int i = 0; i < cartItems.size(); i++) {
			if (i < cartItems.size()) {
				// Get the current course element
				WebElement cart = cartItems.get(i);
				WebElement cartname = cart
						.findElement(By.xpath(".//div[contains(@class,'Cart_Screen_courseName_Text')]"));
				String cartCourseNames = cartname.getText();
				cartCourseName.add(cartCourseNames);
			} else {
				pass("cart items has lesser than 1 items ");
			}

		}
		String string = cartCourseName.toString();
		for (String course : addedCourses) {
			boolean allCoursesPresent = true;
			if (!string.contains(course)) {
				System.out.println("Course not found in the cart: " + course);
				allCoursesPresent = false;
			}

			if (allCoursesPresent) {
				System.out.println("All courses successfully added to the cart!");
			} else {
				System.out.println("Some courses are missing from the cart.");
			}
		}

		// get count of cart items and compare with cart icon count
		int cartsize = cartItems.size();
		if (cartCount == cartsize) {

			pass("Courses displayed in cart page is(" + cartsize + ") equal to Cart count displayed in icon("
					+ cartCount + ")");
		} else {
			fail("Courses displayed in cart page is(" + cartsize + ") not  equal to Cart count displayed in icon("
					+ cartCount + ")");
		}
	}

	public void verifysubtotalwithcoursepriceandchecktotal() {

		int calculatedTotal = 0;
		List<WebElement> cartList = driver
				.findElements(By.xpath("//div[contains(@class,'Cart_Screen_cart_Card_View')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Verify that both lists have the same size
		if (cartList.size() != totalpanelcartpage.size()) {
			System.out.println("Mismatch in the number of items: cartList size = " + cartList.size()
					+ ", totalpanelcartpage size = " + totalpanelcartpage.size());
			return; // Exit early if sizes don't match to avoid index issues
		}

		// Iterate through the cart elements
		for (int i = 0; i < cartList.size(); i++) {

			WebElement cartLists = cartList.get(i);
			js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", cartLists);

			// Get the price and course name from the cart section
			WebElement cartprice = cartLists.findElement(
					By.xpath(".//div[contains(@class,'Cart_Screen_cart_Card_Content_View_2_Price_Text')]"));
			WebElement coursename = cartLists
					.findElement(By.xpath(".//div[contains(@class,'Cart_Screen_courseName_Text')]"));
			String cartPrice = cartprice.getText();
			String ele1 = coursename.getText();
			String numericValue = cartPrice.replaceAll("[^0-9]", "");
			int rightpanel = Integer.parseInt(numericValue);

			// Now access the corresponding elements in `totalpanelcartpage`
			WebElement Totalpanel = totalpanelcartpage.get(i);

			// Get the price and course name from the total panel section
			WebElement Subtotal = Totalpanel
					.findElement(By.xpath(".//div[contains(@class,'Cart_Screen_cart_Section_2_Course_Price')]"));
			WebElement cartnameleft = Totalpanel
					.findElement(By.xpath(".//div[contains(@class,'Cart_Screen_cart_Section_2_Course_Name')]"));
			String subTotal = Subtotal.getText();
			String ele2 = cartnameleft.getText();
			numericValue = subTotal.replaceAll("[^0-9]", "");
			int leftpanel = Integer.parseInt(numericValue);
			calculatedTotal += leftpanel;

			// Print debugging information
			System.out.println("Comparing prices for: " + ele1 + " and " + ele2);
			System.out.println("Right panel price: " + rightpanel + ", Left panel price: " + leftpanel);

			// Compare the prices
			if (rightpanel == leftpanel) {
				Reporter.reportStep(ele1 + " - Price = " + cartPrice
						+ " displayed in cart page is equal to the subtotal panel " + ele2 + " - Price = " + subTotal,
						"TRUE");
			} else {
				Reporter.reportStep(
						ele1 + " - Price = " + cartPrice + " displayed in cart page is not equal to the subtotal panel "
								+ ele2 + " - Price = " + subTotal,
						"Fail");

			}
		}

		// to compare all the course prices value with total value

		String Total = Totalvalue.getText();

		String numericValue = Total.replaceAll("[^0-9]", "");
		int Totalvalue = Integer.parseInt(numericValue);
		if (calculatedTotal == Totalvalue) {
			pass("The calculated total (" + calculatedTotal + ") matches the overall total (" + Totalvalue + ").");
		} else {
			fail("The calculated total (" + calculatedTotal + ") does not match the overall total (" + Totalvalue
					+ ").");
		}

	}

	public void verifypaymentscreen() throws Exception {

		jsExecutor.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2000);
		scrollToElementAndClick(Buynowbtn);
		verifyTextContainsByXpath(PaymentOption, "Payment Option", "Payment Option");
		clickbyXpath(paymentCancelbtn, "Payment cancel button");
		verifyTextContainsByXpath(cartname, attribute, "Cart Name");

	}

	public void verifyremovebtn_placeholder_carticon() {

		// Locate cart elements
		List<WebElement> cartList = driver
				.findElements(By.xpath("//div[contains(@class,'Cart_Screen_cart_Card_View')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// If cart is empty, exit
		if (cartList.size() == 0) {
			pass("Cart is empty, no items to remove.");
			return;
		}

		String cartcount = null;

		// Loop until all items are removed
		while (cartList.size() > 0) {

			// Get the first item in the cart list (start removing from the first item)
			WebElement cartItem = cartList.get(0); // Always start from the first element
			js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", cartItem);

			// Find the remove button for this cart item
			WebElement removebtn = cartItem.findElement(By.xpath(".//div[contains(@class,'Cart_Screen_remove_Text')]"));

			// Get the current cart count before removal (check if the cart icon is still
			// displayed)
			try {
				if (cartIconcount.isDisplayed()) {
					cartcount = cartIconcount.getText();
			
					System.out.println(cartcount);
				} else {
					System.out.println("Cart icon is no longer displayed.");
					return;
				}
			} catch (NoSuchElementException e) {
				pass("Cart icon element is not found, likely due to all items being removed.");
				break; // Exit the loop since the cart icon is not found
			}

			int cartCountBefore = Integer.parseInt(cartcount);

			// Click the remove button
			try {

				jsExecutor.executeScript("window.scrollTo(0, 0);");
				Thread.sleep(2000);
				scrollToElementAndClick(removebtn);

				// Wait for the cart item to be removed
				wait.until(ExpectedConditions.stalenessOf(cartItem));

			} catch (Exception e) {
				fail("Failed to click on the remove button for item: "+cartItem);
				System.out.println("Failed to click on the remove button for item: ");
				e.printStackTrace();
				return;
			}

			// Wait for removal to process
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Get the updated cart count after removal (check if the cart icon is still
			// present)
			try {
				if (cartIconcount.isDisplayed()) {
					cartcount = cartIconcount.getText();
					System.out.println(cartcount);
				} else {
					System.out.println("Cart icon is no longer displayed.");
					break; // Exit the loop since the cart icon is not found
				}
			} catch (NoSuchElementException e) {
				pass("Cart icon element is not found, likely due to all items being removed.");
				System.out.println("Cart icon element is not found, likely due to all items being removed.");
				break;
			}

			int cartCountAfter = Integer.parseInt(cartcount);

			// Verify if the cart count has decreased
			if (cartCountBefore != cartCountAfter) {
				pass("The cart count value is decreasing after removing courses from cart page");
			} else {
				fail("The cart count value is not decreasing after removing courses from cart page");
			}

			// Recalculate the cart list after removal to avoid index issues
			cartList = driver.findElements(By.xpath("//div[contains(@class,'Cart_Screen_cart_Card_View')]"));
		}

		// Verify the empty cart placeholder and other UI elements after all items are
		// removed
		verifyTextContainsByXpath(cartplaceholder, "Your cart is empty", "Cart Placeholder");
		clickbyXpath(exploreBtncartpage, "Explorebutton cartpage");
		verifyTextContainsByXpath(Selectsubject, "Select Subject", "Select Subject");
	}

	public void verifycoursecontentpage() throws Exception {

		// Locate cart elements
		List<WebElement> cartList = driver
				.findElements(By.xpath("//div[contains(@class,'Cart_Screen_cart_Card_View')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// If cart is empty, exit
		if (cartList.size() == 0) {
			System.out.println("Cart is empty, no items to remove.");
			return;
		}

		for (int i = 0; i < cartList.size(); i++) {

			try {
				// Refresh the cart list to avoid stale elements
				cartList = driver.findElements(By.xpath("//div[contains(@class,'Cart_Screen_cart_Card_View')]"));

				// Get the first item in the cart list (start removing from the first element)
				WebElement cartItem = cartList.get(i); // Always start from the first element
				js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", cartItem);

				WebElement courseName = cartItem
						.findElement(By.xpath(".//div[contains(@class,'Cart_Screen_courseName_Text')]"));

				String before = courseName.getText();

				jsExecutor.executeScript("window.scrollTo(0, 0);");
				Thread.sleep(2000);
				scrollToElementAndClick(courseName);

				// Now find the course title on the new page
				WebElement overallCartTitle = driver
						.findElement(By.xpath("//div[contains(@class,'Course_Content_course_Title_View')]"));
				WebElement courseTitle = overallCartTitle
						.findElement(By.xpath("//div[contains(@class,'Course_Content_course_Title')]"));

				String after = courseTitle.getText();

				// Compare before and after course names
				if (before.equals(after)) {
					pass("Clicked on " + before + " in the cart and navigated to " + after
							+ " on the course content page as expected.");
				} else {
					fail("Clicked on " + before + " in the cart but navigated to " + after + " instead.");
				}

				Thread.sleep(3000);
				driver.navigate().back();
				// Wait for the cart page to reload
				Thread.sleep(3000);
				// Check if navigated back to the cart successfully
				WebElement cartPage = driver
						.findElement(By.xpath("//div[contains(@class,'Cart_Screen_cart_Section_2_Title')]"));
				String text = cartPage.getText();
				if (text.contains("Billing Details")) {
					pass("Navigated back to the cart successfully.");
				} else {
					fail("Back navigation failed.");
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale Element encountered. Retrying...");
				// Continue the loop and re-fetch elements
				continue;
			} catch (Exception e) {
				fail("An error occurred: " + e.getMessage());
				e.printStackTrace();
				return;
			}
			// Refresh the cart list after an item is removed
			cartList = driver.findElements(By.xpath("//div[contains(@class,'Cart_Screen_cart_Card_View')]"));
		}
	}

}
