package testngsessions;

import org.testng.annotations.Test;

// This topic is only for interview point of view. People might ask you how we ignore the exception in testNg
// otherwise there is different and better ways to do it.
public class ExpectedExceptionConcept {
	String name = "testng";
	
	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void homePageTest() {
		System.out.println("homePageTest");
		//int i = 9/0;
		ExpectedExceptionConcept obj= null;
		System.out.println(obj.name);
	}
	
	
	

}