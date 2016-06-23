package com.dyf.biz;

import java.util.List;

import com.dyf.domain.PageBean;
import com.dyf.domain.UserBean;

public interface IUserServ {
	
	public List<UserBean> getAllByPage(PageBean pageBean)throws Exception;
	
	public boolean check(UserBean userBean) throws Exception;

	public boolean userInsert(UserBean userBean) throws Exception;

	public boolean userDelete(int id) throws Exception;

	public boolean userUpdate(UserBean userBean) throws Exception;

	public List<UserBean> LoadById(int id) throws Exception;
}
