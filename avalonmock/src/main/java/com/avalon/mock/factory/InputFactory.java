package com.avalon.mock.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.avalon.mock.input.Input;
import com.avalon.mock.input.InputCheckbox;
import com.avalon.mock.input.InputEmail;
import com.avalon.mock.input.InputNullObject;
import com.avalon.mock.input.InputRadio;
import com.avalon.mock.input.InputText;

public enum InputFactory {
	
	INPUT_TEXT("text", InputText.class),
	INPUT_EMAIL("email", InputEmail.class),
	INPUT_CHECKBOX("checkbox", InputCheckbox.class),
	INPUT_RADIO("radio", InputRadio.class);
	
	private String type;
	private Class<? extends Input> clazz;
	private static Map<Class<? extends Input>, Input> instanceMap = new HashMap<Class<? extends Input>, Input>();
	
	private InputFactory(String type, Class<? extends Input> clazz) {
		this.type = type;
		this.clazz = clazz;
	}
	
	private static Class<? extends Input> getInputClassByType(String type) {
		for (InputFactory inputFactory : InputFactory.values()) {
			if(inputFactory.type.equals(type)) {
				return inputFactory.clazz;
			}
		}
		return InputNullObject.class;
	}
	
	public static Input getInputInstance(WebElement webElement, WebDriver webDriver) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<? extends Input> inputClass = getInputClassByType(webElement.getAttribute("type"));
		if(!instanceMap.containsKey(inputClass)) {
			instanceMap.put(inputClass, inputClass.getConstructor(WebElement.class, WebDriver.class).newInstance(webElement, webDriver));
		}
		return instanceMap.get(inputClass);
	}

}