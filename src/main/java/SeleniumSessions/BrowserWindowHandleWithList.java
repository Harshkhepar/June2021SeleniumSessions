 package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleWithList {
  //interview ques
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");// parent window

		driver.findElement(By.xpath("//a[@href='https://twitter.com/orangehrm?lang=en']")).click();
		// child window -- twitter page

		Set<String> handles = driver.getWindowHandles();
       // create Array list here
		List<String> handlesList = new ArrayList<String>(handles);//ArrayList can take Set object also as a parameter
		// So what does above line means now we are coverting the Set object into ArrayList
		// ArrayList will maintain order

		String parentWindowID = handlesList.get(0);
		String childWidnowID = handlesList.get(1);

		driver.switchTo().window(childWidnowID);
		System.out.println("child window url : " + driver.getCurrentUrl());

		driver.close();// close the child window

		driver.switchTo().window(parentWindowID);
		System.out.println("parent window url : " + driver.getCurrentUrl());

	}

}