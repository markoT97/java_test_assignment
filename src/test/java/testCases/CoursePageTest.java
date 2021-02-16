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
import pageObjects.CoursePage;

@TestMethodOrder(OrderAnnotation.class)
public class CoursePageTest extends FunctionalTest {

	private CoursePage courses;

	public CoursePageTest() {
		super();
		courses = new CoursePage(driver);
	}

	@BeforeAll
	public static void getCoursePage() {
		driver.get(APP_URL + "/course");
	}

	//	@Test
	//	public void testPageHeaderTitle() {
	//		assertEquals("Course", courses.getHeaderTitle());
	//	}

	@Test
	@Order(1)
	public void addNewCourse() {
		// Save number of rows before submit
		int numberOfEntriesBeforeInsert = courses.getNumberOfEntries();

		// Populate form fields and submit form
		courses.addCourse();

		// Wait update form to be opened, it is proved by that the delete button is visible
		wait.until(ExpectedConditions.visibilityOf(courses.getRemoveCourseButton()));
		
		// Save number of rows after submit
		int numberOfEntriesAfterInsert = courses.getNumberOfEntries();

		assertEquals(++numberOfEntriesBeforeInsert, numberOfEntriesAfterInsert);
	}

	@Test
	@Order(2)
	public void updateCourse() {
		// Wait table to show
		wait.until(ExpectedConditions.visibilityOf(courses.getTableItem()));

		courses.getTableItem().click();

		// Save name field value before update
		String nameValueBeforeUpdate = courses.getFormNameFieldValue();

		wait.until(ExpectedConditions.visibilityOf(courses.getForm()));

		// Update form fields and submit form
		courses.updateCourse();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='MuiDataGrid-colCellWrapper '][style*='370px']")));

		// This is bad aproach (not Page Object pattern), but I didn't find solution to refresh elements foundedWith @FindBy annotation
		// Save name field value after update
		String nameValueAfterUpdate = driver.findElement(By.cssSelector("div[data-field='developerCourseName'")).getAttribute("innerText");

		assertNotEquals(nameValueBeforeUpdate, nameValueAfterUpdate);
	}

	@Test
	@Order(3)
	public void removeCourse() {
		// Save number of rows before delete
		int numberOfEntriesBeforeInsert = courses.getNumberOfEntries();
		
		// Click on delete button
		courses.getRemoveCourseButton().click();

		// Save number of rows after delete
		int numberOfEntriesAfterInsert = courses.getNumberOfEntries();

		assertEquals(--numberOfEntriesBeforeInsert, numberOfEntriesAfterInsert);
	}
}
