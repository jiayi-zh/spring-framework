package org.springframework.springlearn.conversion.propertyeditor.springway;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.springlearn.conversion.propertyeditor.propertyeditor.StringToPropertiesPropertyEditor;
import org.springframework.springlearn.entity.User;

/**
 * 自定义 {@link org.springframework.beans.PropertyEditorRegistrar} 实现
 *
 * @author ZhengYu
 * @version 1.0 2021/1/17 17:38
 **/
public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

	/**
	 * 自定义 PropertyEditor 扩展
	 *
	 * @param registry PropertyEditorRegistry
	 * @author ZhengYu
	 */
	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(User.class, "properties", new StringToPropertiesPropertyEditor());
	}
}
