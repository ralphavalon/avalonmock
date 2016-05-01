package com.avalon.mock.factory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

import org.junit.Test;

import com.avalon.mock.element.HtmlElement;
import com.avalon.mock.input.InputNullObject;

public class HtmlElementFactoryTest extends AbstractEnumTest<HtmlElementFactory> {
	
	public HtmlElementFactoryTest() {
		super(HtmlElementFactory.class);
	}
	
	@Test
	public void shouldDoNothingWhenElementNotFound() {
		final HtmlElement htmlElement = HtmlElementFactory.getInstanceByFormElement("", null, null);
		assertThat(htmlElement, instanceOf(InputNullObject.class));
	}
	
	@Test
	public void shouldDoNothingWhenParametersInvalid() {
		HtmlElementFactory.getInstanceByFormElement("input", null, null);
	}

}