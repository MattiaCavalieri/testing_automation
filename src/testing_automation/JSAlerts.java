package testing_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlerts {

	public static void main(String[] args) throws InterruptedException {
		// Meccanismo di gestione degli alert javascript

		String name = "Mattia";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();

		// abbiamo generato l'alert Javascript, e per gestirlo in selenium dobbiamo fare
		// uno switch del contesto usando "switchTo()" e selezionare "alert()"
		// dopo aver fatto lo switch del contesto possiamo recuperare il testo
		// dell'alert e lo stampiamo in console
		System.out.println(driver.switchTo().alert().getText());
		
		Thread.sleep(3000);

		// accept() ci permette di cliccare "OK" sull'alert javascript
		driver.switchTo().alert().accept();
		
		// possiamo trovare anche altri tipi di alert con due pulsanti "OK" e "Can cel"
		driver.findElement(By.id("confirmbtn")).click();
		
		// recuperiamo il testo di questo pop-up e lo stampiamo in console
		System.out.println(driver.switchTo().alert().getText());
		
		Thread.sleep(3000);
		
		// in questo caso clicchiamo su "Cancel"
		driver.switchTo().alert().dismiss();

	}

}
