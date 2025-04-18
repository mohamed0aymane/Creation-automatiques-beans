package org.mql.java.xml;

import java.util.List;

import org.mql.java.models.Product;

public class Exemples {
	public Exemples() {
		exp01();
	}
	void exp01() {
		// Créer le contexte
	       XMLApplicationContext context = new XMLApplicationContext();
	       
	       // Charger les beans définis dans beans.xml
	       context.load();
	       
	       // Récupérer tous les beans de type Product
	       List<Product> products = context.getBeans(Product.class);

	       // Afficher les produits
	       if (products.isEmpty()) {
	           System.out.println("Aucun produit trouvé.");
	       } else {
	           System.out.println("Liste des produits chargés depuis XML :");
	           for (Product product : products) {
	               System.out.println(product);
	           }
	       }
	       
	}
	public static void main(String[] args) {
		new Exemples();
		
	}
}