package testing_automation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

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

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

		for (WebElement link : links) {
			String url = link.getAttribute("href");
			
			System.out.println("Checking: " + url);
			
			HttpsURLConnection connection = (HttpsURLConnection) new URI(url).toURL().openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int responseCode = connection.getResponseCode();
			System.out.println(responseCode);
			if (responseCode > 400) {
				System.out.println("The link with text: " + link.getText() + " is broken");
				Assert.assertTrue(false);
			}
		}

	}

}
