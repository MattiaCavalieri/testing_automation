package testing_automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxesExercise {

	public static void main(String[] args) {

		// creo il driver
		WebDriver driver = new ChromeDriver();
		// navigo verso il link di test
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// identifico il primo checkbox e verifico che NON sia selezionata
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());

		// clicco la prima checkbox
		driver.findElement(By.id("checkBoxOption1")).click();

		// verifico che ora sia effettivamente selezionata
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());

		// inidividuiamo il numero di checkbox presenti nella pagina usando il
		// cssSelector e inidicando l'id "checkbox-example" usando
		// "input[type='checkbox']" per trovare tutte le occorrenze
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkbox-example input[type='checkbox']"));

		System.out.println(checkboxes.size());

	}

}
