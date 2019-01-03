package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Signup_Page {
	private static WebElement element = null;

	public static WebElement Email(WebDriver driver){
		element = driver.findElement(By.name("email"));
		return element;
	}
	public static WebElement FirstName(WebDriver driver){
		element = driver.findElement(By.name("firstName"));
		return element;
	}
	public static WebElement LastName(WebDriver driver){
		element = driver.findElement(By.name("lastName"));
		return element;
	}
	public static WebElement Password(WebDriver driver){
		element = driver.findElement(By.name("password"));
		return element;
	}
	public static WebElement PasswordConfirmed(WebDriver driver){
		element = driver.findElement(By.name("passwordConfirmed"));
		return element;
	}

}
