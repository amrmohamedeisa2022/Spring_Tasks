package app.dao;

import app.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductDAO {

    void insert(Product product);
    void update(Product product);
    Product findById(int id);
    void deleteById(int id);
    List<Product> getAllProducts();
    Product findByName(String name);
}
