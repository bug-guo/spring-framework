package com.smart.smile.webmvc.dispatcherservlet;


import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 使用注解的方式代替 web.xml方式配置
 * 优先推荐使用  继承 AbstractAnnotationConfigDispatcherServletInitializer
 *
 * @Author Zhiguo Chen
 * @Date 2020/3/25 17:41
 */
public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{AppCofig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}

/**
 * 使用xml文件进行配置
 */
class MyWebXmlApplicationInitializer extends AbstractDispatcherServletInitializer {

	@Override
	protected WebApplicationContext createServletApplicationContext() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		XmlWebApplicationContext context = new XmlWebApplicationContext();
		context.setConfigLocation("/webmvc/app-context.xml");
		return context;
	}

	/**
	 * 添加过滤器
	 * @return
	 */
	@Override
	protected Filter[] getServletFilters() {
//		return super.getServletFilters();
		return new Filter[]{ new HiddenHttpMethodFilter(),new CharacterEncodingFilter()};
	}
}
