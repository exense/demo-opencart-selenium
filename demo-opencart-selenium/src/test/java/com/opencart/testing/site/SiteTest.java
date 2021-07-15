package com.opencart.testing.site;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencart.testing.page.IndexPage;
import com.opencart.testing.page.LoginPage;

public class SiteTest {

	@Test
	public void testOpenCart() {
		WebDriver webDriver = new ChromeDriver();

		Site site = new Site(webDriver);

		LoginPage page = site.gotoLoginPage();
		page.setEmail("demo").setPassword("demo").clickSubmit();

		IndexPage indexPage = site.gotoIndexPage();
		indexPage.gotoDesktopsCategory();
		
		webDriver.quit();
	}
	
	@Test
	public void testLaptopsCategory() {
		WebDriver webDriver = new ChromeDriver();

		Site site = new Site(webDriver);

		LoginPage page = site.gotoLoginPage();
		page.setEmail("demo").setPassword("demo").clickSubmit();

		IndexPage indexPage = site.gotoIndexPage();
		indexPage.gotoLaptopsCategory();
		
		webDriver.quit();
	}
}