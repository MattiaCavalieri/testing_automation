package testing_automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsDemo {
	// in questa sezione vediamo come gestire gli eventi del click del mouse et
	// similari

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/");
		// creiamo una action di tipo Actions
		Actions action = new Actions(driver);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList-nav-line-1")));
		WebElement move = driver.findElement(By.id("nav-link-accountList-nav-line-1"));

		// inseriamo il testo "HELLO" simulando la pressione di SHIFT con i metodi della
		// classe Actions
		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
				.sendKeys("hello").doubleClick().build().perform();

		// spostiamo il mouse su "account and lists"
		action.moveToElement(move).contextClick().build().perform();

	}

}
