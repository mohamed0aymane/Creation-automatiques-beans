package org.mql.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mql.java.models.Customer;
import org.mql.java.models.Product;
import org.mql.java.xml.AnnotationConfigApplicationContext;

class AnnotationConfigApplicationContextTest {

    private AnnotationConfigApplicationContext context;
    
    @BeforeEach
    void setup() {
        // Initialisation correcte avec les classes cibles
        context = new AnnotationConfigApplicationContext(Product.class, Customer.class);
        context.load();
    }
    
    @Test
    void testProductCreation() {
        // Vérification de la création des produits
        assertNotNull(context.getBean("Product1", Product.class), "Product1 doit exister");
        assertNotNull(context.getBean("Product2", Product.class), "Product2 doit exister");
        assertNotNull(context.getBean("Product3", Product.class), "Product3 doit exister");
        
        // Vérification des valeurs des champs
        Product product = context.getBean("Product1", Product.class);
        assertTrue(product.getId() > 0, "L'ID doit être positif");
        assertFalse(product.getName().isEmpty(), "Le nom ne doit pas être vide");
        assertTrue(product.getPrice() > 0, "Le prix doit être positif");
    }
    
    @Test
    void testCustomerCreation() {
        // Vérification de la création des clients
        assertNotNull(context.getBean("Customer1", Customer.class), "Customer1 doit exister");
        
        // Vérification des valeurs des champs
        Customer customer = context.getBean("Customer1", Customer.class);
        assertTrue(customer.getId() > 0, "L'ID client doit être positif");
        assertFalse(customer.getName().isEmpty(), "Le nom complet ne doit pas être vide");
    }
    
    @Test
    void testBeanCount() {
        assertEquals(5, context.getBeans(Product.class).size(), 
            "Doit avoir 3 instances de Product");
        assertEquals(4, context.getBeans(Customer.class).size(), 
            "Doit avoir 1 instance de Customer");
    }
    
    @Test
    void testPrintCustomerDetails() {
        // Version améliorée de l'affichage des clients
        System.out.println("\nDétails des clients:");
        context.getBeans(Customer.class).forEach(c -> {
            Customer cust = (Customer) c;
            System.out.printf("Client [id=%d, nom=%s]%n", 
                cust.getId(), cust.getName());
        });
    }
}