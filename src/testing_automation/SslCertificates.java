package testing_automation;

import java.util.Arrays;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SslCertificates {

	public static void main(String[] args) throws InterruptedException {
		// creiamo un oggetto ChromeOptions
		// per accettare i certificati scaduti usiamo il metodo setAcceptInsecureCerts()
		// altre opzioni sono disponibili sulla documentazione ufficiale
		ChromeOptions options = new ChromeOptions();

		// per impostare un proxy di accesso
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("insert proxy here");
		options.setCapability("proxy", proxy);

		// disabilitare il  pop-up blocking
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

		options.setAcceptInsecureCerts(true);

		// dobbiamo passare l'opzione "options" nel costruttore di ChromeDriver
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		Thread.sleep(5000);
		System.out.println(driver.getTitle());

	}

}
