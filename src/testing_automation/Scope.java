package testing_automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// give the counf of the links on the page -> tag a
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());

		// number of the links in the footer section only
		// we have to imit the scope of driver to the footer section, creating a
		// mini-driver called footerDriver
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		// number of links in the first column of the footer
		// once again we change the scope of the footerDriver
		WebElement firstColumnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(firstColumnDriver.findElements(By.tagName("a")).size());

		// click on each in the column and check if the pages are opening
		// to optimize the solution we have to simulate ctrl + click on each link to open
		// the link in different tabs
		for (int i = 1; i < firstColumnDriver.findElements(By.tagName("a")).size(); i++) {
			String clickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			firstColumnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			Thread.sleep(5000L);
			  
		}
	}

}
