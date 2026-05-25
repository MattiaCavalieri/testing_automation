package testing_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class e2eAutomation {

	public static void main(String[] args) throws InterruptedException {
		// prima automazione E2E che racchiude tutti gli elementi utilizzati finora
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		Thread.sleep(1000);

		// selezioniamo come città di partenza "Delhi"
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();

		Thread.sleep(1000);

		// selezioniamo come città di destinazione "Chennai"
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

		// seleziono la data corrente
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

		// verifico che il selettore della data di ritorno sia disabilitato
		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		// seleziono il dropdown del numero di passeggeri per aprire la selezione del
		// numero di passeggeri fino a 5 passeggeri
		driver.findElement(By.id("divpaxinfo")).click();

		Thread.sleep(1000);
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();

		// verifichiamo che il numero di passeggeri selezionati sia effettivamente "5"
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText() + " selected");

		// seleziono l'opzione "Family and Friends
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();

		// clicchiamo sul pulsante di ricerca
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
