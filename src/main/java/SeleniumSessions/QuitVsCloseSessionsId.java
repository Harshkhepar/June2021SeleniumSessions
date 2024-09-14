package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuitVsCloseSessionsId {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();// launch browser

		driver.get("https://www.google.com");

		String title = driver.getTitle();
		System.out.println("page title is: " + title);//Google

		System.out.println(driver.getCurrentUrl());

		//driver.quit();
		//System.out.println(driver.getTitle());// NoSuchSession(exception)-- means session id is null -- in case of quit
		driver.close(); //close browser	    
		System.out.println(driver.getTitle());// NoSuchSession(exception)--invalid or Expired session id means session id is not null --- in case of close
		
		//reopen the browser:to resolve the above problem
//		driver = new ChromeDriver();// reinstialize the driver and now they have different session id
//		driver.get("https://www.google.com");
//		System.out.println(driver.getTitle());

	}

}