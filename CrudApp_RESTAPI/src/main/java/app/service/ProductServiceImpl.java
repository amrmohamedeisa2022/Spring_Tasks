package app.service;

import app.dao.ProductDAO;
import app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    @Transactional
    public Product addProduct(Product product) {
        if(product==null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        productDAO.insert(product);
        return product;
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProductById(int id) {
        return productDAO.findById(id);
    }

    @Override
    @Transactional
    public Product updateProduct(Product product) {
        productDAO.update(product);
        return product;
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        productDAO.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProductByName(String name) {
        return productDAO.findByName(name);
    }
}
