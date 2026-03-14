package com.inventory.main;

import com.inventory.dao.ProductDAO;
import com.inventory.dao.ProductHQLDAO;
import com.inventory.entity.Product;

public class MainApp {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        // Insert products
        Product p1 = new Product("Laptop", "Gaming Laptop", 85000, 5);
        Product p2 = new Product("Mouse", "Wireless Mouse", 700, 20);

        dao.insertProduct(p1);
        dao.insertProduct(p2);

        // Retrieve product
        Product product = dao.getProduct(1);
        if(product != null){
            System.out.println("Product Name: " + product.getName());
        }

        // Update product
        dao.updateProduct(1, 80000, 4);

        // Delete product
        dao.deleteProduct(2);
        //ProductDAO dao = new ProductDAO();

        dao.insertProduct(new Product("Laptop","Electronics",50000,10));
        dao.insertProduct(new Product("Mouse","Electronics",500,50));
        dao.insertProduct(new Product("Keyboard","Electronics",1200,30));
        dao.insertProduct(new Product("Notebook","Stationary",100,100));
        dao.insertProduct(new Product("Pen","Stationary",20,200));
        dao.insertProduct(new Product("Headphones","Electronics",2500,15));
        dao.insertProduct(new Product("Bag","Accessories",1500,8));
        dao.insertProduct(new Product("Charger","Electronics",800,25));
        
        ProductHQLDAO hql = new ProductHQLDAO();

        hql.sortPriceAscending();
        hql.sortPriceDescending();
        hql.sortQuantityDesc();

        hql.firstThreeProducts();
        hql.nextThreeProducts();

        hql.countProducts();
    }
    
}