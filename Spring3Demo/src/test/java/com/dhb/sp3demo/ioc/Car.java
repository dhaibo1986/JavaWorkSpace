package com.dhb.sp3demo.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

	private String brand;
	private String color;
	private int maxSpeed;
	
	private BeanFactory beanFactory;
	private String beanName;
	
	
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getBrand() {
		return brand;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public String getBeanName() {
		return beanName;
	}

	public Car(){
		System.out.println("调用构造函数");
	}
	
	public void setBrand(String brand){
		System.out.println("调用setBrand 设置属性");
		this.brand = brand;
	}
	
	public void introduce(){
		System.out.println("brand:"+this.brand +
				"; color:"+this.color+";maxSpeed:"+this.maxSpeed);		
	}
	
	public void myInit(){
		System.out.println("调用init-method所指的myInit(),将maxSpeed设置为240");
		this.maxSpeed = 240;
	}
	
	public void myDestory(){
		System.out.println("调用destory-method所指的myDestory()");
	}
	
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("调用DisposableBean.destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("调用InitializingBean.afterPropertiesSet()");
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("调用BeanNameAware.setBeanName()");
		this.beanName = name;
		
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("调用BeanFactoryAware.setBeanFactory()");
		this.beanFactory = beanFactory;
	}

}
