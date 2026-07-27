package testNGTutorial;

import org.testng.annotations.Test;

public class Test3 {
	
	@Test(dependsOnMethods = {"loginHome", "mobileSignOut"})
	public void login() {
		System.out.println("Login completed successfully!");
	}
	
	@Test(groups = "sanity")
	public void mobileLogin() {
		System.out.println("Mobile app login done!");
	}
	
	@Test(groups = "sanity")
	public void apiLogin() {
		System.out.println("API login done!");
	}
	
	

}
