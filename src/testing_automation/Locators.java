package testing_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Mattia/Test Automation/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// raggiungo la pagina web
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// identifico il campo per inserire il nome utente e inserisco il valore tramite il metodo "sendKeys()"
		driver.findElement(By.id("inputUsername")).sendKeys("mattiacavalieri@gmail.com");
		// identifico il campo per inserire l'indirizzo email e inserisco il valore tramite il metodo "sendKeys()"
		driver.findElement(By.name("inputPassword")).sendKeys("R1verside.2025!");
		// identifico il pulsante per effettuare il login e lo clicco
		driver.findElement(By.className("submit")).click();
	

	}

}
