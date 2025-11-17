package app.service;

import app.dao.ProductDAO;
import app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public Product insert(Product p) {
        return productDAO.insert(p);
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public Product update(Product p) {
        return productDAO.update(p);
    }

    @Override
    public Product deletebyId(int id) {
        return productDAO.deletebyId(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

}
