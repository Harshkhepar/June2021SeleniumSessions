package SeleniumPractice;

public class AmazonTest {

	public static void main(String[] args) {
		// launch browser,get url,get current title,close the browser

		BrowserUtil brUtil=new BrowserUtil();
		brUtil.lauchBrowser("chrome");
		
		//open url
		brUtil.getPageUrl("https://www.amazon.in");
		// current url
		String crUrl = brUtil.getCurrentUrl();
		System.out.println("the current URL is :" + crUrl);
		
		//get title
		String title = brUtil.getPageTitle();
		System.out.println("the title of the page is :" + title);
		
		//close the browser
		brUtil.closeBrowser();
	}

}
