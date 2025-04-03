package org.mql.java.xml;

import java.lang.reflect.Field;
import java.util.function.BiConsumer;

import org.mql.java.annotations.Bean;
import org.mql.java.annotations.DoubleValue;
import org.mql.java.annotations.IntValue;
import org.mql.java.annotations.StringValue;

public class AnnotationContextLoader extends Thread {
	private Class<?> targets[];
	private BiConsumer<String,Object> consumer;
	
	public AnnotationContextLoader(Class<?>[] targets, BiConsumer<String, Object> consumer) {
		super();
		this.targets = targets;
		this.consumer = consumer;
	}

	@Override
	public void run() {
		for(Class<?> target:targets) {
			if(target.isAnnotationPresent(Bean.class)) {
				Bean beanAnnotation=target.getAnnotation(Bean.class);
				//nombre d'instance a creer (valeur de l'annotation
				int count=beanAnnotation.value();
				//creer le nombre demande d'instances
				for(int i=1;i<=count;i++) {
					try {
						//cree une nouvelle instance de la classe
						Object instance=target.getDeclaredConstructor().newInstance();
						//traitements des champs
						Field[] fields=target.getDeclaredFields();
						for(Field field:fields) {
							field.setAccessible(true);
							
							if(field.isAnnotationPresent(IntValue.class)) {
								IntValue annotation=field.getAnnotation(IntValue.class);
								//generer un entier aleatoire entre min et max
								int randomInt = annotation.min() + (int)(Math.random() * (annotation.max() - annotation.min() + 1));
								field.set(instance, randomInt);
							}
							else if(field.isAnnotationPresent(DoubleValue.class)) {
								DoubleValue annotation=field.getAnnotation(DoubleValue.class);
								//generer un entier aleatoire entre min et max
								double randomDouble = annotation.min() + (Math.random() * (annotation.max() - annotation.min()));
								field.set(instance,randomDouble);
							}
							else if(field.isAnnotationPresent(StringValue.class)) {
								StringValue annotation=field.getAnnotation(StringValue.class);
								//generer un entier aleatoire entre min et max
								
								String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
							    StringBuilder sb = new StringBuilder();
							    for(int j = 0; j < annotation.size(); j++) {
							        sb.append(chars.charAt((int)(Math.random() * chars.length())));
							    }
							    field.set(instance,sb.toString()); 
							}
						}
						
								
						//envoie l'instance au consommateur(nom=NomClasse +numero)
						consumer.accept(target.getSimpleName()+i, instance);
					} catch (Exception e) {
						System.err.println("Erreur création bean " + target.getSimpleName() + 
	                            " n°" + i + ": " + e.getMessage());
					}
					
				}
				
				
			}
		}
	}

}
