package com.dhb.sp3demo.dao;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDaoTest {


	@BeforeClass
	public static void init(){
		
		ApplicationContext  context = new ClassPathXmlApplicationContext();
	}
	
	@Test
	public void testUserDao(){
		
		log.debug("test");
		
	}
	
}
