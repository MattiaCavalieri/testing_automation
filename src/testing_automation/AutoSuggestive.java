package testing_automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		// inizializzo il driver per Chrome e navigo verso il link di test
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// identifico il box per il suggerimento del paese in base all'input inserito
		// inseriamo "Ita"
		driver.findElement(By.id("autosuggest")).sendKeys("Ita");

		Thread.sleep(2000);

		// devo scandire le opzioni visualizzate per capire su qquale devo cliccare
		// uso un xpath per recuperare tutte le possibili opzioni mostrate
		// li[class='ui-menu-item'] a --> cssSelector di tipo a della classe
		// ui-menu-item
		// il metodo findElements (plurale) estrare una lista dei valori delle possibili
		// opzioni
		// Salviamo i valori estratti in una lista
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		// iteriamo tra le diverse opzioni e individuiamo Italia
		// appena troviamo il link, lo clicchiamo
		for (WebElement element : options) {
			if (element.getText().equalsIgnoreCase("Italy")) {
				element.click();
				System.out.println("Ho trovato l'Italia!");
				break;
			}
		}
	}

}
