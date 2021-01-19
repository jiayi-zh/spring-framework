package org.springframework.springlearn.conversion.converter.converter;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.util.Collections;
import java.util.Properties;
import java.util.Set;

/**
 * 自定义类型转换
 *
 * @author ZhengYu
 * @version 1.0 2021/1/19 8:42
 **/
public class PropertiesToStringConverter implements ConditionalGenericConverter {

	@Override
	public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
		return Properties.class == sourceType.getType() && String.class == targetType.getType();
	}

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		return Collections.singleton(new ConvertiblePair(Properties.class, String.class));
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Properties prop = (Properties) source;
		return prop.toString();
	}
}
