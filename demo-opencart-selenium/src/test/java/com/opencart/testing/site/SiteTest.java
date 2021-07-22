package com.opencart.testing.site;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencart.testing.page.IndexPage;
import com.opencart.testing.page.LoginPage;

public class SiteTest {

	@Test
	public void testDesktopsCategory() {
		WebDriver webDriver = new ChromeDriver();

		Site site = new Site(webDriver);

		LoginPage page = site.gotoLoginPage();
		page.setEmail("demo").setPassword("demo").clickSubmit();

		IndexPage indexPage = site.gotoIndexPage();
		indexPage.clickSubMenuLink("Desktops", "PC");
		indexPage.clickSubMenuLink("Desktops", "Mac");
		indexPage.clickSubMenuLink("Laptops", "Macs");
		indexPage.clickSubMenuLink("Laptops", "Windows");

		webDriver.quit();
	}

	@Test
	public void testComponentsCategory() {
		WebDriver webDriver = new ChromeDriver();

		Site site = new Site(webDriver);

		LoginPage page = site.gotoLoginPage();
		page.setEmail("demo").setPassword("demo").clickSubmit();

		IndexPage indexPage = site.gotoIndexPage();
		indexPage.clickSubMenuLink("Components", "Mice and Trackballs");
		indexPage.clickSubMenuLink("Components", "Monitors");
		indexPage.clickSubMenuLink("Components", "Printers");
		indexPage.clickSubMenuLink("Components", "Scanners");
		indexPage.clickSubMenuLink("Components", "Web Cameras");

		webDriver.quit();
	}
}