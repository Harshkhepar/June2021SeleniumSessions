package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomCSS {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		//CSS: Cascaded Style Sheet
		//cssSelector: is a locator but not an attribute
		
		//id:
		//#{id} --> #txtUsername
		//tag#id --> input#txtUsername
		//input#Form_submitForm_FirstName
		
		//class:
		//.{class} --> .login-email
		//tag.class --> input.login-email
		//tag.c1.c2.c3....cn --> input.form-control.private-form__control.login-email
		//.c1.c2.c3....cn --> .form-control.private-form__control.login-email
		
		By.cssSelector("input.login-email");
		By.cssSelector(".form-control.private-form__control.login-email");

		//id&class:
		//#id.class --> #input-email.form-control
		//.class#id --> .form-control#input-email
		
		//tag#id.class
		//tag#id.class --> input#username.login-email
		//tag.class#id --> input.login-email#username
		//tag.c1.c2.c3....cn#id --> input.form-control.private-form__control.login-email#username
		//input#username.form-control.private-form__control.login-email
		
		//other attributes:
		// tag[attr = 'value'] -- css
		//tag[@attr = 'value']  -- xpath
		
		// input[id='input-email'] --css
		//input[@id='input-email'] --xpath

		// input[name='email']
		// input[name='email'][type='text'][placeholder='E-Mail Address']
		
		//contains in css:
		// tag[attr*='value'] --> input[id*='FirstName'] -- contains (*)
		// input[id*='FirstName'][name='FirstName']
		
		//starts with in css:
		// tag[attr^='value'] --> input[name^='First']  -- startswith(^)
		
		//ends with in css:
		// tag[attr$='value'] --> input[name$='Name']   --ends with ($)
		
		//parent to child:
		// form#hs-login div -- 20 (direct + indirect)
		// form#hs-login > div -- 8  (direct)
		// div.navFooterVerticalRow.navAccessibility > div a --22
		// div.navFooterVerticalRow.navAccessibility a --22
		// ul.footer-nav a -- 32  --- 32 links
		// select#Form_submitForm_Industry > option

		List<WebElement> indusList = 
					driver.findElements(By.cssSelector("select#Form_submitForm_Industry > option"));
		
		//child to parent:
		//no backward traversing is allowed in CSS
		// we can't handle web Tables with css
		
		//'not' in css:Famous interview ques.	--> not used in real time but imp for interview 
		// :not is used to exclude webelement
		//form-control private-form__control login-email
		//form-control private-form__control login-password m-bottom-3
		// input.form-control.private-form__control:not(#username) ---> excluding username 
		// input.form-control.private-form__control:not(#password) ---> excluding password
		// input.text:not(#Form_submitForm_JobTitle)   ----> excluding job title
		// input.text:not(#Form_submitForm_JobTitle, [name='FirstName'])----> excluding job title and firstName
		
		//comma in css:
		// input#username, input#password, button#loginBtn, a[href*='signup'] ---> multiple webelement locators in one CSS by using comma
		List<WebElement> mandFields = 
				driver.findElements
				(By.cssSelector("input#username, input#password, button#loginBtn, a[href*='signup']"));
		
		if(mandFields.size() == 4) {
			System.out.println("PASS -- all mandatory elements are present on the page");
		}
		
		//nth-of-type:
		// ul.footer-nav li:nth-of-type(1)
		// select#Form_submitForm_Industry > option:nth-of-type(8)
		// select#Form_submitForm_Industry > option:nth-of-type(n)
		
		//following sibling in css: with the help of "+" 
		// div.private-form__input-wrapper + div
		
		//preceding sibling in css: NA

		//xpath vs css:
		//backward direction is not allowed in CSS
		//there is no text() func in CSS
		//performance: 1000 elements -- xpath --> 1 hr
		//1000 -- css : 55 mins
		
		//for webtable handling:we use xpath
		//id --> By.id
		//dynamic id : css contains or xpath contains
		//multi elements: comma -- css
		//backward --> xpath
		//text() --> xpath
		
		
		
		
		
	}

}