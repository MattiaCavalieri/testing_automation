package testing_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DynamicAssignment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// retrieve the text for "Option2" and select the checkbox option
		String text = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		driver.findElement(By.id("checkBoxOption2")).click();
		// dropdown
		driver.findElement(By.id("dropdown-class-example")).click();
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select option = new Select(dropdown);
		option.selectByVisibleText(text);
		// field 
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("confirmbtn")).click();
		// checking if the text diplayed contains the text grabbed on the first step.
		if (driver.switchTo().alert().getText().contains(text)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

}
