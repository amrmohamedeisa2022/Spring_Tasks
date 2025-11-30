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

    @Override
    public Product insert(Product product) {
       Session session = sessionFactory.getCurrentSession();
       session.save(product);
       return product;
    }




    @Override
    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> query = session.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Override
    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    @Override
    public Product delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        if (product != null) {
            session.delete(product);
        }
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
        return product;
    }
}
