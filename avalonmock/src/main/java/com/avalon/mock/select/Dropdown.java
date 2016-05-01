package com.avalon.mock.select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.avalon.mock.element.HtmlElement;


public class Dropdown extends HtmlElement {
	
	public Dropdown(WebElement webElement, WebDriver webDriver) {
		super(webElement, webDriver);
	}

	@Override
	public void execute() {
		Select select = new Select(webElement);
		int optionsQuantity = select.getOptions().size();
		select.selectByIndex((int) (Math.random() * optionsQuantity));
	}

}