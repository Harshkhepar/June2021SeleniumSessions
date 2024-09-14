 package SeleniumSessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	static WebDriver driver;
	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)// different waay to write FluentWait object
//								.withTimeout(Duration.ofSeconds(10))
//								.pollingEvery(Duration.ofMillis(2000))
//								.ignoring(NoSuchElementException.class);// this is for ignoring the exception(not compulsory to write)
//		
//		wait.until(ExpectedConditions.presenceOfElementLocated(emailId)).sendKeys("naveen@gmail.com");
		
//		we can also do this with WebDriverWait so hence proved there is no difference btw FluentWait and WebDriverWait
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.
		withTimeout(Duration.ofSeconds(10)).// these three features coming from fluentwait feature
		pollingEvery(Duration.ofMillis(2000)).
		ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(emailId)).sendKeys("naveen@gmail.com");
		
		
	}
	
	public static WebElement waitForElementWithFluentWait(By locator, int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class);
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	public static WebDriver waitForFrameWithFluentWait(By locator, int timeOut, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class);
		
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	
	
	

}