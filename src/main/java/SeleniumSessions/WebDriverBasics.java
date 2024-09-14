package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverBasics {

	public static void main(String[] args) {

		//win;
		//System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
		
	
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\harsh\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
	//	WebDriverManager.firefoxdriver().setup();
		//1.Automation Steps:
		//top casting: 
		WebDriver driver = new ChromeDriver();//launch browser
		
		//enter the url:
		driver.get("https://www.google.com");
		
		//get the title:
		String title = driver.getTitle();
		System.out.println("page title is: " + title);
		
		//2.validation point/checkpoint/act vs exp result
		if(title.equals("Google")) {
			System.out.println("correct title");
		}
		else {
			System.out.println("incorrect title");
		}
		
		//automation steps + validation point--> automation testing
		
		driver.quit();//close the browser
		
	}

}
