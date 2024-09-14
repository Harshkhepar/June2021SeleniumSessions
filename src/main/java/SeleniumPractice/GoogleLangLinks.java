package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLangLinks {
 static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in/");
		
		// need to find langiage links size and click on particular link
		
		By LangLinks = By.xpath("//div[@id='SIvCob']/a");
		
//		List<WebElement> langLinksList = driver.findElements(LangLinks);
//		List<WebElement> langLinksList = getElements(LangLinks);
//		System.out.println(langLinksList.size());
//		
//		for(WebElement e : langLinksList) {
//		  String text=  e.getText();
//		  if(text.equals("ਪੰਜਾਬੀ")) {
//			  e.click();
//			  break;
//		  }
//		}
		
		clickOnElement(LangLinks,"ਪੰਜਾਬੀ");
		}
	
	public static void clickOnElement(By locator,String value) {
		List<WebElement> eleList = getElements(locator);
		System.out.println(eleList.size());
		
		for(WebElement e : eleList) {
		  String text=  e.getText();
		  if(text.equals(value)) {
			  e.click();
			  break;
		  }
		}
		
		
	}
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	}


