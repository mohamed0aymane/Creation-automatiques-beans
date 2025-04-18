package org.mql.java.xml;

import java.util.List;

import org.mql.java.models.Customer;
import org.mql.java.models.Product;

public class Exemples {
	public Exemples() {
		exp02();
	}
	//XMLApplicationContext
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
	//AnnotationConfigApplicationContext
	void exp02() {
		 // Création du contexte en passant les classes annotées @Bean
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                Customer.class, Product.class
        );

        // Chargement des beans
        context.load();

        // Récupération et affichage des beans de type Customer
        List<Customer> customers = context.getBeans(Customer.class);
        System.out.println("==== Liste des Customers ====");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        // Récupération et affichage des beans de type Product
        List<Product> products = context.getBeans(Product.class);
        System.out.println("\n==== Liste des Products ====");
        for (Product product : products) {
            System.out.println(product);
        }
    }
	
	public static void main(String[] args) {
		new Exemples();
		
	}
}