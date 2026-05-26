package testing_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shopping {

	public static void main(String[] args) {
		// Gestione di un flusso di shopping: aggiungiamo elementi ad un carrello
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		// Vogliamo aggiungere "Cucumber" al carrello, ma in questa pagina non ci sono
		// attributi specifici che consentono di individuare univocamente il pulsante
		// "Add to cart" per cucumber.
		// L'idea è quella di identificare i h4-div dei prodotti ed iterare fino a
		// trovare "Cucumber", per poi usare il relativo pulsante per aggiungere al
		// carrello

	}

}
