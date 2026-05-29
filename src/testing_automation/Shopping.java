package testing_automation;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shopping {

	public static void main(String[] args) throws InterruptedException {
		// Gestione di un flusso di shopping: aggiungiamo elementi ad un carrello

		// Definiamo la lista di prodotti da aggiungere
		String[] prodottiRichiesti = { "Cucumber", "Brocolli" };

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		Thread.sleep(3000);

		// Vogliamo aggiungere "Cucumber" al carrello, ma in questa pagina non ci sono
		// attributi specifici che consentono di individuare univocamente il pulsante
		// "Add to cart" per cucumber.
		// L'idea è quella di identificare i h4-div dei prodotti ed iterare fino a
		// trovare "Cucumber", per poi usare il relativo pulsante per aggiungere al
		// carrello

		// recuperiamo tutti i prodotti della vetrina e li salviamo in una lista di
		// WebElement
		List<WebElement> prodotti = driver.findElements(By.cssSelector("h4.product-name"));
		
		int conteggio = 0;

		for (int i = 0; i < prodotti.size(); i++) {
			// rimuoviamo il testo " - 1 Kg" dal nome prodotto
			String[] nomeProdotti = prodotti.get(i).getText().split("-");
			// rimuoviamo lo spazio " " dopo "Broccoli"
			String nomeProdotto = nomeProdotti[0].trim();
			// verifichiamo se il nomeProdotto estratto è contenuto nell'array
			// "prodottiRichiesti"
			// convertiamo l'array in un arrayList
			List<String> items = Arrays.asList(prodottiRichiesti);

			
			if (items.contains(nomeProdotto)) {
				conteggio++;
				// clicchiamo su "Add to Cart"
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				System.out.println("ho aggiunto l'item " + nomeProdotto + " al carrello!");
				if (conteggio == prodottiRichiesti.length)
					break;
				
			}

		}

	}

}
