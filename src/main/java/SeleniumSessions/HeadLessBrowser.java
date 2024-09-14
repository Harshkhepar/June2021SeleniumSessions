package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessBrowser {

	public static void main(String[] args) {

		//headless - no browser
		//testing is happening behind the scene
		//slightly faster
		
		//disadv : really don't know  where is driver and for pop ups its not good
	
		WebDriverManager.chromedriver().setup();
		
//		FirefoxOptions fo = new FirefoxOptions();
//		fo.addArguments("--headless");
		
		ChromeOptions co = new ChromeOptions();//ChromeOptions is the class responsible for headless
		co.addArguments("--headless");
//		co.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(co);
		
		//WebDriver driver = new FirefoxDriver(fo);
		driver.get("http://wwww.amazon.com");
		
		System.out.println(driver.getTitle());
		driver.quit();
		
		
		
		
	}

}
