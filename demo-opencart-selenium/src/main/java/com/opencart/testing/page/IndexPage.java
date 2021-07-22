package com.opencart.testing.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.opencart.testing.object.PageObject;
import com.opencart.testing.site.AbstractPage;

@PageObject
public class IndexPage extends AbstractPage {

	@FindBy(how = How.LINK_TEXT, using = "Desktops")
	private WebElement desktops;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Laptops")
	private WebElement laptops;

	@FindBy(how = How.LINK_TEXT, using = "Components")
	private WebElement components;

	@FindBy(how = How.LINK_TEXT, using = "Tablets")
	private WebElement tablets;

	private WebDriver driver;

	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSubMenuLink(String mainMenuName, String subMenuName) {
		WebElement parentElement;
		if (mainMenuName.equals("Desktops")) {
			parentElement = desktops;
		} else if (mainMenuName.equals("Laptops")) {
			parentElement = laptops;
		} else if (mainMenuName.equals("Components")) {
			parentElement = components;
		} else if (mainMenuName.equals("Tablets")) {
			parentElement = tablets;
		} else {
			throw new RuntimeException("Unknown menu " + mainMenuName);
		}
		clickSubMenuLink(parentElement, subMenuName);
		waitForContent();
	}

	private void hoverHoverLink(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	private void clickSubMenuLink(WebElement parentElement, String partialLinkText) {
		hoverHoverLink(parentElement);
		driver.findElement(By.partialLinkText(partialLinkText)).click();
	}

	private void waitForContent() {
		waitForElement(driver, "//*[@id=\"content\"]/h2", 10);
	}

}