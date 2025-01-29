package dao.imp;

import dao.LoginDao;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class LoginDaoImp implements LoginDao {

    private final SessionFactory sessionFactory;

    public LoginDaoImp(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        Transaction transaction = null;
        User user = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();

            Query<User> query = session.createQuery("FROM User WHERE email = :email AND password = :password",
                    User.class);
            query.setParameter("email", email);
            query.setParameter("password", password);

            user = query.uniqueResult();
            transaction.commit();

        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return user;
    }
}
