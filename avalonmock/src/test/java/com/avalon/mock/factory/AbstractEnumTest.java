package com.avalon.mock.factory;

import org.junit.Test;

public abstract class AbstractEnumTest<T extends Enum<?>> {
	
	private Class<? extends Enum<?>> enumClass;
	
	public AbstractEnumTest(Class<? extends Enum<?>> enumClass) {
		this.enumClass = enumClass;
	}
	
	@Test
	public void superficialEnumCodeCoverage() throws Exception {
		for (Object o : (Object[]) enumClass.getMethod("values").invoke(null)) {
			enumClass.getMethod("valueOf", String.class).invoke(null, o.toString());
		}
	}

}