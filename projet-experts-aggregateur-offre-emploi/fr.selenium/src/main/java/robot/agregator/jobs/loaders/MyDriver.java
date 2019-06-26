package robot.agregator.jobs.loaders;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {

	private static final String FIREFOX = "firefox";
	private static final String CHROME = "chrome";
	private static final String EDGE = "edge";
	private static final String PATH_FIREFOX_DRIVER = "C:\\webdrivers\\geckodriver.exe";
	private static final String PATH_EDGE_DRIVER = "C:\\webdrivers\\msedgedriver.exe";
	private static final String PATH_CHROME_DRIVER = "C:\\webdrivers\\chromedriver.exe";
	public static WebDriver driver;
	
	
	// lancement du driver (chrome par défaut)
	public MyDriver(String browser) {
		super();
		try {
			switch (browser) {
			case FIREFOX:
				System.setProperty("webdriver.firefox.marionette", PATH_FIREFOX_DRIVER);
				System.out.println("Loading Firefox WebDriver");
				driver = new FirefoxDriver();
				break;

			case EDGE:
				System.setProperty("webdriver.edge.driver", PATH_EDGE_DRIVER);
				System.out.println("Loading Edge WebDriver");
				driver = new EdgeDriver();
				break;
				
			case CHROME:
				System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
				System.out.println("Loading Chrome WebDriver");
				driver = new ChromeDriver();
				break;
				
			default:
				System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
				System.out.println("Loading Chrome WebDriver");
				driver = new ChromeDriver();
				break;
			}

			setDriverProperties();

		} catch (Exception e) {
			System.out.println(String.format(
					"A problem was detected while loading the driver of your test for the browser: %s", browser));
			System.out.println(e);
		} finally {

		}

	}

	public MyDriver() {
		super();
		new MyDriver("chrome");
	}

	public WebDriver getDriver() {
		if (driver == null) {
			new MyDriver();
			return driver;
		}
		return driver;
	}

//	private void setDriver(WebDriver driver) {
//		DriverInit.driver = driver;
//	}

	private void setDriverProperties() {
		System.out.println("This is test is launched from: " + System.getProperty("user.dir"));
		driver.manage().window().maximize();
		// Implicit wait - used to set the default waiting time throughout the program
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void closeDriver() {
		driver.close(); // closes a single window
	}

	public static void quitDriver() {
		driver.quit(); // closes all windows
	}

}
