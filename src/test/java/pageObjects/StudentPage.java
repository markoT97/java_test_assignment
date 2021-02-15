package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import environment.PageObject;

public class StudentPage extends PageObject {

	@FindBy(className = "MuiTypography-h6")
	private WebElement header;

	@FindBy(className = "rendering-zone")
	private WebElement tableRenderingZone;

	@FindBy(css = "div[aria-label='grid'")
	private WebElement table;

	@FindBy(className = "MuiTablePagination-caption")
	private WebElement tablePagination;

	@FindBy(css = "button[aria-label='add']")
	private WebElement formInsertOpenButton;

	// FORM Insert
	@FindBy(id = "formik-text-field-2")
	private WebElement nameInsert;

	@FindBy(id = "formik-text-field-4")
	private WebElement surnameInsert;

	@FindBy(id = "formik-text-field-6")
	private WebElement accountNameInsert;

	@FindBy(id = "formik-text-field-8")
	private WebElement emailInsert;

	@FindBy(id = "formik-text-field-10")
	private WebElement bankCardNumberInsert;

	// FORM Update
	@FindBy(id = "formik-text-field-22")
	private WebElement nameUpdate;

	@FindBy(id = "formik-text-field-24")
	private WebElement surnameUpdate;

	@FindBy(id = "formik-text-field-28")
	private WebElement emailUpdate;

	@FindBy(css = "button[data-test-id='save']")
	private WebElement formUpdateSubmitButton;

	@FindBy(css = "button[data-test-id='courses']")
	private WebElement toggleCoursesButton;

	// FORM Submit button
	@FindBy(css = "button[data-test-id='save']")
	private WebElement formSubmitButton;

	
	public StudentPage(WebDriver driver) {
		super(driver);
	}

	public void addStudent() {
		 // Open a form for adding a new student
		this.formInsertOpenButton.click();

		// Populate insert form fields
		this.nameInsert.sendKeys("TEST_QA_Name");

		this.surnameInsert.sendKeys("TEST_QA_Surname");

		this.accountNameInsert.sendKeys("TEST_QA_AccountName");

		this.emailInsert.sendKeys("TEST_QA@mail.com");

		this.bankCardNumberInsert.sendKeys("0000");

		// Submit form
		this.formSubmitButton.click();
	}

	public void updateStudent() {
		// Open a form for adding a new student
	   this.formInsertOpenButton.click();

	   // Populate insert form fields
	   this.nameInsert.sendKeys("TEST_QA_Name_UPDATE");

	   this.surnameInsert.sendKeys("TEST_QA_Surname_UPDATE");

	   this.emailInsert.sendKeys("TEST_QA_UPDATE@mail.com");

	   // Submit form
	   this.formSubmitButton.click();
   }

   public void openCoursesForStudent() {
	   this.toggleCoursesButton.click();
   }

	public int getNumberOfEntries() {
		return Integer.parseInt(tablePagination.getAttribute("innerText").split(" ")[2]);
	}

	public boolean isTableEmpty() {
		return this.tableRenderingZone.getText().equals("");
	}

	public WebElement getTable() {
		return this.table;
	}
	
	public boolean isInitialized() {
		return header.isDisplayed();
	}

	public String getHeaderTitle(){
		return header.getText();
	}

}
