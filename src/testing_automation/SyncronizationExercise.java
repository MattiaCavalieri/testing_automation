package testing_automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncronizationExercise {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		// Username
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		// Password
		driver.findElement(By.id("password")).sendKeys("Learning@830$3mK2");
		// User -> si apre un pop-up -> Okay
		driver.findElement(By.xpath("//input[@value='user']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		// Consultant
		driver.findElement(By.xpath("//select/option[3]")).click();
		// I agree.....
		driver.findElement(By.id("terms")).click();
		// Sign In
		driver.findElement(By.id("signInBtn")).click();

		// attesa esplicita per permettere il caricamento della pagina
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("card")));

		// recupero tutti gli elementi della vetrina
		List<WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
		System.out.println("In questa vetrina ci sono " + products.size() + " prodotti");
		
		// aggiungo ogni elemento al carrello
		for (int i=0; i< products.size(); i++) {
			products.get(i).click();
		}
		driver.findElement(By.partialLinkText("Checkout")).click();
	}

}
