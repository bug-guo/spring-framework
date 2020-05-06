package com.smart.smile.test;

import com.smart.smile.domain.User;
import com.smart.smile.service.MyImportBeanDefinitionRegistrar;
import com.smart.smile.service.MyImportSelector;
import org.springframework.context.annotation.*;

import java.lang.annotation.Annotation;

@Configuration
@ComponentScan(value = "com.smart.smile.*",excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Configuration.class)
})
//@Import(value = MyImportSelector.class)		// 按类型装配bean  byType
//@Import(value = MyImportBeanDefinitionRegistrar.class)		// 装配bean  byType and byName
public class SpringIOCConfig {

	/**
	 * id user
	 * @return
	 */
//	@Bean
//	public User user() {
//		return new User();
//	}


}


