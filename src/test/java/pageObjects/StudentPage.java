package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import environment.PageObject;

public class StudentPage extends PageObject {

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
	@FindBy(name = "name")
	private WebElement name;

	@FindBy(name = "surname")
	private WebElement surname;

	@FindBy(name = "accountName")
	private WebElement accountName;

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(name = "bankCardNumber")
	private WebElement bankCardNumber;

	@FindBy(css = "button[data-test-id='courses']")
	private WebElement toggleCoursesButton;

	@FindBy(css = "button[data-test-id='delete']")
	private WebElement removeStudentButton;

	// FORM Submit button
	@FindBy(css = "button[data-test-id='save']")
	private WebElement formSubmitButton;

	// FORM for course enrollment
	@FindBy(className = "MuiDataGrid-root MuiDataGrid-root")
	private WebElement enrollCourseForm;

	@FindBy(css = "button[data-test-id='add-courses'")
	private WebElement addCourseButton;

	@FindBy(css = "label[for='formik-select-field-3042']")
	private WebElement courseDropdown;

	@FindBy(css = "li[tabindex='0']")
	private WebElement coursesDropdownItem;

	@FindBy(name = "classesBought")
	private WebElement classes;
	
	public StudentPage(WebDriver driver) {
		super(driver);
	}

	public void addStudent() {
		 // Open a form for inserting a student
		this.formInsertOpenButton.click();

		// Populate insert form fields
		this.name.sendKeys("TEST_QA_Name");

		this.surname.sendKeys("TEST_QA_Surname");

		this.accountName.sendKeys("TEST_QA_AccountName");

		this.email.sendKeys("TEST_QA@mail.com");

		this.bankCardNumber.sendKeys("0000");

		// Submit form
		this.formSubmitButton.click();
	}

	public void updateStudent() {
		// Open a form for updating a student
	   this.tableItem.click();

	   // Populate update form fields
	   this.name.sendKeys("_UPDATE");

	   this.surname.sendKeys("_UPDATE");

	   this.email.clear();
	   this.email.sendKeys("UPDATE@mail.com");

	   // Submit form
	   this.formSubmitButton.click();
   }

   public void enrollCourseForStudent() {
	   this.addCourseButton.click();

	   this.courseDropdown.click();

	   this.coursesDropdownItem.click();

	   this.classes.sendKeys("1");
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

	public WebElement getEnrollCourseForm() {
		return this.enrollCourseForm;
	}

	public WebElement getCoursesDropdownButton() {
		return this.courseDropdown;
	}

	public WebElement getRemoveStudentButton() {
		return this.removeStudentButton;
	}
	
	public WebElement getToggleCoursesButton() {
		return this.toggleCoursesButton;
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
