package com.avalon.mock.provider.strategy;

import java.util.Arrays;
import java.util.List;

import uk.co.jemos.podam.api.AbstractRandomDataProviderStrategy;
import uk.co.jemos.podam.api.AttributeMetadata;

public class EmailProviderStrategy extends AbstractRandomDataProviderStrategy {

	private List<String> endingList = Arrays.asList(".com", ".net", ".org", ".biz", ".info");
	private List<String> mailList = Arrays.asList("gmail", "yahoo", "hotmail", "mailinator");
	private static final String AT = "@";
	
    @Override
    public String getStringValue(AttributeMetadata attributeMetadata) {
            String username = super.getStringValue(attributeMetadata);
            String mail = mailList.get((int) (Math.random() * mailList.size()));
            String ending = endingList.get((int) (Math.random() * endingList.size()));
            
            StringBuffer sb = new StringBuffer();
            sb.append(username);
			sb.append(AT);
			sb.append(mail);
			sb.append(ending);
			
			return sb.toString();
    }
}