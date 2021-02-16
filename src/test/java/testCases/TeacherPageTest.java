package testCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import environment.*;
import pageObjects.TeacherPage;

@TestMethodOrder(OrderAnnotation.class)
public class TeacherPageTest extends FunctionalTest {

	private TeacherPage teachers;

	public TeacherPageTest() {
		super();
		teachers = new TeacherPage(driver);
	}

	@BeforeAll
	public static void getTeacherPage() {
		driver.get(APP_URL + "/teacher");
	}

	//	@Test
	//	public void testPageHeaderTitle() {
	//		assertEquals("Teacher", teachers.getHeaderTitle());
	//	}

	@Test
	@Order(1)
	public void addNewTeacher() {
		// Save number of rows before submit
		int numberOfEntriesBeforeInsert = teachers.getNumberOfEntries();

		// Populate form fields and submit form
		teachers.addTeacher();

		// Wait update form to be opened, it is proved by that the delete button is visible
		wait.until(ExpectedConditions.visibilityOf(teachers.getRemoveTeacherButton()));
		
		// Save number of rows after submit
		int numberOfEntriesAfterInsert = teachers.getNumberOfEntries();

		assertEquals(++numberOfEntriesBeforeInsert, numberOfEntriesAfterInsert);
	}

	@Test
	@Order(2)
	public void updateTeacher() {
		// Wait table to show
		wait.until(ExpectedConditions.visibilityOf(teachers.getTableItem()));

		teachers.getTableItem().click();

		// Save name field value before update
		String nameValueBeforeUpdate = teachers.getFormNameFieldValue();

		wait.until(ExpectedConditions.visibilityOf(teachers.getForm()));

		// Update form fields and submit form
		teachers.updateTeacher();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='MuiDataGrid-colCellWrapper '][style*='270px']")));

		// This is bad aproach (not Page Object pattern), but I didn't find solution to refresh elements foundedWith @FindBy annotation
		// Save name field value after update
		String nameValueAfterUpdate = driver.findElement(By.cssSelector("div[data-field='teacherName'")).getAttribute("innerText");

		assertNotEquals(nameValueBeforeUpdate, nameValueAfterUpdate);
	}

	@Test
	@Order(3)
	public void removeTeacher() {
		// Save number of rows before delete
		int numberOfEntriesBeforeInsert = teachers.getNumberOfEntries();
		
		// Click on delete button
		teachers.getRemoveTeacherButton().click();

		// Save number of rows after delete
		int numberOfEntriesAfterInsert = teachers.getNumberOfEntries();

		assertEquals(--numberOfEntriesBeforeInsert, numberOfEntriesAfterInsert);
	}
}
