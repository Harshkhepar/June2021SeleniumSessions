package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHrmPractice {
//static WebDriver driver;
	public static void main(String[] args) {
		
		//launch browser,url,maximise window,then sign in
		
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.lauchBrowser("chrome");
		brUtil.getPageUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.manage().window().maximize();
		
		String crUrl = brUtil.getCurrentUrl();
        System.out.println(crUrl);
        
        By labelText = By.id("Form_submitForm_subdomain");
        By flName = By.id("Form_submitForm_Name");
        By email = By.id("Form_submitForm_Email");
        By phNum = By.id("Form_submitForm_Contact");
        By captcha = By.xpath("//span[@id = 'recaptcha-anchor'][@role='checkbox']");
        
        ElementUtil ele_utl = new ElementUtil(driver); 
//        driver.manage().window().maximize();
        ele_utl.doSendKeys(labelText,"New Account");
        ele_utl.doSendKeys(flName,"Harsh");
        ele_utl.doSendKeys(email,"harsh@hotmail.com");
        ele_utl.doSendKeys(phNum, "1234567891");
        ele_utl.doClick(captcha);
        
	}

}
