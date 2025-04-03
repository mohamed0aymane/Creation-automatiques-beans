package org.mql.java.services;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;


public abstract class AbstractApplicationContext implements ApplicationContext {


	private Hashtable<String, Object> beans= new Hashtable<String,Object>();
	
	@Override
	public <T> List<T> getBeans(Class<T> cls) {
		List<T> result=new Vector<>();
		for(Object bean:beans.values()) {
			if( bean != null && cls.isInstance(bean)){
				result.add(cls.cast(bean));
			}
		}
		return result;
	}

	@Override
	public <T> T getBean(String name, Class<T> cls) {
		if(name !=null && beans !=null) {
		    Object bean = beans.get(name);
		    if(bean !=null && cls.isInstance(bean)) {
		    	return cls.cast(bean);
		    }
		}
		return null;
	}
	
	public void addBean(String name,Object bean) {
		if(!beans.containsKey(name) && bean!=null ) {
			beans.put(name, bean);
		}
		
	}

}
