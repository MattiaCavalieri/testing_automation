package testing_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
		// System.setProperty("webdriver.chrome.driver", "C:/Mattia/Test
		// Automation/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// identificare un elemento usando il Siblings - Child to parents traverse
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// stampo il testo del pulsante indetificato usando il Siblings - Child to parents traverse
		// stampa "Login"
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		

	}

}
