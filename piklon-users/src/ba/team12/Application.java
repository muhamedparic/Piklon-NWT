package ba.team12;
 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class Application {
 
    public static void main(String[] args) {
       
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(User.class)
                                    .buildSessionFactory();
       
        try {
           
            Session session = factory.getCurrentSession();
           
            session.beginTransaction();
           
            User user = new User("Muhamed","Paric","muha","pare");
            session.save(user);
            session.getTransaction().commit();
            
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
       
    }
 
}