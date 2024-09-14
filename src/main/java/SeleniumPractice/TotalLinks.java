package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {
static WebDriver driver;
	public static void main(String[] args) {
		// total links in google page
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in/");
		
		By links = By.tagName("a");
//		List<WebElement> linksList =  driver.findElements(links);
		List<WebElement> linksList =  getElements(links);
		System.out.println(linksList.size());
		
		for(WebElement e :linksList ) {
			String linksText = e.getText();
			if(!linksText.isEmpty()) {
			System.out.println(linksText);
			}
		}
		
		

	}
       
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	}
	

