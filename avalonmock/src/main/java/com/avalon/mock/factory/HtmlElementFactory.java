package com.avalon.mock.factory;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.avalon.mock.element.HtmlElement;
import com.avalon.mock.input.InputNullObject;

public enum HtmlElementFactory {
	
	INPUT(Arrays.asList("input"), InputFactory.class),
	DROPDOWN(Arrays.asList("select", "datalist"), DropdownFactory.class);
	
	private List<String> formElementList;
	private Class<? extends Enum<?>> clazz;
	
	private HtmlElementFactory(List<String> formElementList, Class<? extends Enum<?>> clazz) {
		this.formElementList = formElementList;
		this.clazz = clazz;
	}
	
	public static HtmlElement getInstanceByFormElement(String formElement, WebElement webElement, WebDriver webDriver) {
		for (HtmlElementFactory htmlElementFactory : HtmlElementFactory.values()) {
			if(htmlElementFactory.formElementList.contains(formElement)) {
				try {
					final Method getInstanceMethod = htmlElementFactory.clazz.getMethod("getInstance", WebElement.class, WebDriver.class);
					return (HtmlElement) getInstanceMethod.invoke(htmlElementFactory.clazz, webElement, webDriver);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return new InputNullObject(webElement, webDriver);
	}

}