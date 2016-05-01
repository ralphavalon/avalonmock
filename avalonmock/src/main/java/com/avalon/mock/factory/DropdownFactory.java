package com.avalon.mock.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.avalon.mock.select.Dropdown;

public enum DropdownFactory {
	
	DROPDOWN(Dropdown.class);
	
	private Class<Dropdown> clazz;
	private static Map<Class<Dropdown>, Dropdown> instanceMap = new HashMap<Class<Dropdown>, Dropdown>();
	
	private DropdownFactory(Class<Dropdown> clazz) {
		this.clazz = clazz;
	}
	
	private static Class<Dropdown> getDropdownClass() {
		return DropdownFactory.values()[0].clazz;
	}
	
	public static Dropdown getInstance(WebElement webElement, WebDriver webDriver) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<Dropdown> dropdownClass = getDropdownClass();
		if(!instanceMap.containsKey(dropdownClass)) {
			instanceMap.put(dropdownClass, dropdownClass.getConstructor(WebElement.class, WebDriver.class).newInstance(webElement, webDriver));
		}
		return instanceMap.get(dropdownClass);
	}

}