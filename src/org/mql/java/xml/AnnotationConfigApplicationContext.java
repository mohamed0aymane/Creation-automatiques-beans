package org.mql.java.xml;


import org.mql.java.services.AbstractApplicationContext;

public class AnnotationConfigApplicationContext extends AbstractApplicationContext {
	private Class<?>[] configClasses;
	
	public AnnotationConfigApplicationContext(Class<?>... configClasses) {
		super();
		this.configClasses= configClasses;
	}

	@Override
	public void load() {
		AnnotationContextLoader loader=new AnnotationContextLoader(
				configClasses,(name,bean)->addBean(name,bean));
		
		loader.start();
		try {
	            loader.join();
	    } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	            throw new RuntimeException("Loading interrupted", e);
	    }
		
	}

}
