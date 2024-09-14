package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.findElement(By.id("justAnInputBox1")).click();
		Thread.sleep(2000);

		By choices = By.cssSelector(".comboTreeItemTitle");
		selectChoice(choices,"choice 1","choice 2");
	}

	public static void selectChoice(By locator,String... value) {
		List<WebElement> choiceList = driver.findElements(locator);
		
		for(WebElement e : choiceList) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}

	}

}
