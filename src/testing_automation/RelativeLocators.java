package testing_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		// let's find "Name" field and from that we select the label wich is above the field "Name"
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		// let's target the input field wich is below the target "Date of birth" label
		WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
		
		// let's use the "left" relative locators to check the checkbox to the left of the label "Check me out if you Love IceCreams!"
		WebElement checkText = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkText)).click();
		
		// Let's focus on "toRight"finding the text wich is to right of the first radio button
		WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
		driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText();
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
	}

}
