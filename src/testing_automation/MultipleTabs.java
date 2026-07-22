package testing_automation;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabs {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// Open a new tab
		driver.switchTo().newWindow(WindowType.TAB);

		// we have to move the scope from first tab to second tab, by switching the
		// window
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
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(testo);

		// we can take a screenshot of a specific field instead of taking the picture of
		// the entire screen
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));

		// check if the the width and height of a web element are correct
		int height = name.getRect().getHeight();
		int width = name.getRect().getWidth();
		System.out.println(height);
		System.out.println(width);
	}

}
