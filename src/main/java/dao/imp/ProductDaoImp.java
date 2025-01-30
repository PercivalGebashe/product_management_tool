package dao.imp;

import dao.ProductDao;
import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class ProductDaoImp implements ProductDao {

    private final SessionFactory sessionFactory;

    public ProductDaoImp(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Product> getAllProducts() {
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            Query<Product> query = session.createQuery("FROM Product", Product.class);
            transaction.commit();
            return query.getResultList();
        }
    }

    @Override
    public Product getProductById(String id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Product.class, UUID.fromString(id));
        }
    }

    @Override
    public void saveProduct(Product product) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void saveAllProducts(List<Product> productList) {
        productList.forEach(this::saveProduct);
    }

    @Override
    public void updateProduct(Product product) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.merge(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(Product product) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
                System.out.println("upig9i");
        }
    }
}
