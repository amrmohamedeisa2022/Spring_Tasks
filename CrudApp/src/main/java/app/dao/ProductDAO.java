package app.dao;

import app.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductDAO {

    Product insert(Product product);
    Product delete(int id);
    List<Product> getAllProducts();
    Product getProductById(int id);
    Product updateProduct(Product product);
}
