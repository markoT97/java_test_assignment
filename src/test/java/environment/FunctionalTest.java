package environment;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * <strong>FunctionalTest</strong> handles setup and teardown of WebDriver.
 * 
 * @author Kim Schiller
 */

public class FunctionalTest {
	protected static final String APP_URL = "http://localhost:3000";

	protected static WebDriver driver;
	protected static WebDriverWait wait;

	@BeforeAll
	public static void setUp() {
		String path = System.getProperty("user.dir");
		String browser = System.getProperty("browser");

		// Set up changeable browser by passed parameter
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", path + "\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", path + "\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case "firefox":
		default:
			System.setProperty("webdriver.gecko.driver", path + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		
		driver.manage().window().setSize(new Dimension(1280, 768));
		wait = new WebDriverWait(driver, 10);
	}

	@AfterAll
	public static void cleanUp() {
		driver.manage().deleteAllCookies();
	}

	@AfterAll
	public static void tearDown() {
		driver.close();
	}
}
