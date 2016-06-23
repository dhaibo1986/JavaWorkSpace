package com.dhb.sp3demo.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		if(beanName.equals("car")){
			Car car = (Car)bean;
			if(car.getColor() == null){
				System.out.println("调用BeanPostProcess.postProcessBeforeInitialization() color 为空，设置为默认颜色");
				car.setColor("黑色");
			}
		}
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		if(beanName.equals("car")){
			Car car = (Car)bean;
			if(car.getMaxSpeed() >= 200){
				System.out.println("调用BeanPostProcess.postProcessAfterInitialization() 设置setMaxSpeed 为200");
				car.setMaxSpeed(200);
			}
		}
		
		return bean;
	}

}
