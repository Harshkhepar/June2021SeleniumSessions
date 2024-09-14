package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownOptionWithSelect {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");
//		
//		WebElement indus_ele = driver.findElement(industry);
//		WebElement country_ele = driver.findElement(country);
		
//		Select indus_select = new Select(indus_ele);// we have to pass WebElement in parameters of Select 
//		List<WebElement> indusList = indus_select.getOptions();// getOptions() method gives you all dropdown options list
//		getOptions() methods return List<WebElement>
//		System.out.println(indusList.size());
//		
//		for(WebElement e : indusList) {
//			String text = e.getText();
//			System.out.println(text);
//		}
//		
		
		List<String> indusList = getDropDownOptionsList(industry);
		
		if(indusList.size() == 21) {
			System.out.println("TC_01: PASS");
		}
		if(indusList.contains("Healthcare")) {
			System.out.println("TC_02: PASS");
		}
		
		//getDropDownOptionsList(country);
		
		selectDropDownValue(country, "Belgium");


	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}	
	
	public static List<String> getDropDownOptionsList(By locator) {
		List<String> optionsValList = new ArrayList<String>();
		Select select = new Select(getElement(locator));// we have to pass WebElement in parameters of Select 
		// Class bcoz there is no default constructor for Select class.
		List<WebElement> optionsList = select.getOptions();
		
		System.out.println(optionsList.size());
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			optionsValList.add(text);
		}
		return optionsValList;
	}
	
	public static void selectDropDownValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	
	
	

}