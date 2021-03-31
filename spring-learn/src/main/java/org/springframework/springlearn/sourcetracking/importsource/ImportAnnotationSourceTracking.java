package org.springframework.springlearn.sourcetracking.importsource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.springlearn.sourcetracking.importsource.beanclass.ImportedClazz;

/**
 * {@link org.springframework.context.annotation.Import} 源码分析
 *
 * @author ZhengYu
 * @version 1.0 2021/3/30 11:25
 **/
@Import(ImportedClazz.class)
public class ImportAnnotationSourceTracking implements ImportAware {

	private AnnotationMetadata importMetadata;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.register(ImportAnnotationSourceTracking.class);

		applicationContext.refresh();

		ImportedClazz importedClazz = applicationContext.getBean(ImportedClazz.class);
		importedClazz.selfIntroduce();

		applicationContext.close();
	}

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		this.importMetadata = importMetadata;
	}
}
