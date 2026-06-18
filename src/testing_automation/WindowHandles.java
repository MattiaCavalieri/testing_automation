package testing_automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	// in questa sezione vediamo come gestire un automazione con le finestre
	// multiple

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		// clicchiamo sul link lampeggiante per aprire una nuova finestra
		driver.findElement(By.className("blinkingText")).click();

		// dobbiamo fare in modo che il driver passi il suo focus sulla seconda scheda
		// che è stata aperta
		// dobbiamo verificare quante schede sono state aperte, tramite il loro ID,
		// tramite getWindowHandles(), che restituisce un set di String
		Set<String> windows = driver.getWindowHandles();

		// passiamo l'id della finestra su cui vogliamo operare al metodo switchTo()
		// usiamo Iterator per determinare il parentID e il childID tramite il metodo
		// next()
		Iterator<String> iter = windows.iterator();
		String parentID = iter.next();
		String childID = iter.next();

		driver.switchTo().window(childID);

		// stampiamo in console il testo del paragrafo dove è indicato l'indirizzo email
		// da utilizzare
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

		// dobbiamo estrarre "mentor@rahulshettyacademy.com"
		String testo = driver.findElement(By.cssSelector(".im-para.red")).getText();
		String[] parole = testo.split(" ");
		String username = parole[4];
		
		// ri-switchamo sulla scheda principale
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(username);
	}

}
