package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementActionsSpiceJet {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		By LgnSignUp = By.xpath("//li[@class='li-login float-right tabres']");
		By clubMembers = By.xpath("//*[@id=\"smoothmenu1\"]/ul/li[18]/ul/li[2]/a");
		By signUp = By.xpath("//*[@id=\"smoothmenu1\"]/ul/li[18]/ul/li[2]/ul/li[2]/a");
//		Actions act = new Actions(driver);
//		act.moveToElement(driver.findElement(LgnSignUp)).perform();
//		Thread.sleep(2000);
       
		ThreeLevelMenuHandle(LgnSignUp,clubMembers, signUp);
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void twoLevelMenuHandle(By parentMenu,By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		getElement(childMenu).click();
	}
	public static void ThreeLevelMenuHandle(By parentMenu1,By parentMenu2,By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu1)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(parentMenu2)).perform();
		Thread.sleep(2000);
		getElement(childMenu).click();
	}

}
