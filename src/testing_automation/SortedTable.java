package testing_automation;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortedTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// click on the colum to sort the table
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// capture all the web element into List
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));

		// for each element, let's grab the text of the element into a new list -->
		// original list
		List<String> productNames = elements.stream().map(x -> x.getText()).collect(Collectors.toList());

		// sort in the list of the previous step --> sorted list
		List<String> sortedProductNames = productNames.stream().sorted().collect(Collectors.toList());

		// compare original list and sorted list
		Assert.assertTrue(productNames.equals(sortedProductNames));

	}

}
