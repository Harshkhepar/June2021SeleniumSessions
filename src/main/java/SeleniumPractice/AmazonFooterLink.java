package SeleniumPractice;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonFooterLink {
static WebDriver driver;

	public static void main(String[] args) {
		// get text of each link in footer of Amazon
		
		BrowserUtil brUtil = new BrowserUtil();
		driver = brUtil.lauchBrowser("chrome");
		brUtil.getPageUrl("https://www.amazon.in/");

        
        ElementUtil eleUtil = new ElementUtil(driver);
        
      By footerLinks =  By.xpath("//div[@class='navFooterVerticalColumn navAccessibility']//ul/li");
      
//      List<String> footerlist = new ArrayList<String>();
//      List<WebElement> footerLinksList = eleUtil.getElements(footerLinks);
//      
//        for(WebElement e :footerLinksList ) {
//        	String text = e.getText();
//        	if(!text.isEmpty()) {
//        		footerlist.add(text);
//        	}
//        }
//        System.out.println(footerlist);
      
    List<String> footerLinksList =  getLinksTextList(footerLinks);
     if(footerLinksList.contains("Sell on Amazon")) {
    	 System.out.println("Test is pass");
     }
	}
    
	public static List<String> getLinksTextList(By locator) {
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
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
		
	}

