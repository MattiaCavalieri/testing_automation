package testing_automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {

		String username = "mattiacavalieri@gmail.com";

		// System.setProperty("webdriver.chrome.driver", "C:/Mattia/Test
		// Automation/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// implicit wait - aspetta 5 secondi prima di restituire un timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// richiamo il metodo per ottenere la password e la salvo in una stringa "password"
		String password = getPassword(driver);
		
		// raggiungo la pagina web
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// identifico il campo per inserire il nome utente e inserisco il valore tramite
		// il metodo "sendKeys()"
		driver.findElement(By.id("inputUsername")).sendKeys(username);
		// identifico il campo per inserire l'indirizzo email e inserisco il valore
		// tramite il metodo "sendKeys()"
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		// identifico il pulsante per effettuare il login e lo clicco
		driver.findElement(By.className("submit")).click();

		// inseriamo uno sleep di 1 secondo per aspettare la transizione della pagina
		Thread.sleep(1000);

		// posso identificare un elemento tramite il suo tagName, ma devo assicurarmi
		// che sia unico in tutta la pagina
		driver.findElement(By.tagName("p")).getText();
		// stampo in console il testo inserito nel tag "p"
		System.out.println(driver.findElement(By.tagName("p")).getText());
		// uso un'assertion come validazione che il testo che abbiamo estratto
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		// Identifico l'h2 dove è contenuto il nome utente utilizzando il CssSelector
		driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello " + username + ",");

		// sleep di 2 secondi
		Thread.sleep(2000);

		// identifichiamo il bottone "Sign Out" tramite il suo xpath identificato
		// tramite il testo presente nel pulsante
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();

		// sleep di 2 secondi
		Thread.sleep(2000);

		// dopo aver effettuato il log out, chiudiamo la finestra del browser
		driver.close();

	}

	public static String getPassword(WebDriver driver) throws InterruptedException {
		// raggiungo la pagina
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// clicco su "Forgot your passowrd"
		driver.findElement(By.linkText("Forgot your password?")).click();
		// Sleep di 1 secondo
		Thread.sleep(1000);
		// identifico il pulsante per resettare il login
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		// recupero il testo mostrato per completare il reset del login e lo salvo in "passwordText"
		String passwordText = driver.findElement(By.cssSelector(".infoMsg")).getText();
		// splitto la  stringa 
		// indice 0 --> Please use temporary password
		// indice 1 --> c'è la parte di stringa con la password
		String[] passwordArray = passwordText.split("'");
		// rieseguo lo split per isolare la password e prendo l'indice 0 --> password
		String password = passwordArray[1].split("'")[0];
		return password;

	}

}
