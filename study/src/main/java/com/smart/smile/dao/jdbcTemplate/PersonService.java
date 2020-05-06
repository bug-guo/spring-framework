package com.smart.smile.dao.jdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class PersonService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void query() {
		Integer queryCount = this.jdbcTemplate.queryForObject("select count(id) from person", Integer.class);
		System.out.println("total count: " + queryCount);

		Integer queryAge = this.jdbcTemplate.queryForObject("select count(id) from person where age=?", Integer.class, 12);
		System.out.println("the count of age is 12: " + queryAge);

		// 数组类型参数
		String queryUsername = this.jdbcTemplate.queryForObject("select username from person where id=?", new Object[]{1}, String.class);
		System.out.println("query id = 1, username : " + queryUsername);

		queryAge = this.jdbcTemplate.queryForObject("select age from person where id = ? and username=?", new Object[]{1, "zhangsan"}, Integer.class);
		System.out.println("id =1,username='zhangsan' age: " + queryAge);

		// 结果填充模型对象
		JdbcPerson jdbcPerson = this.jdbcTemplate.queryForObject("select id,username,age from person where id = ?", new Object[]{1}, new RowMapper<JdbcPerson>() {
			@Override
			public JdbcPerson mapRow(ResultSet rs, int rowNum) throws SQLException {
				JdbcPerson person = new JdbcPerson();
				person.setId(rs.getInt("id"));
				person.setUsername(rs.getString("username"));
				person.setAge(rs.getInt("age"));
				return person;
			}
		});
		System.out.println("封装的返回对象 JdbcTemplate: " + jdbcPerson);

		// 填充多个模型对象
		List<JdbcPerson> jdbcPeople = this.jdbcTemplate.query("select id,username,age from person", new RowMapper<JdbcPerson>() {
			@Override
			public JdbcPerson mapRow(ResultSet rs, int rowNum) throws SQLException {
				JdbcPerson person = new JdbcPerson();
				person.setId(rs.getInt("id"));
				person.setUsername(rs.getString("username"));
				person.setAge(rs.getInt("age"));
				return person;
			}
		});
		System.out.println("封装多个对象：\n" + jdbcPeople.toString());

		// 上面两种获取方式可以使用下面的替换，效果更好
		jdbcPeople = this.jdbcTemplate.query("select id,username,age from person", new JdbcPersonMapper());
		System.out.println("封装多个对象：\n" + jdbcPeople.toString());


	}

	public static final class JdbcPersonMapper implements RowMapper<JdbcPerson> {
		@Override
		public JdbcPerson mapRow(ResultSet rs, int rowNum) throws SQLException {
			JdbcPerson person = new JdbcPerson();
			person.setId(rs.getInt("id"));
			person.setUsername(rs.getString("username"));
			person.setAge(rs.getInt("age"));
			return person;
		}
	}

	public void update() {
		//利用update执行插入单条操作
		// 批量插入需要自己构造values
		int wangwu = this.jdbcTemplate.update("insert into person(username,age) values (?,?)", "wangwu", 20);
		System.out.println("利用update执行插入单条操作 reuslt: " + wangwu);

		// 更新操作
		int lisi = this.jdbcTemplate.update("update person set age = ? where username = ?", new Object[]{20, "lisi"});
		System.out.println("更新李四的年龄 result: " + lisi);

		// 删除王五
		wangwu = this.jdbcTemplate.update("delete from person where username = ?", "wangwu");
		System.out.println("删除所有的王五记录 result: " + wangwu);
	}

	public void create() {
		//execute 可以执行任意sql
		System.out.println("执行创建user表");
		this.jdbcTemplate.execute("create table user(id int,username varchar(20))");
		Integer count = this.jdbcTemplate.queryForObject("select count(id) from user", Integer.class);
		System.out.println("user表总记录数: " + count);
	}

	public void creatReturingAutoCreatementKey() {
		String sql = "insert into person(username,age) values (?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
				ps.setString(1, "王五");
				ps.setInt(2, 20);
				return ps;
			}
		}, keyHolder);
		System.out.println("插入一条数据，返回当前的主键值: " + keyHolder.getKey());
	}


}


