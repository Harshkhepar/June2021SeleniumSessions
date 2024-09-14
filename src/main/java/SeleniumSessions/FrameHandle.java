package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// iframes or frames
		
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		// total no. of frames in page
		List<WebElement> frameList = driver.findElements(By.tagName("frame"));
		System.out.println(frameList.size()); // total no. of frames
		//driver.switchTo().frame(2);  --->// by passing index of frame ---> 1st method
		//driver.switchTo().frame("main"); // by passing name or id ----> 2nd method
		// Note : Frame method is already overloaded in selenium --> exp of method overloading in selenium
		driver.switchTo().frame(driver.findElement(By.name("main")));// by passing the webElement--> 3rd method
		// Frame is also a webElement
		
		String header = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(header);
		
		driver.switchTo().defaultContent();
		
	}

}