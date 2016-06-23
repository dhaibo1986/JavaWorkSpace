package com.dyf.util;

import com.dyf.dao.IUserDao;
import com.dyf.dao.UserDaoImpl;

public class DaoFactory {
public static IUserDao getUserDao(){
	return new UserDaoImpl();
}
}
