package com.avalon.mock.input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class InputNullObject extends Input {
	
	public InputNullObject(WebElement webElement, WebDriver webDriver) {
		super(webElement, webDriver);
	}

	@Override
	public void execute() {};
}