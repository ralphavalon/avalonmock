package com.avalon.mock.input;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class InputRadio extends Input {
	
	private int radios = 0;
	private String currentRadioName = "";
	private final String radiosXpathTemplate = "//input[@type='radio' and @name='%s']";
	private final String radiosCheckedCssSelectorTemplate = "input:checked[type='radio'][name='%s']";
	private int radiosChecked = 0;
	
	public InputRadio(WebElement webElement, WebDriver webDriver) {
		super(webElement, webDriver);
	}

	@Override
	public void execute() {
		String radioName = webElement.getAttribute("name");
		resetValuesIfNeeded(radioName);
		if(StringUtils.isNotEmpty(radioName) && radioName.equals(currentRadioName)) {
			
			List<WebElement> radiosList = webElement.findElements(By.xpath(String.format(radiosXpathTemplate, radioName)));
			setRadiosQuantity(radiosList);
			
			String radiosCheckedCssSelector = String.format(radiosCheckedCssSelectorTemplate, radioName);
			List<WebElement> radiosCheckedList = webDriver.findElements(By.cssSelector(radiosCheckedCssSelector));
			
			radiosChecked = radiosCheckedList.size();
			
			if(radiosChecked == 0) {
				clickOnRadios(radiosList);
			}
		} 
		
	}

	private void resetValuesIfNeeded(String radioName) {
		if(StringUtils.isEmpty(currentRadioName) || !currentRadioName.equals(radioName)) {
			currentRadioName = radioName;
			radios = 0;
		}
	}

	private void clickOnRadios(List<WebElement> radiosList) {
		WebElement radio = radiosList.get((int) (Math.random() * radios));
		radio.click();
	}

	private void setRadiosQuantity(List<WebElement> radiosList) {
		if(radios == 0) {
			radios = radiosList.size();
		}
	}

}