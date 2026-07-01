package testing_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutocompleteAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// insert the first 3 letters of the country 
		driver.findElement(By.id("autocomplete")).sendKeys("Ita");
		
		// move the mouse over the right country
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.className("ui-menu-item-wrapper"));
		Select italy = new Select(dropdown);
		italy.selectByVisibleText("Italy");
		
		// check if the value in the box is updated

	}

}
