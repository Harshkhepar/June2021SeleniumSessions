package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandle {

	public static void main(String[] args) throws InterruptedException {

		//browser window pop up/new tab window/new browser window
		// browser window is not a authentication popup---its a separate browser or window
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");//parent window
         Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='https://twitter.com/orangehrm?lang=en']")).click();
		//child window -- twitter page
		
		// till now driver is in the parent window, khud va khud driver child window mai nahi chale jaega
		
		Set<String> handles = driver.getWindowHandles();// to get the window id(driver ko move krwane k liye chaiye),
		//we used "getWindowHandles" method
		// Set mai daalte he memory mai 2 hiso mai Set divide ho jaega(parent win id and child win id)
		// Set can't take the duplicate values but list can so we use Set here.
		// Set doesn't maintain index but ArrayList does
		 
		
		Iterator<String> it = handles.iterator();// "itereator" is used to fetch the data in orderless collections and here Set is orderless 
		// it does not maintain index
		String parentWindowID = it.next();// we have to move our iterator to next for getting the parent window id
		//jo iterator hota hai na vo direct parent wind pr ni hota just above hota hai tabi it.next kia k parent pr aaja
		// suppose hmari parent wind 100th segment mai hai memory mai toh iterator just above hoga means 99th segment mai hoga
		System.out.println("parent window id is : " + parentWindowID);
		
		String childWindowId = it.next();
		System.out.println("child window id is : " + childWindowId);
		
		// till now driver is in the parent window
		
		//switching:
		driver.switchTo().window(childWindowId);// ye window method window id maangta hai driver ko switch krane k liye
		//isliye hume window id ki requirement padhti hai
		System.out.println("child window url : " + driver.getCurrentUrl());
		
		driver.close();//close the child window
		// now driver is lost so we have to move driver to parent window
		driver.switchTo().window(parentWindowID);
		System.out.println("parent window url : " + driver.getCurrentUrl());

		// People will ask you i want to use List not Set then how---see in next chapter
	}

}