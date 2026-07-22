package testing_automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabs {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// Open a new tab
		driver.switchTo().newWindow(WindowType.TAB);

		// we have to move the scope from first tab to second tab
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iter = windowHandles.iterator();
		String parentWindow = iter.next();
		String childWindow = iter.next();
		driver.switchTo().window(childWindow);

		// on the second tab le'ts go to the next link
		driver.get("https://www.codicefiscaleonline.com/");
		String testo = driver.findElement(By.tagName("h1")).getText();
		System.out.println(testo);
		driver.switchTo().window(parentWindow);
		driver.findElement(By.cssSelector("[name='name']")).sendKeys(testo);
	}

}
