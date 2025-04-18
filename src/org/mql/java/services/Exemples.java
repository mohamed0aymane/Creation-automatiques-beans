package org.mql.java.services;

import java.util.List;

import org.mql.java.models.Customer;
import org.mql.java.models.Invoice;
import org.mql.java.models.Product;

public class Exemples {
	public Exemples() {
		exp01();
	}
	
	void exp01() {
		 // Créer une instance du contexte par défaut
        DefaultApplicationContext context = new DefaultApplicationContext();

        // Charger les beans
        context.load();

        // Récupérer tous les clients
        List<Customer> customers = context.getBeans(Customer.class);
        System.out.println("Liste des clients :");
        for (Customer c : customers) {
            System.out.println(c);
        }

        // Récupérer tous les produits
        List<Product> products = context.getBeans(Product.class);
        System.out.println("\nListe des produits :");
        for (Product p : products) {
            System.out.println(p);
        }

        // Récupérer toutes les factures
        List<Invoice> invoices = context.getBeans(Invoice.class);
        System.out.println("\nListe des factures :");
        for (Invoice i : invoices) {
            System.out.println(i);
        }
    }
	
	
	public static void main(String[] args) {
		new Exemples();
	}

}
