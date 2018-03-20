package ba.team12;

import java.util.GregorianCalendar;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Rating.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(PrivateMessage.class)
                .buildSessionFactory();

		try {
		
			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Rating rating = new Rating(2233L, 2455L, 4, "KEK");
			session.save(rating);
			rating = new Rating(2663L, 2445L, 3, "OMEGALUL");
			session.save(rating);
			rating = new Rating(3763L, 3345L, 1, "ZULUL");
			session.save(rating);
			
			Comment comment = new Comment(null, "this is a comment text", 
					new GregorianCalendar(2018, 3, 15).getTime(), 1678L, 28845L);
			session.save(comment);

			PrivateMessage pm = new PrivateMessage(5555L, 2577L, "hey u stinky", 
					new GregorianCalendar(2018, 3, 15).getTime());
			session.save(pm);
			pm = new PrivateMessage(572L, 2877L, "i mid or feed", 
					new GregorianCalendar(2018, 3, 15).getTime());
			session.save(pm);
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
	}
}
