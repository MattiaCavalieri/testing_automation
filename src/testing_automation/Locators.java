package testing_automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver", "C:/Mattia/Test
		// Automation/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// implicit wait - aspetta 5 secondi prima di restituire un timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// raggiungo la pagina web
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// identifico il campo per inserire il nome utente e inserisco il valore tramite
		// il metodo "sendKeys()"
		driver.findElement(By.id("inputUsername")).sendKeys("mattiacavalieri@gmail.com");
		// identifico il campo per inserire l'indirizzo email e inserisco il valore
		// tramite il metodo "sendKeys()"
		driver.findElement(By.name("inputPassword")).sendKeys("R1verside.2025!");
		// identifico il pulsante per effettuare il login e lo clicco
		driver.findElement(By.className("submit")).click();

		// catturo il messaggio di "incorrect username or password" usando il suo CSS
		// Selector -> tagname.classname oppure
		// Tagname[attribute='value']
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

		// individuare il link "Forgot your password" e cliccare sul link
		driver.findElement(By.linkText("Forgot your password?")).click();

		// introduciamo una piccola attesa per permettere alla pagina di venire caricata
		// completamente
		Thread.sleep(1000);

		// utilizzo di XPath -> //Tagname[attribute='value']
		// nel nostro caso stiamo inserendo lo username della pagina "Forgot Password"
		// -> //imput[@placeholder='Name']
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Mattia");
		// inseriamo l'indirizzo email
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("mattiacavalieri@gmail.com");
		// inseriamo in numero di cellulare
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("3357665433");

		// se devo pulire un campo (ad esempio il numero di cellulare), individuo il
		// campo e uso il metodo ".clear()" per cancellare quello che è contenuto
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("3480071909");

		// un metodo alternativo per identificare i campi attraverso i loro xpath è
		// usare il numero di xpath:
		// ad esempio devo ripulire il campo email e email è il secondo campo
		// (dall'alto) del form
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("wmc075c@motorola.com");

		// e' possibile arrivare a un campo, partendo dal suo genitore usando sempre gli
		// Xpath
		// la sintassi è -> //form/input[3]
		driver.findElement(By.xpath("//form/input[3]")).clear();
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("3357665433");

		// identifico il pulsante per resettare il login
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		// recupero il testo mostrato per completare il reset del login
		System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText());

		// identifico il pulsante "Go to Login" e lo clicco
		driver.findElement(By.className("go-to-login-btn")).click();

		// introduciamo una piccola attesa per permettere alla pagina di venire caricata
		// completamente
		Thread.sleep(1000);

		// identifico il campo per inserire il nome utente e inserisco il valore tramite
		// il metodo "sendKeys()"
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("mattiacavalieri@gmail.com");
		// inserisco la password
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

		// seleziono l'opzione "Remember me"
		driver.findElement(By.cssSelector("#chkboxOne")).click();

		// clicco su "Sign In"
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();

	}

}
