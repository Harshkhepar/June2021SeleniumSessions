package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementForWebElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		WebElement ele = driver.findElement(By.id("input-email"));
		ele.sendKeys("test@gmail.com");

		driver.navigate().refresh();// v2
		// ab iss refresh k baad DOM change ho gya , ab hum upr wale code k sath email nahi daal sakte
		// isliye hume new code likhna padega acc to new DOM otherwise it will give staleElementException
		ele = driver.findElement(By.id("input-email"));
		ele.sendKeys("naveen@gmail.com");

	}

}
