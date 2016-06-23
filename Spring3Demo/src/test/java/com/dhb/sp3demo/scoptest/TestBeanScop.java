package com.dhb.sp3demo.scoptest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestBeanScop {
	
	public static void main(String ...strings) {
		
		Resource resource = new ClassPathResource("beans.xml",TestBeanScop.class);
		BeanFactory factory = new XmlBeanFactory(resource);
		Car car = (Car) factory.getBean("car");
		car.getColor();
		Car car1 = (Car) factory.getBean("car");
		
		//使用classpath 路径
		ApplicationContext apc = new ClassPathXmlApplicationContext("beans.xml",TestBeanScop.class);
		Car car2 = (Car) factory.getBean("car");
		
		//使用文件系统路径
//		ApplicationContext apc1 = new FileSystemXmlApplicationContext("./beans.xml");
		
	}
}
