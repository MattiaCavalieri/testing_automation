package testing_automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesExercise {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("a[href='/windows']")).click();
		// click here
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		// we have to retrive how many windows have been opened and identify them by
		// their ID, using getWindowHandles()
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parentID = iter.next();
		String childID = iter.next();
		// switch to the second window
		driver.switchTo().window(childID);
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		// switch back to first window
		driver.switchTo().window(parentID);
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
	}

}
