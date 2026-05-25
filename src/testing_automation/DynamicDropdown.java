package testing_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {

		// inizializzo il driver per Chrome e navigo verso il link di test
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		Thread.sleep(2000);
		
		// stampiamo l'attributo "style" prima e dopo aver cliccato "Round Trip" 
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));

		// seleziono "Round Trip" per abilitare il calendar per la data di ritorno
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));

		// verifichiamo che l'elemento "return date" sia abilitato
		// stampiamo a console l'esito del metodo "isEnabled()"
		// isEnabled() non è affidabile, usiamo le proprietà css per verificarese l'opacity è a 1
		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
			System.out.println("it is enabled!");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

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

		// selezioniamo la data corrente come data di partenza
		//
		// RICORDA: stai selezionando classi, quindi devi aggiungere il "." prima del
		// nome delle classi
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

		// viene inserita automaticamente la data del ritorno impostata ad una settiana
		// dalla data di partenza.
		// completiamo l'azione con il click su "search"
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		System.out.println("Ricerca completata");

	}

}
