package com.smart.smile.dao.namedparameterjdbctemplate;

import com.smart.smile.dao.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

@Component
public class MyNamedParameterJdbcTemplate {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	// 单参数
	public int countOfUsername(String username) {
		String sql = "select count(id) from person where username =:username";
		SqlParameterSource namedParameters = new MapSqlParameterSource("username", username);
		return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
	}

	// 多参数
	public int countOfAge(int age) {
		String sql = "select count(id) from person where age = :age";
		Map<String, Integer> namedParameters = Collections.singletonMap("age", age);
		return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
	}

	// 对象类
	public int countOfPerson(Person person) {
		String sql = "select count(id) from person where username = :username and age = :age";
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(person);
		return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
	}
}
