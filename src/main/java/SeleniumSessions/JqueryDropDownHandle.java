package SeleniumSessions;

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

		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(2000);

		By choices = By.cssSelector(".comboTreeItemTitle");
		
//		List<WebElement> choiceList = driver.findElements(choices);
//		for(WebElement e : choiceList) {
//			String text = e.getText();
//		    System.out.println(text);
//					if (text.equals("choice 2 2")) {
//						e.click();
//						break;
//					}
//		}

		// TC_01: Single Selection:
		// selectChoice(choices, "choice 2");

		// TC_02: Multi Selection:
		// selectChoice(choices, "choice 1", "choice 2", "choice 4");

		// TC_03: All Selection
		selectChoice(choices, "select_all");
//		selectChoice(choices, "select_all");//de-selction : we have to click again on the selected option


	}

	/**
	 * 
	 * @param locator
	 * @param value
	 */
	// String...(three dot paramters) or String[] means String contains multiple value-- this is how array is defined (String values)
	public static void selectChoice(By locator, String... value) {
		List<WebElement> choiceList = driver.findElements(locator);// 45

		if (!value[0].equalsIgnoreCase("select_all")) {// "equalsIgnoreCase" in place of "equals" we use because user can pass in capitals letter also
			// like "All","ALL"
			//value[0] is the checkbox for selecting all checkboxes

			for (WebElement e : choiceList) {
				String text = e.getText();
				System.out.println(text);

				for (int j = 0; j < value.length; j++) {
					if (text.equals(value[j])) {
						e.click();
						break;
					}
				}

			}
		} else {
			// all selection logic:
			try {
				for (WebElement e : choiceList) {
					e.click();
				}
			} catch (Exception e) {

			}
		}

	}

}