package testing_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownExcercise {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// Name
		driver.findElement(By.name("name")).sendKeys("Mattia Cavalieri Manasse");

		// Email
		driver.findElement(By.name("email")).sendKeys("mattiacavalieri@gmail.com");

		// password
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("R1verside.2026");

		// Check Me out if you love IceCreams
		driver.findElement(By.id("exampleCheck1")).click();

		// dropdown Gender
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select gender = new Select(dropdown);
		gender.selectByVisibleText("Male");

		// employee status = Student
		driver.findElement(By.id("inlineRadio1")).click();

		// date of birth
		driver.findElement(By.name("bday")).sendKeys("12/06/1980");

		// submit
		driver.findElement(By.className("btn-success")).click();

		// locate confirmation text and print it out to console
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());

	}

}
