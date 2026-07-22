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
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// click on the column to sort the table
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

		// scan the name column with getText() --> Rice --> print the price of the
		// product "Rice"
		// we use do-while loop
		List<String> price;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(x -> x.getText().contains("Rice")).map(x -> getPriceVeggie(x))
					.collect(Collectors.toList());

			price.forEach(x -> System.out.println(x));
			if (price.size() < 1) {
				// in this case we click on "Next" button
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() < 1);

	}

	private static String getPriceVeggie(WebElement product) {
		String price = product.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
