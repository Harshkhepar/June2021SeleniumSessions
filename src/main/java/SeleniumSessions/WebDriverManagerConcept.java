package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {
  
		
	// WebDriverManager helps to resolve the problem occurs when browsers is updated then our executable files like chromeDriver.exe
	// and geckoDriver should be upgraded again and again. So this is a problem which WebDrivermanger will resolve
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();

		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.amazon.com");
		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		driver.quit();

	}

}