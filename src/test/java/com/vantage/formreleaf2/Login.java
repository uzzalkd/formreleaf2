package com.vantage.formreleaf2;

import org.testng.annotations.Test;

//import junit.framework.Assert;
import pageobjects.Home_Page;
import utility.Constant;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login {
	public WebDriver driver = new ChromeDriver();

	/*File file = new File("C:/Program Files/phantomjs-2.1.1-windows/bin/phantomjs.exe");
	System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
	public WebDriver driver = new PhantomJSDriver();*/

	public String expected = null;
	public String actual = null;
	public String expectedValidationMsg = null;

	@Test (priority = 1, description = "Check validation message when submitting blank username password")
	public void checkValidationMsgWhenBlankSubmit() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Home_Page.LoginBtn(driver).click();
		expected = "Incorrect username or password.";
		actual = driver.findElement(By.xpath("/html/body/div[3]/div/div/form/div[1]/div[1]/p")).getText();
		Assert.assertEquals(actual, expected);		
	}

	@Test (priority = 2, description = "Check validation message when submitting wrong username password")
	public void checkValidationMsgWhenUsernamePasswordWrong() {
		//Home_page.LoginMenu(driver).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Home_Page.UserName(driver).sendKeys(Constant.username);
		Home_Page.Password(driver).sendKeys("1234");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Home_Page.LoginBtn(driver).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//actual = driver.findElement(By.xpath("/html/body/div[3]/div/div/form/div[1]/div[1]/p")).getText();
		Assert.assertEquals(actual, expected);
	}

	@Test (priority = 3, description = "Check login method with valid username and password")
	public void loginSuccessful() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Home_Page.UserName(driver).sendKeys(Constant.username);
		Home_Page.Password(driver).sendKeys(Constant.password);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Home_Page.LoginBtn(driver).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		expected = "Programs :: FormREleaf";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);		
	}

	//@Test (priority = 4, description = "Visit different pages and check functionality")
	public void visitDifferentPages() throws InterruptedException {
		for (int i =1; i<100;i++) {
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(2000);
			driver.navigate().refresh();
			System.out.println(i);
		}

	}

	@Test (priority = 5, description = "Check logout functionality")
	public void logOut() {
		driver.findElement(By.xpath("//*[@id='navbar']/ul[2]/li[2]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id='navbar']/ul[2]/li[2]/ul/li[4]/a")).click();
		expected = "You have been logged out.";
		actual = driver.findElement(By.xpath("/html/body/div[3]/div/div/form/div[1]/div[2]")).getText();
		Assert.assertEquals(actual, expected);				
	}

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver.get(Constant.baseUrl);
		Home_Page.LoginMenu(driver).click();
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}

}

