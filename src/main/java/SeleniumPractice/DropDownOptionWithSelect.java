package SeleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownOptionWithSelect {
	static WebDriver driver;

	public static void main(String[] args) {
		BrowserUtil br = new BrowserUtil();
		driver = br.lauchBrowser("chrome");
		br.lauchUrl("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

		By day = By.xpath("// select[@class ='form-control']");
//		WebElement dayOptions = driver.findElement(day);
//		Select select = new Select(dayOptions);
//		List<String> dayDropdownOptions = new ArrayList<String>();
//		List<WebElement> dayDropdownList = select.getOptions();
//		System.out.println(dayDropdownList.size());
//
//		for (WebElement e : dayDropdownList) {
//			String text = e.getText();
//			dayDropdownOptions.add(text);
//
//		}
		List<String> opt = getDropDownOptionsList(day);
		if (opt.size() == 8) {
			System.out.println("TC_01 is paas");
		}
		if (opt.contains("Monday")) {
			System.out.println("TC_02 is paas");
		}
		SelectDropdownValue(day,"Saturday");
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<String> getDropDownOptionsList(By locator) {
		List<String> DropdownOptions = new ArrayList<String>();

		Select select = new Select(getElement(locator));
		List<WebElement> Op_list = select.getOptions();
		for (WebElement e : Op_list) {
			String text = e.getText();
			DropdownOptions.add(text);
		}
		return DropdownOptions;
	}

	public static void SelectDropdownValue(By locator,String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> Op_list = select.getOptions();
		for (WebElement e : Op_list) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
