package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartRegistration {
    
//	private static WebDriver driver;

	public static void main(String[] args){
		
		//String browser = "chrome";

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.lauchBrowser("chrome");
		brUtil.lauchUrl("https://demo.opencart.com/index.php?route=account/register");
		
		By fname = By.name("firstname"); 
		By lname = By.name("lastname");
		By email = By.name("email");
		By tel   = By.name("telephone");
		By pwd   = By.name("password");
		By cpwd  = By.name("confirm");
		
		ElementUtil eu = new ElementUtil(driver);
		eu.doSendKeys(fname, "Harsh");
		eu.doSendKeys(lname, "Khepar");
		eu.doSendKeys(email, "harsh.khepar96@gmail.com");
		eu.doSendKeys(tel, "7986737837");
		eu.doSendKeys(pwd, "harsh@123");
		eu.doSendKeys(cpwd, "harsh@123");
		
	}

}
