package com.avalon.mock;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.avalon.mock.factory.InputFactory;
import com.avalon.mock.input.Input;


public class Test {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String url = "http://parsleyjs.org/doc/examples/simple.html";
		WebDriver webDriver = new FirefoxDriver();
		webDriver.get(url);
		
		List<WebElement> elements = webDriver.findElements(By.cssSelector("input"));
		
		for (WebElement webElement : elements) {
			System.out.println(webElement.getTagName() + " " + webElement.getAttribute("type") + " " + webElement.getAttribute("name"));
			Input input = InputFactory.getInputInstance(webElement, webDriver);
			input.execute();
		}
	}
}
