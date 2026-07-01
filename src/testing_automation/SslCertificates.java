package testing_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SslCertificates {

	public static void main(String[] args) {
		// creiamo un oggetto ChromeOptions
		// per accettare i certificati scaduti usiamo il metodo setAcceptInsecureCerts()
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		// dobbiamo passare l'opzione "options" nel costruttore di ChromeDriver
		WebDriver driver = new ChromeDriver();
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
