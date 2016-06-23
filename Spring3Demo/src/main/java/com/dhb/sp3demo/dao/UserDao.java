package com.dhb.sp3demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.dhb.sp3demo.domain.User;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getMatchCount(String userName,String password){
		String sqlStr = "SELECT count(*) FROM t_user "+
				" WHERE user_name = ? and password = ?";
		log.debug("exec sql:"+sqlStr);
		return this.jdbcTemplate.queryForObject(sqlStr,
				new Object[]{userName,password},Integer.class);
		
	}
	
	public User findUserByUserName(String userName){
		final User user = new User();
		String sqlStr = "SELECT user_id,user_name,credits "+
				" FROM t_user WHERE user_name = ?";
		this.jdbcTemplate.query(sqlStr, new Object[]{userName},
				new RowCallbackHandler(){

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						user.setUserid(rs.getInt("user_id"));
						user.setUserName(rs.getString("user_name"));
						user.setCredits(rs.getInt("credits"));
					}
				
		});
		return user;
	}
	
	public void updateLoginInfo(User user){
		String sqlStr = " UPDATE t_user SET lastvisit=?,lastip=?,credits=? "+
				" WHERE user_id = ?";
		this.jdbcTemplate.update(sqlStr,new Object[]{
				user.getLastVisit(),user.getLasip(),user.getCredits(),user.getUserid()
		});
	}
}
