package com.dhb.sp3demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhb.sp3demo.dao.LoginLogDao;
import com.dhb.sp3demo.dao.UserDao;
import com.dhb.sp3demo.domain.LoginLog;
import com.dhb.sp3demo.domain.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;
	
	public boolean hasMatchUser(String userName,String password){
		int matchCount = this.userDao.getMatchCount(userName, password);
		return matchCount>0;
	}
	
	public User findUserByUserName(String userName){
		return this.userDao.findUserByUserName(userName);
	}
	
	public void loginSuccess(User user){
		user.setCredits(5+user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserid());
		loginLog.setIp(user.getLasip());
		loginLog.setLoginDate(user.getLastVisit());
		this.userDao.updateLoginInfo(user);
		this.loginLogDao.insertLoginLog(loginLog);
	}
}
