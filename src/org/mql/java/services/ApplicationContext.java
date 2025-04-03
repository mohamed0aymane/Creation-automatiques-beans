package org.mql.java.services;

import java.util.List;

public interface ApplicationContext {
	public void load();
	public <T> List<T> getBeans(Class<T> cls);
	public <T> T getBean(String name,Class<T> cls);

}
