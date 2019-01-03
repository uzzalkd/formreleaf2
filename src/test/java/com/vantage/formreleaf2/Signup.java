package com.vantage.formreleaf2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Signup_Page;
import utility.Constant;

public class Signup extends Login{
	
	//driver.get(baseUrl + "/signup");
	
	@Test (priority = 1, description = "Check signup functionality")
	public void logOut() {
		driver.get(Constant.baseUrl+"/signup");
		Signup_Page.Email(driver).sendKeys(Constant.email);
		Signup_Page.FirstName(driver).sendKeys(Constant.firstName);
		Signup_Page.LastName(driver).sendKeys(Constant.lastName);
		Signup_Page.Password(driver).sendKeys(Constant.signupPassword);
		Signup_Page.PasswordConfirmed(driver).sendKeys(Constant.signupPasswordConfirmed);
		
		
	}

}
