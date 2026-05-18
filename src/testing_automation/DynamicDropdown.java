package testing_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {

		// inizializzo il driver per Chrome e navigo verso il link di test
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// //a[@value='BLR'] --> xpath dell'elemento che dobbiamo selezionare per la
		// partenza
		// //(a[@value='MAA'])[2] --> xpath dell'elemento che dobbiamo selezionare per
		// la destinazione. devo selezionare il 2° oggetto con questo XPath, mettendo il
		// [2]
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		// seleziono "Bengaluru" come città di partenza
		driver.findElement(By.xpath("//a[@value='BLR']")).click();

		Thread.sleep(2000);

		// seleziono "Chennai" come destinazione, usando la sintassi vista prima
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

	}

}
