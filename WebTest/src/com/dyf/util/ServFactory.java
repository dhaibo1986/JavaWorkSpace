package com.dyf.util;

import com.dyf.biz.IUserServ;
import com.dyf.biz.UserServImpl;

public class ServFactory {
	public static IUserServ getUserServ() {
		return new UserServImpl();
	}
}
