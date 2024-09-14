package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This is my BrowserUtil class where i stored all Browser related actions
 * 
 * @author harsh
 *
 */

public class BrowserUtil {
	static WebDriver driver;

	public WebDriver lauchBrowser(String browserName) {
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("Please pass the correct browser");
		}
		return driver;
	}

	/**
	 * @param: URL
	 * 
	 */

	public void getPageUrl(String url) {
		if (url == null) {
			return;
		}
		if (url.isEmpty()) {
			return;
		}
		driver.get(url);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();

	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getCurrentPageSource() {
		return driver.getPageSource();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}
