package com.opencart.testing.site;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbstractPage {

	public AbstractPage() {
		super();
	}

	protected void waitForElement(WebDriver driver, String xpath, long timeout) {
		By element = By.xpath(xpath);
		//calling helper method to poll until given web element is visible or a timeout occurs
		retryWhileFalse(() -> driver.findElement(element).isDisplayed(), timeout);
	}

	protected void retryWhileFalse(Supplier<Boolean> condition, long timeout) {
		long t1 = System.currentTimeMillis();
		Exception lastException = null;
		do {
			try {
				if (condition.get()) {
					return;
				}
			} catch (Exception e) {
				lastException = e;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		} while (System.currentTimeMillis() < t1 + (timeout * 1000));
		throw new RuntimeException("Timeout while waiting for condition to apply.", lastException);
	}

}