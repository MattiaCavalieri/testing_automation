package testing_automation;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterStream {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// click on "Search" field to search "Rice"
		driver.findElement(By.id("search-field")).sendKeys("Rice");

		// retrieve the list of all product displayed
		List<WebElement> products = driver.findElements(By.xpath("//tr/td[1]"));
		// apply streams
		List<WebElement> results = products.stream().filter(product -> product.getText().contains("Rice"))
				.collect(Collectors.toList());
		Assert.assertEquals(products.size(), results.size());
	}

}
