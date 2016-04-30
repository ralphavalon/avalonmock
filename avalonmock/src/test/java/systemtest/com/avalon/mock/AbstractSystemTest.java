package systemtest.com.avalon.mock;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractSystemTest {
	
	protected WebDriver webDriver;
	protected final String checkboxName = "hobbies[]";
	protected final String radioName = "gender";
	protected final String inputTextName = "fullname";
	protected final String inputEmailName = "email";
	
	protected static final String EMAIL_REGEX = "[\\w\\.-]*[a-zA-Z0-9_]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]";
	protected final String checkboxesCheckedCssSelectorTemplate = "input:checked[type='checkbox'][name='%s']";
	protected final String radiosCheckedCssSelectorTemplate = "input:checked[type='radio'][name='%s']";
	
	protected WebElement getElementByName(String elementName) {
		return webDriver.findElement(By.name(elementName));
	}
	
	protected List<WebElement> getElementsByCssSelector(String selector) {
		return webDriver.findElements(By.cssSelector(selector));
	}

}