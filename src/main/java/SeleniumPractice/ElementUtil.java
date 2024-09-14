package SeleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

	private WebDriver driver;// value null this now

	public ElementUtil(WebDriver driver)// constr... of this class to use Webdriver in other classes when call this
										// class
	{
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public void doSendKeys(By locator, String value) {
		// driver.findElement().sendkeys();
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		// driver.findElement().click();
		getElement(locator).click();
	}

	public String dogetText(By locator) { // to get the text under tag
		return driver.findElement(locator).getText();
	}

	public String doGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public boolean doIsEnabled(By locator) {
		return getElement(locator).isEnabled();
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public void clickOnElement(By locator,String value) {
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
	
	public  List<String> getLinksTextList(By locator) {
		 List<String> eleTextList = new ArrayList<String>();
	      List<WebElement> eleList = getElements(locator);
	      
	        for(WebElement e :eleList ) {
	        	String text = e.getText();
	        	if(!text.isEmpty()) {
	        		eleTextList.add(text);
	        	}
	        }
	        System.out.println(eleTextList);
	        return eleTextList;
		}
	
	public boolean isElementExist(By locator) {
		List<WebElement> listEle = driver.findElements(locator);
		if (listEle.size() > 0) {
			System.out.println("element is present");
			return true;
		}
		System.out.println("element is not present");
		return false;
	}
}
