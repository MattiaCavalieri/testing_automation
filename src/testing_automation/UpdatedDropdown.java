package testing_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

// TestNG è un framework di testing -> assertion

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// inizializzo il driver e navigo verso il link di test
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// usiamo le assertion per verificare che la checkbox "Family and Friends" NON sia selezionata
		Assert.assertFalse(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());

		// verifichiamo che il checkbox "Family and Friends" sia selezionato o no e stampiamo a schermo il controllo
		// System.out.println(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());

		// aggiungiamo la selezione dei checkbox
		driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).click();

		// contiamo i checkbox presenti e li stampiamo in console
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		// usiamo un'assertion per verificare che la checkbox "Family and Friends" sia selezionata
		Assert.assertTrue(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());

		// verifichiamo che il checkbox sia selezionato o no e stampiamo a schermo il controllo
		// System.out.println(driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).isSelected());

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
		
		// utilizziamo un assertion per verificare che siano esattamente 5 passeggeri selezionati
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

		// stampo in console l'output del totale dei passeggeri selezionati e lo stampiamo in console
		// System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

	}

}
