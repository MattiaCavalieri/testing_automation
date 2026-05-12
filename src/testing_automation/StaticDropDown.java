package testing_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) {
		// inizializzo il driver e navigo verso il link di test
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// Selezionare una voce di un menu drop down
		
		// creo "staticDropdown" come un oggetto WebElement
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		// agisco sul dropdown
		Select dropdown = new Select(staticDropdown);
		// individuo "USD" - indice 3
		dropdown.selectByIndex(3);
		// mi assicuro che sia selezionato tramite getFirstSelectedOption()
		dropdown.getFirstSelectedOption();
		// lo stampo in console giusto a scopo didattico
		System.out.println(dropdown.getFirstSelectedOption().getText());
		// posso selezionare una delle opzioni anche usando selectByVisibleText()
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		// oppure per value, recuperandolo ispezionando il codice HTML
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}

}
