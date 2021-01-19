package org.springframework.springlearn.conversion.propertyeditor.propertyeditor;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

/**
 * 将{@link java.lang.String} 类型的文本转换为 {@link java.util.Properties} 对象
 *
 * @author ZhengYu
 * @version 1.0 2021/1/17 16:52
 **/
public class StringToPropertiesPropertyEditor extends PropertyEditorSupport implements PropertyEditor {

	/**
	 * Step1: 覆盖 setAsText 方法
	 *
	 * @param text 待转换的文本
	 * @author ZhengYu
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Properties properties = new Properties();

		try {
			properties.load(new StringReader(text));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 暂存转换后的结果
		setValue(properties);
	}

	/**
	 * Step2: 返回结果
	 *
	 * @author ZhengYu
	 */
	@Override
	public String getAsText() {
		Properties value = (Properties) getValue();
		return value.toString();
	}
}
