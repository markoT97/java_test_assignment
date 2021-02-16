package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import environment.PageObject;

public class TeacherPage extends PageObject {

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
	@FindBy(name = "teacherName")
	private WebElement name;

	@FindBy(name = "teacherSurname")
	private WebElement surname;

	@FindBy(name = "teacherEmail")
	private WebElement email;

	@FindBy(css = "button[data-test-id='courses']")
	private WebElement toggleCoursesButton;

	@FindBy(css = "button[data-test-id='delete']")
	private WebElement removeTeacherButton;

	// FORM Submit button
	@FindBy(css = "button[data-test-id='save']")
	private WebElement formSubmitButton;

	
	public TeacherPage(WebDriver driver) {
		super(driver);
	}

	public void addTeacher() {
		 // Open a form for inserting a teacher
		this.formInsertOpenButton.click();

		// Populate insert form fields
		this.name.sendKeys("TEST_QA_Name");

		this.surname.sendKeys("TEST_QA_Surname");

		this.email.sendKeys("TEST_QA@mail.com");

		// Submit form
		this.formSubmitButton.click();
	}

	public void updateTeacher() {
		// Open a form for updating a teacher
	   this.tableItem.click();

	   // Populate update form fields
	   this.name.sendKeys("_UPDATE");

	   this.surname.sendKeys("_UPDATE");

	   this.email.clear();
	   this.email.sendKeys("UPDATE@mail.com");

	   // Submit form
	   this.formSubmitButton.click();
   }

   public void openCoursesForTeacher() {
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

	public WebElement getRemoveTeacherButton() {
		return this.removeTeacherButton;
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
