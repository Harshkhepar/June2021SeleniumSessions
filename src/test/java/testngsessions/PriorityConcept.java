package testngsessions;

import org.testng.annotations.Test;

// non priority based test cases will be executed first
public class PriorityConcept {

	@Test
	public void a_test() {
		System.out.println("a test");
	}

	@Test //(priority = -1 or 0 also) practically we can't use negative and 0 priority
	public void b_test() {
		System.out.println("b test");
	}

	@Test
	public void c_test() {
		System.out.println("c test");
	}

	@Test(priority = 1)
	public void d_test() {
		System.out.println("d test");
	}

	@Test(priority = 2)
	public void e_test() {
		System.out.println("e test");
	}
  
	//console o/p:
	// first non priority test cases will run then priority based
//	PASSED: a_test
//	PASSED: b_test
//	PASSED: c_test
//	PASSED: d_test
//	PASSED: e_test
}
