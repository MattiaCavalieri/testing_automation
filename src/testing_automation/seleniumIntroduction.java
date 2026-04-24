package testing_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumIntroduction {

	public static void main(String[] args) {

		// Invoking browser
		// Chrome - ChromeDriver --> Methods: close, get, etc.
		// Firefox - FirefoxDriver --> Methods: close, get, etc.
		// Safari - SafariDriver --> Methods: close, get, etc.
		// WebDriver --> close, get, etc.
		
		// chromedriver.exe --> Chrome browser
		// step to invoke chrome driver 
		// Selenium Manager
		
		// chromedriver.exe -> Chrome browser
		// steo to invoke Chrome driver 
		// Selenium Manager
		// System.setProperty("webdriver.chrome.driver", "C:/Mattia/Test Automation/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// aprire una specifica pagina in chrome
		driver.get("https://www.codicefiscaleonline.com/");
		
		// recupero il titolo di una pagina
		String titolo = driver.getTitle();
		// lo stampo in console
		System.out.println(titolo);
		
		// recupero l'url corrente della pagina
		driver.getCurrentUrl();
		
		// la stampo in console
		System.out.println(driver.getCurrentUrl());
		
		// chiudo il browser
		driver.quit();
		
		
		// Eseguire lo script in firefox
		// come per chrome possiamo utilizzare l'equivalente di chromedriver per firefox -> gecko driver
		// webdriver.gecko.driver
		System.setProperty("webdriver.chrome.driver", "C:/Mattia/Test Automation/geckodriver/geckodriver.exe");
		WebDriver driverFirefox = new FirefoxDriver();
		driverFirefox.get("https://www.codicefiscaleonline.com/");
		driverFirefox.getTitle();
		System.out.println(driverFirefox.getTitle());
		System.out.println(driverFirefox.getCurrentUrl());
		driverFirefox.quit();
		
		
		// Eseguire lo script in Edge
		System.setProperty("webdriver.edge.driver", "C:/Mattia/Test Automation/edgedriver_win64/msedgedriver.exe");
		WebDriver driverEdge = new EdgeDriver();
		driverEdge.get("https://www.codicefiscaleonline.com/");
		driverEdge.getTitle();
		System.out.println(driverEdge.getTitle());
		System.out.println(driverEdge.getCurrentUrl());
		driverEdge.quit();
		
	}

}
