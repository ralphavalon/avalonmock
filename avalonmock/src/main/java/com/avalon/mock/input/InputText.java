package com.avalon.mock.input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;


public class InputText extends Input {
	
	private PodamFactory podam;
	
	public InputText(WebElement webElement, WebDriver webDriver) {
		super(webElement, webDriver);
		this.podam = new PodamFactoryImpl();
	}

	public void execute() {
		final Text text = podam.manufacturePojo(Text.class);
		webElement.sendKeys(text.value);
	}
	
	class Text {
		private String value;

		public void setValue(String value) {
			this.value = value;
		}
	}

}