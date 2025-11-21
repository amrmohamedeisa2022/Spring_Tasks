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
    public void addProduct(Product product) {
        productDAO.insert(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProductById(int id) {
        return productDAO.findById(id);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        productDAO.update(product);
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
}
