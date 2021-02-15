package testCases;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import environment.*;
import pageObjects.StudentPage;

public class StudentPageTest extends FunctionalTest {

	private StudentPage students;

	public StudentPageTest() {
		super();
		driver.get(APP_URL + "/students");
		students = new StudentPage(driver);
	}

	// @Test
	// public void testPageHeaderTitle() {
	// assertEquals("Student", students.getHeaderTitle());
	// }

	@Test
	public void addNewStudent() {
		// Save number of rows before submit
		int numberOfEntriesBeforeInsert = students.getNumberOfEntries();

		// Populate form fields and submit form
		students.addStudent();

		// Wait URL to be changed, this means that update form is opened, so new entry
		// is inserted
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("div[data-rowindex=" + '\'' + numberOfEntriesBeforeInsert + '\'' + "]")));

		assertFalse(students.isTableEmpty());
	}
}
