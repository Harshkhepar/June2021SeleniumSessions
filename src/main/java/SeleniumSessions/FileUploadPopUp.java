package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopUp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		//tagname could be anything but type="file" IS MANDATORY then we can handle this pop up
		//<input type="file" name="upfile">
		//after finding the element we don't need to click
		driver.findElement(By.name("upfile")).sendKeys("/Users/naveenautomationlabs/Downloads/selenium.png");
		// in Sendkeys we have to give path of the file in our system
		
		
	}

}