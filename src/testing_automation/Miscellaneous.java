package testing_automation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscellaneous {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();

		// massimizzare la finestra del browser a tutto schermo
		driver.manage().window().maximize();
		// cancellare tutti i cookies nel browser
		//driver.manage().deleteAllCookies();
		// cancellare un cookie specifico, fornendo il nome del cookie che dobbiamo
		// cancellare, come ad esempio i cookie di sessione
		// driver.manage().deleteCookieNamed("sessionKey");

		driver.get("https://google.com");

		// prendere uno screenshot:
		// dobbiamo fare un cast di TakesScreenshot su driver e memorizzare l'output in
		// un file
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://Mattia//Test Automation/screenshot.png"));

	}

}
