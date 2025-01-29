import dao.LoginDao;
import dao.imp.LoginDaoImp;
import org.hibernate.SessionFactory;
import util.HibernateUtil;
import util.TomcatServerUtil;

public class App {

    public static void run(){
        TomcatServerUtil.startServer();
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        LoginDao loginDao= new LoginDaoImp(sessionFactory);




    }
}
