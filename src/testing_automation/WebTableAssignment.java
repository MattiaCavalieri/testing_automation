package testing_automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableAssignment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// scroll down the page to get the table
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		// print the number of rows present in the table "Web Table Example"
		List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr"));
		System.out.println(rows.size());

		// print the number of columns in the table
		List<WebElement> columns = driver.findElements(By.cssSelector(".table-display th"));
		System.out.println(columns.size());

		// print the entire second row of the table
		WebElement secondRow = driver.findElement(By.cssSelector(".table-display tr:nth-child(2)"));
		String secondRowText = secondRow.getText();
		System.out.println(secondRowText);
	}

}
