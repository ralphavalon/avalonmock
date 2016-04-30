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

import com.avalon.mock.factory.InputFactory;
import com.avalon.mock.input.Input;

public class WithoutDTOTest extends AbstractSystemTest {
	
	@Test
	public void allFieldsShouldBeFilled() throws Exception {
		String url = new File("testSample/sample.html").getAbsolutePath();
		webDriver = new FirefoxDriver();
		webDriver.get(url);
		
		List<WebElement> elements = webDriver.findElements(By.cssSelector("input"));
		
		for (WebElement webElement : elements) {
			Input input = InputFactory.getInputInstance(webElement, webDriver);
			input.execute();
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
	}

}