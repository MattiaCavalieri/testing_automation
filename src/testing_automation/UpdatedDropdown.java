package testing_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// inizializzo il driver e navigo verso il link di test
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// seleziono il dorpdown del numero di passeggeri per aprire la selezione del
		// numero di passeggeri
		driver.findElement(By.id("divpaxinfo")).click();

		Thread.sleep(1000);
		
		// recupero il numero iniziale di passeggeri selezionati e lo stampo in console
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// aggiungo i passeggeri (per un totale di 5) usanfo un ciclo for
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		Thread.sleep(1000);

		// termino l'operazione con il tasto Done
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		// stampo in console l'output del totale dei passeggeri selezionati
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
