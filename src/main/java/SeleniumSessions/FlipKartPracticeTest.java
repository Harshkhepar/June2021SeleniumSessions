package SeleniumSessions;

import org.openqa.selenium.WebDriver;

public class FlipKartPracticeTest {

	public static void main(String[] args) {
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.launchBrowser("chrome");
		
		br.launchUrl("https://www.flipkart.com/");
		
		String title = br.getPageTitle();
		System.out.println(title);
		
		String url = br.getPageUrl();
		System.out.println(url);
		
		String pageSource = br.getCurrentPageSource();
		System.out.println(pageSource);
		
		br.closeBrowser();

	}

}
