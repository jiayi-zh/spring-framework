package org.springframework.springlearn.conversion.propertyeditor.nativeway;

import org.springframework.springlearn.conversion.propertyeditor.propertyeditor.StringToPropertiesPropertyEditor;

import java.beans.PropertyEditor;

/**
 * {@link java.beans.PropertyEditor} 类型转换测试 - 原生
 * Spring内建的 PropertyEditor 实现:
 * {@link org.springframework.beans.propertyeditors.ByteArrayPropertyEditor}
 *
 * @author ZhengYu
 * @version 1.0 2021/1/17 16:59
 **/
public class PropertyEditorNativeTest {
	public static void main(String[] args) {
		PropertyEditor propertyEditor = new StringToPropertiesPropertyEditor();

		propertyEditor.setAsText("name=jiayi-zh");

		System.out.println(propertyEditor.getValue());
	}
}
