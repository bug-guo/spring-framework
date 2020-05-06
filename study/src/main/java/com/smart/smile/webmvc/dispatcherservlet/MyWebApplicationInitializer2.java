package com.smart.smile.webmvc.dispatcherservlet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 使用注解的方式代替 web.xml方式配置
 * 优先推荐使用  继承 AbstractAnnotationConfigDispatcherServletInitializer
 * @author Zhiguo Chen
 * @date 2020/3/25 17:41
 */
public class MyWebApplicationInitializer2 implements WebApplicationInitializer {
	@Override
	public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
		// 加载Spring配置类
		// 配置文件的方式
//		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
//		appContext.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");
		// 注解的方式
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppCofig.class);
		context.refresh();

		// 加载web配置
		DispatcherServlet servlet = new DispatcherServlet(context);
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/app/*");
	}
}
