package com.opencart.testing.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opencart.testing.object.PageObject;

@PageObject
public class LoginPage {

	private WebElement email;

	private WebElement password;

	@FindBy(css = "input[type='submit']")
	private WebElement submitButton;

	public LoginPage setEmail(String text) {
		email.clear();
		email.sendKeys(text);
		return this;
	}

	public LoginPage setPassword(String text) {
		password.clear();
		password.sendKeys(text);
		return this;
	}

	public LoginPage clickSubmit() {
		submitButton.click();
		return this;
	}

}