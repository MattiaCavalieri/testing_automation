package testing_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver", "C:/Mattia/Test
		// Automation/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// eseguire la finestra del browser in massimizzata in full screen
		driver.manage().window().maximize();
		// navigo su google - la pagina viene caricata completamente
		driver.get("https://google.com");
		// navigo da google verso un'altra pagina - la pagina non viene caricata
		// completamente
		driver.navigate().to("https://rahulshettyacademy.com/");
		// uso il back del browser per tornare indietro
		Thread.sleep(1000);
		driver.navigate().back();
		// uso il forward del browser per tornare alla seconda pagina
		Thread.sleep(1000);
		driver.navigate().forward();
	}

}
