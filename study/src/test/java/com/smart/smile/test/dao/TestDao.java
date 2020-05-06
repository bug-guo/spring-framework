package com.smart.smile.test.dao;

import com.smart.smile.dao.Person;
import com.smart.smile.dao.jdbcTemplate.JdbcTemplateConfiguration;
import com.smart.smile.dao.jdbcTemplate.PersonService;
import com.smart.smile.dao.namedparameterjdbctemplate.MyNamedParameterJdbcTemplate;
import com.smart.smile.dao.namedparameterjdbctemplate.NamedParameterJdbcTemplateConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDao {

	private AnnotationConfigApplicationContext applicationContext;

	@Test
	public void testJdbcTemplate() {
		applicationContext = new AnnotationConfigApplicationContext(JdbcTemplateConfiguration.class);
		PersonService bean = applicationContext.getBean(PersonService.class);
//		bean.query();
//		bean.update();
//		bean.create();
		// 自增key
		bean.creatReturingAutoCreatementKey();
	}



	@Test
	public void testNameParamterJdbcTempalte() {
		applicationContext = new AnnotationConfigApplicationContext(NamedParameterJdbcTemplateConfiguration.class);
		MyNamedParameterJdbcTemplate bean = applicationContext.getBean(MyNamedParameterJdbcTemplate.class);
		System.out.println(bean.countOfUsername("zhangsan"));
		System.out.println(bean.countOfAge(12));

		Person person = new Person();
		person.setAge(12);
		person.setUsername("zhangsan");
		System.out.println(bean.countOfPerson(person));

	}

}
