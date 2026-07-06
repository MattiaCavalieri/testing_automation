package testing_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscellaneous {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		// massimizzare la finestra del browser a tutto schermo
		driver.manage().window().maximize();
		// cancellare tutti i cookies nel browser
		driver.manage().deleteAllCookies();
		// cancellare un cookie specifico, fornendo il nome del cookie che dobbiamo
		// cancellare, come ad esempio i cookie di sessione
		// driver.manage().deleteCookieNamed("sessionKey");

		driver.get("https://google.com");

	}

}
