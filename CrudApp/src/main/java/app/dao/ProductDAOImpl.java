package app.dao;

import app.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void insert(Product product) {
        getCurrentSession().saveOrUpdate(product);
    }

    @Override
    public List<Product> getAllProducts() {
        Query<Product> query = getCurrentSession().createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(int id) {
        return getCurrentSession().get(Product.class, id);
    }

    @Override
    public void update(Product product) {
        getCurrentSession(). saveOrUpdate(product);
    }

    @Override
    public void deleteById(int id) {
        Product product = getCurrentSession().get(Product.class, id);
        if (product != null) {
            getCurrentSession().delete(product);
        }
    }
}
