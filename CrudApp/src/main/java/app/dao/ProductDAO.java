package app.dao;

import app.model.Product;

import java.util.List;

public interface ProductDAO {

    public Product insert(Product product);
    Product findById(int id);
    Product deletebyId(int id);
    Product update(Product product);
    List<Product> getAllProducts();

}
