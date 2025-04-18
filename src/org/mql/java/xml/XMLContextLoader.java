package org.mql.java.xml;

import java.lang.reflect.Field;
import java.util.function.BiConsumer;

import org.mql.java.annotations.Data;

public class XMLContextLoader extends Thread {
	private Object target;
	private BiConsumer<String, Object> consumer;

	public XMLContextLoader(Object target, BiConsumer<String, Object> consumer) {
		this.target = target;
		this.consumer = consumer;
	}

	@Override
	public void run() {
		try {
			Data dataAnnotation = target.getClass().getAnnotation(Data.class);
			if (dataAnnotation == null || dataAnnotation.source().isEmpty()) {
				throw new IllegalArgumentException("L'annotation @Data(source) est requise sur la classe cible !");
			}
			String source = dataAnnotation.source();
			XMLNode root = new XMLNode(source);
			XMLNode[] beans = root.children();

			for (XMLNode bean : beans) {
				String classBean = bean.attribute("class");
				String nameBean = bean.attribute("name");
				Object instance = Class.forName(classBean).getDeclaredConstructor().newInstance();

				// 🔄 Traiter toutes les balises <property>
				XMLNode[] properties = bean.children(); 
				for (XMLNode property : properties) {
					if (!property.getName().equals("property")) continue;

					String propertyName = property.attribute("name");
					String propertyValue = property.attribute("value");

					Field field = instance.getClass().getDeclaredField(propertyName);
					field.setAccessible(true);

					if (field.getType().equals(int.class)) {
						field.set(instance, Integer.parseInt(propertyValue));
					} else if (field.getType().equals(double.class)) {
						field.set(instance, Double.parseDouble(propertyValue));
					} else if (field.getType().equals(String.class)) {
						field.set(instance, propertyValue);
					}
				}

				// ✅ Ajouter le bean au contexte
				consumer.accept(nameBean, instance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


/*package org.mql.java.xml;

import java.lang.reflect.Field;
import java.util.function.BiConsumer;

import org.mql.java.annotations.Data;
import org.mql.java.models.Product;

public class XMLContextLoader  extends Thread{
	private Object target;
	private BiConsumer<String, Object> consumer;
	public XMLContextLoader(Object target, BiConsumer<String, Object> consumer) {
		super();
		this.target = target;
		this.consumer = consumer;
	}
	
	@Override
	public void run() {
		try {
			Data dataAnnotation = target.getClass().getAnnotation(Data.class);
			if (dataAnnotation == null || dataAnnotation.source().isEmpty()) {
			    throw new IllegalArgumentException("L'annotation @Data(source) est requise sur la classe cible !");
			}
			String source=dataAnnotation.source();
			
			XMLNode root=new XMLNode(source);
			XMLNode[] beans=root.children();
		
				for (XMLNode bean : beans) {
					String classBean = bean.attribute("class");
					String nameBean  = bean.attribute("name");
					Object instance  = Class.forName(classBean).getDeclaredConstructor().newInstance();
	
							XMLNode property = bean.child("property");
							
							String propertyName = property.attribute("name");
							Field field = instance.getClass().getDeclaredField(propertyName);
							field.setAccessible(true);
							
							if(field.getType().equals(int.class)) {
								int propertyValue = property.intAttribute("value");
								field.set(instance, propertyValue);
		
							}
							
							else if(field.getType().equals(String.class)) {
								String propertyValue = property.attribute("value");
								field.set(instance, propertyValue);
								
							}
							
							else if(field.getType().equals(double.class)) {
								double propertyValue = Double.parseDouble(property.attribute("value")) ;
								field.set(instance, propertyValue);
							}
							//stocker l'instance du bean dans le contexte
							consumer.accept(nameBean,instance);
						}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

}*/
