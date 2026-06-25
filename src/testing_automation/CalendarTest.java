package testing_automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarTest {

	public static void main(String[] args) {

		String monthNumber = "6";
		String date = "25";
		String year = "2027";
		String[] expectedList = { monthNumber, date, year };

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		// we repeat the step to select the "Year" pick up
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		// select the same year as the one present in the String "year" (2027) passing
		// the variable dinamically
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
		// for the month we can use the css class selector to retrive the list of months
		// we have to convert the String "06" in integer format
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
				.get(Integer.parseInt(monthNumber) - 1).click();
		// select date
		driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

		// extracting the text from the selection of month/day/year
		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for (int i = 0; i < actualList.size(); i++) {
			Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
		}
		
	}

}
