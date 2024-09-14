package SeleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath_Axes {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		BrowserUtil br = new BrowserUtil();
		driver = br.lauchBrowser("chrome");
		br.lauchUrl("https://classic.freecrm.com");
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("groupautomation");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
//		driver.findElement
//		(By.xpath("//a[text()='Aliss Jeyhun']//parent::td//preceding-sibling::td/input[@type='checkbox']"))
//		.click();
		
		selectContact("Aliss Jeyhun");
		selectContact("AB Devilliers");
		getCompany("AB Devilliers");
	    System.out.println(getContactDetails("Aliss Jeyhun"));
	
	}
	 public static void selectContact(String name) {
		 driver.findElement
			(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td/input[@type='checkbox']"))
			.click();
			
	 }
	 public static String getCompany(String name) {
	 String compName=driver.findElement
	 (By.xpath("//a[text()='"+name+"']//parent::td//following-sibling::td/a[@context='company']"))
	 .getText();
	 System.out.println(compName);
	     return compName;
	 }
	 public static List<String> getContactDetails(String name) {
		String contactDetailsXpath = "//a[text()='"+name+"']//parent::td//following-sibling::td";
		 List<WebElement> contactList = driver.findElements(By.xpath(contactDetailsXpath));
		 
		 List<String> DetailsList = new ArrayList<String>();
		 for(int i=0;i<DetailsList.size();i++) {
			String text = contactList.get(i).getText();
			DetailsList.add(text);
			 }
		 return DetailsList;
		 }
}
