package com.avalon.mock.input;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class InputCheckbox extends Input {
	
	private int checkboxes = 0;
	private String currentCheckboxName = "";
	private final String checkboxesXpathTemplate = "//input[@type='checkbox' and @name='%s']";
	private final String checkboxesCheckedCssSelectorTemplate = "input:checked[type='checkbox'][name='%s']";
	private int checkboxesChecked = 0;
	private int maxCheckboxesChecked = 0;
	
	public InputCheckbox(WebElement webElement, WebDriver webDriver) {
		super(webElement, webDriver);
	}

	public void execute() {
		String checkboxName = webElement.getAttribute("name");
		resetValuesIfNeeded(checkboxName);
		if(StringUtils.isNotEmpty(checkboxName) && checkboxName.equals(currentCheckboxName)) {
			
			List<WebElement> checkboxesList = webElement.findElements(By.xpath(String.format(checkboxesXpathTemplate, checkboxName)));
			setCheckboxesQuantity(checkboxesList);
			
			String checkboxesCheckedCssSelector = String.format(checkboxesCheckedCssSelectorTemplate, checkboxName);
			List<WebElement> checkboxesCheckedList = webDriver.findElements(By.cssSelector(checkboxesCheckedCssSelector));
			
			checkboxesChecked = checkboxesCheckedList.size();
			maxCheckboxesChecked = (int) Math.round((double) checkboxes/2);
			
			clickOnCheckboxes(checkboxesList);
		} 
		
	}

	private void resetValuesIfNeeded(String checkboxName) {
		if(StringUtils.isEmpty(currentCheckboxName) || !currentCheckboxName.equals(checkboxName)) {
			currentCheckboxName = checkboxName;
			checkboxes = 0;
		}
	}

	private void clickOnCheckboxes(List<WebElement> checkboxesList) {
		while(checkboxesChecked != maxCheckboxesChecked) {
			WebElement checkbox = checkboxesList.get((int) (Math.random() * checkboxes));
			if(!checkbox.isSelected()) {
				checkbox.click();
				checkboxesChecked++;
			}
		}
	}

	private void setCheckboxesQuantity(List<WebElement> checkboxesList) {
		if(checkboxes == 0) {
			checkboxes = checkboxesList.size();
		}
	}

}