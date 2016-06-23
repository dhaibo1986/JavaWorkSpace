package com.dhb.sp3demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.dhb.sp3demo.domain.User;

//spring 3.2与junit集成 不支持junit4.5以下的版本
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-service.xml",
		"classpath:applicationContext-dao.xml"})
@TestExecutionListeners(listeners = 
{DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class})
public class TestUserService {

	@Autowired
	private UserService userService;
	
	@Test
	public void hasMatchUser(){
		boolean b1 = this.userService.hasMatchUser("admin", "123456");
		boolean b2 = this.userService.hasMatchUser("admin", "1111");
		assertTrue(b1);
	}
	
	@Test
	public void findUserByUserName(){
		User user = this.userService.findUserByUserName("admin");
		assertEquals(user.getUserName(), "admin");
	}
}
