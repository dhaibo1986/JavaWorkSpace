package com.dhb.sp3demo.ioc;

import java.beans.PropertyDescriptor;

import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
	
	public Object postProcessBeforelnstatiation(Class beanClass,String beanName){
		
		if("car".equals(beanName)){
			System.out.println("InstantiationAwareBeanPostProcessorAdapter.postProcessBeforelnstatiation()");
		}
		return null;
	}


	public boolean postProcessAfterInstantiation(Object bean,String beanName){
		if("car".equals(beanName)){
			System.out.println("InstantiationAwareBeanPostProcessorAdapter.postProcessAfterInstantiation()");
		}
		return true;
	}
	
	public PropertyValues postProcessPropertyValues(
			PropertyValues pvs,PropertyDescriptor[] pds,Object bean,String beanName
			){
		if("car".equals(beanName)){
			System.out.println("InstantiationAwareBeanPostProcessorAdapter.postProcessPropertyValues()");
		}
		return pvs;
	}
}
