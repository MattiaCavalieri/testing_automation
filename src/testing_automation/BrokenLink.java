package testing_automation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// broken URL
		// step 1 - get all the URL of the page
		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		System.out.println(url);

		// there are some Java methods that verify the http statuts to determine if the
		// link is broken
		// if status code > 400 --> broken link
		HttpURLConnection connection = (HttpURLConnection) new URI(url).toURL().openConnection();
		connection.setRequestMethod("HEAD");
		connection.connect();
		
		int response = connection.getResponseCode();
		System.out.println(response);
	}

}
