package com.inventory.main;

import com.inventory.dao.ProductDAO;
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

    }
}