package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import environment.PageObject;

public class CoursePage extends PageObject {

	@FindBy(className = "MuiTypography-h6")
	private WebElement header;

	@FindBy(css = "div[data-rowindex='0']")
	private WebElement tableItem;

	@FindBy(className = "MuiTablePagination-caption")
	private WebElement tablePagination;

	@FindBy(css = "button[aria-label='add']")
	private WebElement formInsertOpenButton;

	@FindBy(css = "form")
	private WebElement form;

	// FORM (Insert, Update)
	@FindBy(name = "developerCourseName")
	private WebElement name;

	@FindBy(name = "costPerClass")
	private WebElement cost;

	@FindBy(name = "classesPerWeek")
	private WebElement classes;

	@FindBy(css = "button[data-test-id='courses']")
	private WebElement toggleCoursesButton;

	@FindBy(css = "button[data-test-id='delete']")
	private WebElement removeCourseButton;

	// FORM Submit button
	@FindBy(css = "button[data-test-id='save']")
	private WebElement formSubmitButton;

	
	public CoursePage(WebDriver driver) {
		super(driver);
	}

	public void addCourse() {
		 // Open a form for inserting a course
		this.formInsertOpenButton.click();

		// Populate insert form fields
		this.name.sendKeys("TEST_QA_Name");

		this.cost.sendKeys("1111");

		this.classes.sendKeys("1");

		// Submit form
		this.formSubmitButton.click();
	}

	public void updateCourse() {
		// Open a form for updating a course
	   this.tableItem.click();

	   // Populate update form fields
	   this.name.sendKeys("_UPDATE");

	   this.cost.sendKeys("2222");

	   this.classes.sendKeys("2");

	   // Submit form
	   this.formSubmitButton.click();
   }

   public void openCoursesForCourse() {
	   this.toggleCoursesButton.click();
   }

	public int getNumberOfEntries() {
		return Integer.parseInt(tablePagination.getAttribute("innerText").split(" ")[2]);
	}

	public WebElement getTableItem() {
		return this.tableItem;
	}

	public WebElement getForm() {
		return this.form;
	}

	public WebElement getRemoveCourseButton() {
		return this.removeCourseButton;
	}

	public String getFormNameFieldValue() {
		return this.name.getAttribute("innerText");
	}
	
	public boolean isInitialized() {
		return header.isDisplayed();
	}

	public String getHeaderTitle(){
		return header.getText();
	}

}
