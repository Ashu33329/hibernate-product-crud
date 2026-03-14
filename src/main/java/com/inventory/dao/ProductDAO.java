package com.inventory.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class ProductDAO {

    // Insert product
    public void insertProduct(Product product) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(product);

        tx.commit();
        session.close();

        System.out.println("Product inserted successfully");
    }

    // Get product by ID
    public Product getProduct(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Product product = session.get(Product.class, id);

        session.close();

        return product;
    }

    // Update product
    public void updateProduct(int id, double price, int quantity) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = session.get(Product.class, id);

        if (p != null) {
            p.setPrice(price);
            p.setQuantity(quantity);
            session.merge(p);
        }

        tx.commit();
        session.close();

        System.out.println("Product updated successfully");
    }

    // Delete product
    public void deleteProduct(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = session.get(Product.class, id);

        if (p != null) {
            session.remove(p);
        }

        tx.commit();
        session.close();

        System.out.println("Product deleted successfully");
    }
}