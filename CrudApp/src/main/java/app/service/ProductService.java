package app.service;

import app.model.Product;

import java.util.List;

public interface ProductService {
    Product insert(Product p);
    Product findById(int id);
    Product update(Product p);
    Product deletebyId(int id);
    List<Product> getAllProducts();
}

