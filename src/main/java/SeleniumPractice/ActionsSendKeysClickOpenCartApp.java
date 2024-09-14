package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsSendKeysClickOpenCartApp {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[2]")).click();

//		Actions act = new Actions(driver);
		By firstName = By.xpath("//input[@name='firstname']");
		By lastName = By.xpath("//input[@name='lastname']");
		By email = By.xpath("//input[@name='email']");
		By telePhone = By.xpath("//input[@name='telephone']");
		By pwd = By.xpath("//input[@name='password']");
		By confPwd = By.xpath("//input[@name='confirm']");
		By radioButton= By.xpath("//label[@class='radio-inline']/input[@value='1']");
		By checkBox = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
		By contButton = By.xpath("//input[@value='Continue']");
		
//		act.sendKeys(driver.findElement(firstName), "Harsh").perform();
		doActionsSendKeys(firstName, "Harsh");
		doActionsSendKeys(lastName, "Khepar");
		doActionsSendKeys(email, "harsh.khepar96@gmail.com");
		doActionsSendKeys(telePhone, "7986737837");
		doActionsSendKeys(pwd, "harsh@123");
		doActionsSendKeys(confPwd, "harsh@123");
		doActionsClick(radioButton);
		doActionsClick(checkBox);
		doActionsClick(contButton);
		
//		driver.findElement(By.xpath("//label[@class='radio-inline']/input[@value='1']")).click();

	}
        public static WebElement getElement(By locator) {
        	return driver.findElement(locator);
        }
        public static void doActionsSendKeys(By locator,String value) {
        	Actions act = new Actions(driver);
        	act.sendKeys(getElement(locator),value).perform();
        }
        public static void doActionsClick(By locator) {
        	Actions act = new Actions(driver);
        	act.click(getElement(locator)).perform();
        }
        
}
