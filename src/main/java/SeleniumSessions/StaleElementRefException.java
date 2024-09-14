package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementRefException {
	public static void main(String[] args) throws InterruptedException {

		
		//stale -->means not fresh
		//whenever we do click, refresh, navigating to another page then DOM get changed so we have to upate the element acc to new page
		//back and forward
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		
		List<WebElement> list = driver.findElements(By.xpath("(//ul[@class='sc-ace17a57-0 sc-4ae80653-0 kTjuIu eQNriT'])[3]/li"));
		
		for(int i=0; i<list.size(); i++) {
			Thread.sleep(3000);
			list.get(i).click();// ab jab hum click kr denge then new page khulega but links same honge isliye DOM change ho gya hoga
			// isliye hume ab uss page ka DOM structure chaiye isliye List ko update krna padhta hai
			list = driver.findElements(By.xpath("(//ul[@class='sc-ace17a57-0 sc-4ae80653-0 kTjuIu eQNriT'])[3]/li"));
		}
		
		
		
	}

}