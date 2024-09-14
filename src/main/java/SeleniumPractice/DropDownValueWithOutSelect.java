package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDownValueWithOutSelect {
   static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtil br = new BrowserUtil();
		driver = br.lauchBrowser("chrome");
		br.lauchUrl("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

		By day = By.xpath("// select[@class ='form-control']");
//		List<WebElement> optionsList= driver.findElements(day);
//		System.out.println(optionsList.size());
//		for(WebElement e : optionsList) {
//			String text = e.getText();
//			if(text.equals("Saturday")) {
//				e.click();
//				break;
//			}
//			
//		}
		
		clickDropDownValue(day,"Friday");
	}
	public static void clickDropDownValue(By locator, String value) {
		List<WebElement> optionsList = driver.findElements(locator);
		System.out.println(optionsList.size());
		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}

}
}
