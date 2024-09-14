package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
	static WebDriver driver;

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		//driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		//driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.get("https://www.freshworks.com/");
		
		//Formulae:create a webelement + perform action (click, sendkeys, getText, isDiplayed)
		//locators:
		
		//1. id -- is a static method
		
		//1st:approach
//		driver.findElement(By.id("Form_submitForm_FirstName")).sendKeys("naveen");
//		driver.findElement(By.id("Form_submitForm_LastName")).sendKeys("automation");
		
		//2nd:appraoch
//		WebElement firstName = driver.findElement(By.id("Form_submitForm_FirstName"));//driver.findElement() return WebELement
//		WebElement secondName = driver.findElement(By.id("Form_submitForm_LastName"));
//		
//		firstName.sendKeys("naveen");
//		secondName.sendKeys("automation");
		
		//3rd: By locator:approach
		// Here we created and maintained the By locator and when this locator needed then we create webelement and use
//		By firstName = By.id("Form_submitForm_FirstName");//By.id() returns "By"
//		By secondName = By.id("Form_submitForm_LastName");
//		
//		WebElement fn_ele = driver.findElement(firstName);
//		WebElement ln_ele = driver.findElement(secondName);
//		
//		fn_ele.sendKeys("naveen");
//		ln_ele.sendKeys("automation");
		
		//4th: generic method
//		By firstName = By.id("Form_submitForm_FirstName");
//		By secondName = By.id("Form_submitForm_LastName");
//		
//		getElement(firstName).sendKeys("naveen");
//		getElement(secondName).sendKeys("automation");
		
		//5th: using generic methods for actions:
//		By firstName = By.id("Form_submitForm_FirstName");
//		By secondName = By.id("Form_submitForm_LastName");
//		
//		doSendKeys(firstName, "naveen");
//		doSendKeys(secondName, "automation");
		
		//6th: create a new ElementUtil class with generic functions
//		By firstName = By.id("Form_submitForm_FirstName");
//		By secondName = By.id("Form_submitForm_LastName");
//		
		ElementUtil eleUtil = new ElementUtil(driver);// constructor dekh usme driver dena hai
//		eleUtil.doSendKeys(firstName, "naveen");
//		eleUtil.doSendKeys(secondName, "automation");
		
		
		//2. name: can be duplicate also --II
//		By fn = By.name("FirstName");
//		eleUtil.doSendKeys(fn, "naveen");
		
//		By agreeCheckBox = By.name("agree");
//		doClick(agreeCheckBox);
		
		//3. className: can be duplciate for multiple elements
		//can be used only when it's unique
//		By fn = By.className("form-control");
//		eleUtil.doSendKeys(fn, "naveen");
//		
		
		//4. link text: only for links: \
		// "a" tag is always for links
		//By login = By.linkText("Login");
		//driver.findElement(login).click();
		//doClick(login);
		
		//5. partial link text: only for links (not recommended)
		//Forgotten username
		//Forgotten Password
//		By forgotPwd = By.partialLinkText("Forgotten");
//		doClick(forgotPwd);
		
		//6. xpath: is a locator: address of the element in DOM --III
		//its not an attribute
//		By fn = By.xpath("//*[@id=\"input-firstname\"]");
//		doSendKeys(fn, "testing");
		
		//7. css selector: is a locator but its not an attribute (better performance) --IV
//		By ln = By.cssSelector("#input-lastname");
//		doSendKeys(ln, "automation");
		
		//8. tagName: html tag:
		By header = By.tagName("h2");
		//String text = driver.findElement(header).getText();
		String text = doGetText(header);
		System.out.println(text);
		
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	
	
}