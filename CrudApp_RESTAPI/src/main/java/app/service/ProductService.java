package app.service;

import app.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    Product getProductById(int id);
    Product updateProduct(Product product);
    void deleteProduct(int id);
    List<Product> getAllProducts();
    Product getProductByName(String name);
}

