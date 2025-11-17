package app.dao;

import app.model.Product;
import app.model.ProductDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductDAO_impl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Product insert(Product product) {
        getSession().save(product); // cascade هيحفظ الـ details تلقائي
        return product;
    }


    @Override
    public Product findById(int id) {
        return getSession().get(Product.class, id);
    }

    @Override
    public Product deletebyId(int id) {
        Product p = findById(id);
        if (p != null) {
            getSession().delete(p);
        }
        return p;
    }

    @Override
    public Product update(Product product) {
        getSession().update(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return getSession()
                .createQuery("from Product", Product.class)
                .getResultList();
    }
}
