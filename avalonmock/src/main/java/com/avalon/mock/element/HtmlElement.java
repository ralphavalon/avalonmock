package com.avalon.mock.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class HtmlElement {
	
	protected WebElement webElement;
	protected WebDriver webDriver;
	
	public HtmlElement(WebElement webElement, WebDriver webDriver) {
		this.webElement = webElement;
		this.webDriver = webDriver;
	}
	
	public abstract void execute();

}