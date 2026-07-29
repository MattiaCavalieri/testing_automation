package testNGTutorial;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test4 {

	@Parameters({ "URL" })
	@Test(groups = "sanity")
	public void loginHome(String url) {
		System.out.println("Login Home completed successfully!");
		System.out.println("Connected to: " + url);
	}

	@Test(groups = "sanity")
	public void mobileLoginHome() {
		System.out.println("Mobile app Home login done!");
		Assert.assertTrue(false);
	}

	@Test(enabled = false)
	public void mobileSignOut() {
		System.out.println("Mobile Sign out");
	}

	@Test(timeOut = 4000)
	public void apiLoginHome() {
		System.out.println("API login Home done!");
	}

	@Test(dataProvider = "getData", groups = "sanity")
	public void mobileSignIn(String username, String password) {
		System.out.println("Mobile Sign in....");
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
	}

	@DataProvider
	public Object getData() {
		// 1st combination: username - password
		// 2nd combination: username - password - no credit history
		// 3rd combination: fraudolent credit history
		// we create a ulti-dimensional Object Array, with 3 combination of data set,
		// for each combination we pass 2 paramenters
		Object[][] data = new Object[3][2];
		// 1st combination: username - password
		data[0][0] = "firstUsername";
		data[0][1] = "firstPassword";
		// 2nd combination: username - password - no credit history
		data[1][0] = "secondUsername";
		data[1][1] = "secondPassword";
		// 3rd combination: fraudolent credit history
		data[2][0] = "thirdUsername";
		data[2][1] = "thirdPassword";
		return data;
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
