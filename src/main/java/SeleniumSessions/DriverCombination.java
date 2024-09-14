 package SeleniumSessions;


import org.openqa.selenium.SearchContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverCombination {

	public static void main(String[] args) {

	//	System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/chromedriver");
        WebDriverManager.chromedriver().setup();
//		ChromeDriver driver = new ChromeDriver();
//		
//		
		RemoteWebDriver driver = null;
		driver.get("http://www.google.com");// NPE bcoz driver is null
		String browser = "chrome";

		// cross browser testing:
		if (browser.equals("chrome")) {
	        WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
	        WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("please pass the correct browser....");
		}
		
		//top casting: searchContext > CD
		//SearchContext dr = new ChromeDriver();// gives only findelement() and findelements(), 
		//can't get other method like get URL, getText
		
		
		//top casting: Webdriver > RWD
		//WebDriver d = new RemoteWebDriver(remoteAddress, capabilities)
		
		
		
	}

}