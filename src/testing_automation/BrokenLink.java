package testing_automation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLink {

	public static void main(String[] args)
			throws MalformedURLException, IOException, URISyntaxException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// broken URL
		// step 1 - get all the URL of the page

		// there are some Java methods that verify the http statuts to determine if the
		// link is broken
		// if status code > 400 --> broken link
		
		// Soft Assertion : servono a non bloccare il metodo nel caso un'assertion fallisca

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert sw = new SoftAssert();

		for (WebElement link : links) {
			String url = link.getAttribute("href");
			
			System.out.println("Checking: " + url);
			
			HttpURLConnection connection = (HttpURLConnection) new URI(url).toURL().openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int responseCode = connection.getResponseCode();
			System.out.println(responseCode);
			sw.assertTrue(responseCode < 400, "The link with text: " + link.getText() + " is broken");
			
		}
		
		sw.assertAll();

	}

}
