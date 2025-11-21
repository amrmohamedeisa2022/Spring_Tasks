package app.dao;

import app.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductDAO {

    void insert(Product product);

    Product findById(int id);

    void deleteById(int id);

    void update(Product product);

    List<Product> getAllProducts();
}
