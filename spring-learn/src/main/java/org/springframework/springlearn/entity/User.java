package org.springframework.springlearn.entity;

import java.util.Properties;

/**
 * 通用测试实体类
 *
 * @author ZhengYu
 * @version 1.0 2021/1/16 22:21
 **/
public class User {

	private Long id;

	private String name;

	private Integer age;

	/**
	 * 类型转换测试 {@link org.springframework.springlearn.conversion.propertyeditor.springway.PropertyEditorSpringTest}
	 */
	private Properties properties;

	/**
	 * 类型转换测试 {@link org.springframework.springlearn.conversion.converter.ConditionalGenericConverterTest}
	 */
	private String extInfo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getExtInfo() {
		return extInfo;
	}

	public void setExtInfo(String extInfo) {
		this.extInfo = extInfo;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", properties=" + properties +
				", extInfo='" + extInfo + '\'' +
				'}';
	}
}
