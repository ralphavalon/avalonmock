package com.avalon.mock.input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import com.avalon.mock.provider.strategy.EmailProviderStrategy;


public class InputEmail extends Input {
	
	private PodamFactory podam;
	
	public InputEmail(WebElement webElement, WebDriver webDriver) {
		super(webElement, webDriver);
		this.podam = new PodamFactoryImpl(new EmailProviderStrategy());
	}

	public void execute() {
		final Email email = podam.manufacturePojo(Email.class);
		webElement.sendKeys(email.value);
	}
	
	class Email {
		private String value;

		public void setValue(String value) {
			this.value = value;
		}
	}

}