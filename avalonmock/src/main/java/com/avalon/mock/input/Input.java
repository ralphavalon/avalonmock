package com.avalon.mock.input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public abstract class Input {
	
	protected WebElement webElement;
	protected WebDriver webDriver;
	
	public Input(WebElement webElement, WebDriver webDriver) {
		this.webElement = webElement;
		this.webDriver = webDriver;
	}
	
	public abstract void execute();
	
}
