package com.opencart.testing.site;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.opencart.testing.object.PageObject;
import com.opencart.testing.page.IndexPage;
import com.opencart.testing.page.LoginPage;

@PageObject
public class Site extends AbstractPage {

	private static final String BASE_URL = "http://opencart-prf.exense.ch/";

	private WebDriver driver;

	private LoginPage loginPage;

	private IndexPage indexPage;

	public Site(WebDriver webDriver) {
		this.driver = webDriver;
		this.loginPage = new LoginPage();
		this.indexPage = new IndexPage(driver);
	}

	public LoginPage gotoLoginPage() {
		driver.get(BASE_URL + "index.php?route=account/login");
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}

	public IndexPage gotoIndexPage() {
		driver.get(BASE_URL + "index.php");
		PageFactory.initElements(driver, indexPage);
		waitForElement(driver, "//*[@id=\"slideshow0\"]/div/div[3]",10);
		return indexPage;
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}

	public IndexPage getIndexPage() {
		return indexPage;
	}

	public WebDriver getWebDriver() {
		return driver;
	}
}
