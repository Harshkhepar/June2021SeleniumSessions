package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHandle {
	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		driver = br.lauchBrowser("chrome");
		br.getPageUrl("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

		By day = By.xpath("// select[@class ='form-control']");
//		WebElement daydropdown = driver.findElement(day);
//
//		Select select = new Select(daydropdown);
		//select.selectByIndex(3);
		//select.selectByValue("Sunday");
//		select.selectByVisibleText("Wednesday");
		doSelectByVisibleText(day,"Sunday");

	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void doSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	public static void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
}
