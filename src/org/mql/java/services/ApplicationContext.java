package org.mql.java.services;

import java.util.List;

public interface ApplicationContext {
	public void load();
	//<T>:ce qu'on appelle un type generique
	//List<T> indique le type du retour 
	//Ça veut dire que cette méthode est générique : 
	//elle peut fonctionner avec n'importe quel type 
	//que tu lui passeras (par exemple User, Product, String, etc.).
	public <T> List<T> getBeans(Class<T> cls);
	public <T> T getBean(String name,Class<T> cls);

}
/*une interface generique 
 * public class Boite<T> {
    private T contenu;

    public void setContenu(T contenu) {
        this.contenu = contenu;
    }

    public T getContenu() {
        return contenu;
    }
}
*/
