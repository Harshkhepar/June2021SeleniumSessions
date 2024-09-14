package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {
	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		driver = br.lauchBrowser("chrome");
		br.getPageUrl("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();

		By country = By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//select/option");
		WebElement countrylist = driver.findElement(country);
		
		Select select = new Select(countrylist);
		select.selectByVisibleText("India");

	}

}
