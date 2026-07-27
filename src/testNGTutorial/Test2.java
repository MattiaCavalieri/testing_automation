package testNGTutorial;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2 {

	@Test
	public void test3() {
		System.out.println("very good!");
	}

	@Test
	public void doNotExecute() {
		System.out.println("don't execute me!");
	}

	@BeforeTest
	public void prerequisite() {
		System.out.println("I'll execute first this"); // this method will be executed before any of the test listed in
														// the xml file.
	}

	@AfterTest
	public void after() {
		System.out.println("this has to be done after the test"); // this method will be executed at the end of all the
																	// test folders have been executed;
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("this annotation let you define an environmental variabile common to all tests, executed before starting the test suite");
	}
	
	@AfterSuite
	public void closingSuite() {
		System.out.println("this is the last step after execution of the entire test suite");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("preparing the executotion of the test...");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Erasing the data to run next test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before executing any tests included in this class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after executing any tests included in this class");
	}

}
