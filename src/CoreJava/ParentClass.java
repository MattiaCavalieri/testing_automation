package CoreJava;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ParentClass {
	
	@BeforeMethod
	public void beforeRun() {
		System.out.println("Run me first");
	}

	public void doThis() {
		System.out.println("running test...");
	}
	@AfterMethod
	public void afterRun() {
		System.out.println("clean up data");
	}
}
