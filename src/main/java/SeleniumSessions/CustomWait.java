package SeleniumSessions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {
   // condn is : you need not to use selenium waits(imp & exp) so we have to use sleep
	static WebDriver driver;

	public static void main(String[] args) {

		// use only sleep();
		// imp interview ques
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-email11");
		
		retryingElement(emailId).sendKeys("test@gmail.com");

	}

	public static WebElement retryingElement(By locator) {// its kind of polling method in cypress
		WebElement element = null;
		int attempts = 0;
		while(attempts < 20) {
			try {
				element = driver.findElement(locator);
				break;
			}
			catch(NoSuchElementException e) {
				try {
					Thread.sleep(1000);// when we use thread.sleep then autoamatically try catch aa jaate hai
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("element is not found in attempt : " + (attempts+1));
			}
			attempts++;
		}
		return element;
	}

}
