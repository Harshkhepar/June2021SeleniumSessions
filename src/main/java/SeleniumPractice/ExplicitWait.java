package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {
 static WebDriver driver;
 
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By email = By.xpath("//input[@name='email']");
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement emailId = wait.until(ExpectedConditions.presenceOfElementLocated(email));
		waitforElementPresence(email, 10).sendKeys("harsh.khepar96@gmail.com");

	}
        public static WebElement waitforElementPresence(By locator,int timeOut) {
        	WebDriverWait wait = new WebDriverWait(driver, timeOut);
    		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
}
