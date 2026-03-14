package com.inventory.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class ProductHQLDAO {

	public void sortPriceAscending() {

	    Session session = HibernateUtil.getSessionFactory().openSession();

	    Query<Product> q = session.createQuery(
	            "FROM Product ORDER BY price ASC", Product.class);

	    List<Product> list = q.getResultList();

	    for(Product p : list){
	        System.out.println(p.getName() + " " + p.getPrice());
	    }

	    session.close();
	}
	public void sortPriceDescending() {
	    Session session = HibernateUtil.getSessionFactory().openSession();

	    Query<Product> q = session.createQuery(
	        "FROM Product ORDER BY price DESC", Product.class);

	    List<Product> list = q.list();

	    for(Product p : list){
	        System.out.println(p.getName()+" "+p.getPrice());
	    }

	    session.close();
	}
	public void sortQuantityDesc() {

	    Session session = HibernateUtil.getSessionFactory().openSession();

	    Query<Product> q = session.createQuery(
	        "FROM Product ORDER BY quantity DESC", Product.class);

	    List<Product> list = q.list();

	    for(Product p : list){
	        System.out.println(p.getName()+" "+p.getQuantity());
	    }

	    session.close();
	}
	public void firstThreeProducts() {

	    Session session = HibernateUtil.getSessionFactory().openSession();

	    Query<Product> q = session.createQuery("FROM Product", Product.class);

	    q.setFirstResult(0);
	    q.setMaxResults(3);

	    List<Product> list = q.list();

	    for(Product p : list){
	        System.out.println(p.getName());
	    }

	    session.close();
	}
	public void nextThreeProducts() {

	    Session session = HibernateUtil.getSessionFactory().openSession();

	    Query<Product> q = session.createQuery("FROM Product", Product.class);

	    q.setFirstResult(3);
	    q.setMaxResults(3);

	    List<Product> list = q.list();

	    for(Product p : list){
	        System.out.println(p.getName());
	    }

	    session.close();
	}
	public void countProducts() {

	    Session session = HibernateUtil.getSessionFactory().openSession();

	    Query<Long> q = session.createQuery(
	        "SELECT COUNT(*) FROM Product", Long.class);

	    Long count = q.uniqueResult();

	    System.out.println("Total Products: "+count);

	    session.close();
	}
	public void countProductsByDescription()
	{

	    Session session = HibernateUtil.getSessionFactory().openSession();

	    Query<Object[]> q = session.createQuery(
	            "SELECT description, COUNT(*) FROM Product GROUP BY description",
	            Object[].class);

	    List<Object[]> list = q.getResultList();

	    for(Object[] row : list)
	    {
	        System.out.println(row[0] + " " + row[1]);
	    }

	    session.close();
	}
	public void findMinMaxPrice() {

	    Session session = HibernateUtil.getSessionFactory().openSession();

	    Query<Object[]> q = session.createQuery(
	            "SELECT MIN(price), MAX(price) FROM Product",
	            Object[].class);

	    Object[] result = q.getSingleResult();

	    System.out.println("Min Price: " + result[0]);
	    System.out.println("Max Price: " + result[1]);

	    session.close();
	}
	
public void groupByDescription() {

    Session session = HibernateUtil.getSessionFactory().openSession();

    Query<Object[]> q = session.createQuery(
            "SELECT description, COUNT(*) FROM Product GROUP BY description",
            Object[].class);

    List<Object[]> list = q.getResultList();

    for(Object[] row : list){
        System.out.println("Description: " + row[0] + " Count: " + row[1]);
    }

    session.close();
}
public void productsInPriceRange() {

    Session session = HibernateUtil.getSessionFactory().openSession();

    Query<Product> q = session.createQuery(
            "FROM Product WHERE price BETWEEN 500 AND 5000",
            Product.class);

    List<Product> list = q.getResultList();

    for(Product p : list){
        System.out.println(p.getName() + " " + p.getPrice());
    }

    session.close();
}
public void namesStartingWithL() {

    Session session = HibernateUtil.getSessionFactory().openSession();

    Query<Product> q = session.createQuery(
            "FROM Product WHERE name LIKE 'L%'", Product.class);

    List<Product> list = q.getResultList();

    for(Product p : list){
        System.out.println(p.getName());
    }

    session.close();
}
public void namesEndingWithR() {

    Session session = HibernateUtil.getSessionFactory().openSession();

    Query<Product> q = session.createQuery(
            "FROM Product WHERE name LIKE '%r'", Product.class);

    List<Product> list = q.getResultList();

    for(Product p : list){
        System.out.println(p.getName());
    }

    session.close();
}
public void namesContainingTop() {

    Session session = HibernateUtil.getSessionFactory().openSession();

    Query<Product> q = session.createQuery(
            "FROM Product WHERE name LIKE '%top%'", Product.class);

    List<Product> list = q.getResultList();

    for(Product p : list){
        System.out.println(p.getName());
    }

    session.close();
}
public void namesWithLengthFive() {

    Session session = HibernateUtil.getSessionFactory().openSession();

    Query<Product> q = session.createQuery(
            "FROM Product WHERE LENGTH(name) = 5", Product.class);

    List<Product> list = q.getResultList();

    for(Product p : list){
        System.out.println(p.getName());
    }

    session.close();
}

}
