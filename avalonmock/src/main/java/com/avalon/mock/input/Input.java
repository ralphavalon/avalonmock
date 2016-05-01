package com.avalon.mock.input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.avalon.mock.element.HtmlElement;


public abstract class Input extends HtmlElement {

	public Input(WebElement webElement, WebDriver webDriver) {
		super(webElement, webDriver);
	}
	
}