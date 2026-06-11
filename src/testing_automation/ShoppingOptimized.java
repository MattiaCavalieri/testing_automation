package testing_automation;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingOptimized {

	public static void addItems(WebDriver driver, String[] prodottiDaAggiungere) {
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
			List<String> items = Arrays.asList(prodottiDaAggiungere);

			if (items.contains(nomeProdotto)) {
				conteggio++;
				// clicchiamo su "Add to Cart"
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				System.out.println("ho aggiunto l'item " + nomeProdotto + " al carrello!");
				if (conteggio == prodottiDaAggiungere.length)
					break;
			}

		}

	}

	public static void main(String[] args) throws InterruptedException {
		// Ottimizziamo il codice pèresente nella classe "Shopping" creando un metodo
		// separato
		// nel main scriviamo solo il codice necessario all'esecuzione del nostro test
		// creiamo il driver e puntiamo al sito di test per lo shopping
		WebDriver driver = new ChromeDriver();

		// l'implicity wait viene definito a livello globale non appena viene creato il
		// driver
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// impostiamo un explicit wait per permettere alla pagina di caricarsi
		// completamente
		// e si applica all'elemento specifico, identificato dal locator specifico
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		// definiamo gli items da aggiungere
		String[] prodottiRichiesti = { "Cucumber", "Brocolli", "Beetroot" };

		
		// aggiungiamo i prodotti richiesti
		addItems(driver, prodottiRichiesti);

		// clicchiamo sull'icona del carrello e procediamo al checkhout
		driver.findElement(By.className("cart-icon")).click();
		driver.findElement(By.className("action-block")).click();
		// una volta aperto il pop-up del checkout, inseriamo il promo code
		// "rahulshettyacademy"

		// usiamo sempre l'explicit wait per attendere il caricamento della pagina
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");

		// lanciando il test, fallisce perchè non riesce ad individuare l'elemento
		// abbiamo bisogno dell'implictly wait, definito subito dopo la creazione del
		// driver, oppure dell'explicit wait che abbiamo definito prima
		driver.findElement(By.className("promoBtn")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));

		// verifichiamo che il testo "Code appliend.!" sia effettivamente visualizzato
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
	}

}
