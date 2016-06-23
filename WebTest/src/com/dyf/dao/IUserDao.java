package com.dyf.dao;

import java.util.List;

import com.dyf.domain.UserBean;

public interface IUserDao {
	public List<UserBean> getByExample(UserBean userBean, int... params)
			throws Exception;

	public int getAllRowsNum(UserBean userBean) throws Exception;

	public List<UserBean> checkUser(UserBean userBean)throws Exception;
	
	public boolean userInsert(UserBean userBean) throws Exception;

	public boolean userDelete(int id) throws Exception;

	public boolean userUpdate(UserBean userBean) throws Exception;

	public List<UserBean> LoadById(int id) throws Exception;
}
