package testCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import environment.*;
import pageObjects.StudentPage;

@TestMethodOrder(OrderAnnotation.class)
public class StudentPageTest extends FunctionalTest {

	private StudentPage students;

	public StudentPageTest() {
		super();
		students = new StudentPage(driver);
	}

	@BeforeAll
	public static void getStudentPage() {
		driver.get(APP_URL + "/student");
	}

	//	@Test
	//	public void testPageHeaderTitle() {
	//		assertEquals("Student", students.getHeaderTitle());
	//	}

	@Test
	@Order(1)
	public void addNewStudent() {
		// Save number of rows before submit
		int numberOfEntriesBeforeInsert = students.getNumberOfEntries();

		// Populate form fields and submit form
		students.addStudent();

		// Wait update form to be opened, this means that delete button is shown
		wait.until(ExpectedConditions.visibilityOf(students.getRemoveStudentButton()));
		
		// Save number of rows after submit
		int numberOfEntriesAfterInsert = students.getNumberOfEntries();

		assertEquals(++numberOfEntriesBeforeInsert, numberOfEntriesAfterInsert);
	}

	@Test
	@Order(2)
	public void updateStudent() {
		// Wait table to show
		wait.until(ExpectedConditions.visibilityOf(students.getTableItem()));

		// Save name field value before update
		String nameValueBeforeUpdate = students.getFormNameFieldValue();

		// Update form fields and submit form
		//students.updateStudent();
		
		// Save name field value after update
		String nameValueAfterUpdate = driver.findElement(By.cssSelector("div[data-field='name']")).getAttribute("innerText");

		assertNotEquals(nameValueBeforeUpdate, nameValueAfterUpdate);
	}

	@Test
	@Order(3)
	public void removeStudent() {
		// Save number of rows before delete
		int numberOfEntriesBeforeInsert = students.getNumberOfEntries();
		
		// Click on delete button
		students.getRemoveStudentButton().click();

		// Save number of rows after delete
		int numberOfEntriesAfterInsert = students.getNumberOfEntries();

		assertEquals(--numberOfEntriesBeforeInsert, numberOfEntriesAfterInsert);
	}
}
