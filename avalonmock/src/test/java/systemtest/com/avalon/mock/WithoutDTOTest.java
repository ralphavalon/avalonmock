package systemtest.com.avalon.mock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.avalon.mock.element.HtmlElement;
import com.avalon.mock.factory.HtmlElementFactory;

public class WithoutDTOTest extends AbstractSystemTest {
	
	@Test
	public void allFieldsShouldBeFilled() throws Exception {
		String url = new File("testSample/sample.html").getAbsolutePath();
		webDriver = new FirefoxDriver();
		webDriver.get(url);
		
		for (String availableFormElement : availableFormElements) {
			List<WebElement> elements = webDriver.findElements(By.cssSelector(availableFormElement));
			
			for (WebElement webElement : elements) {
				HtmlElement htmlElement = HtmlElementFactory.getInstanceByFormElement(availableFormElement, webElement, webDriver);
				htmlElement.execute();
			}
		}
		
		assertThat(StringUtils.isNotEmpty(getElementByName(inputTextName).getAttribute("value")), is(true));
		
		final String email = getElementByName(inputEmailName).getAttribute("value");
		assertThat(StringUtils.isNotEmpty(email), is(true));
		assertThat(email.matches(EMAIL_REGEX), is(true));
		
		String checkboxesCheckedCssSelector = String.format(checkboxesCheckedCssSelectorTemplate, checkboxName);
		List<WebElement> checkboxesCheckedList = getElementsByCssSelector(checkboxesCheckedCssSelector);
		assertThat(checkboxesCheckedList.size(), equalTo(3));
		
		String radiosCheckedCssSelector = String.format(radiosCheckedCssSelectorTemplate, radioName);
		List<WebElement> radiosCheckedList = getElementsByCssSelector(radiosCheckedCssSelector);
		assertThat(radiosCheckedList.size(), equalTo(1));
		
		String selectCssSelector = String.format(selectCssSelectorTemplate, selectId);
		WebElement selectElement = getElementByCssSelector(selectCssSelector);
		Select select = new Select(selectElement);
		assertThat(select.getAllSelectedOptions().size(), equalTo(1));
		
	}

}