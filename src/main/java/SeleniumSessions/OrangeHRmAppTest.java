package SeleniumSessions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRmAppTest {

	public static void main(String[] args) {

		String browser = "chrome";

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser(browser);
		brUtil.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.manage().window().maximize();

		System.out.println(brUtil.getPageTitle());

		//By locators:
		By firstName = By.id("Form_submitForm_FirstName");
		By secondName = By.id("Form_submitForm_LastName");
		By email = By.name("Email");
		By mobilenum   = By.name("Contact");
		By jtitl   = By.name("JobTitle");
		By cname  = By.name("CompanyName");
		

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(firstName, "naveen");
		eleUtil.doSendKeys(secondName, "automation");
		eleUtil.doSendKeys(cname, "dew");
		eleUtil.doSendKeys(jtitl, "QA Engineer");
		eleUtil.doSendKeys(mobilenum, "7986737837");
		eleUtil.doSendKeys(email, "harsh.khepar96@gmail.com");

		//brUtil.closeBrowser();
  
		// Element isDisplayed and isEnabled
		
		
	}

}