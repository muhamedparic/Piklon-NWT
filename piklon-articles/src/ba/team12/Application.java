package ba.team12;

import java.util.GregorianCalendar;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Location.class)
									.addAnnotatedClass(Category.class)
									.addAnnotatedClass(Article.class)
									.addAnnotatedClass(ExtraInfoType.class)
									.addAnnotatedClass(ExtraInfo.class)
									.addAnnotatedClass(Image.class)
									.buildSessionFactory();
		
		try {
			
			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Location[] location = new Location[3];
			location[0] = new Location("Sarajevo");
			location[1] = new Location("Mostar");
			location[2] = new Location("Tuzla");
			session.save(location[0]);
			session.save(location[1]);
			session.save(location[2]);
			
			Category[] category = new Category[3];
			category[0] = new Category("Automobili");
			category[1] = new Category("Računari");
			category[2] = new Category("Stanovi");
			session.save(category[0]);
			session.save(category[1]);
			session.save(category[2]);
			
			ExtraInfoType[] extraInfoType = new ExtraInfoType[3];
			extraInfoType[0] = new ExtraInfoType("Kilometraža", category[0]);
			extraInfoType[1] = new ExtraInfoType("GHz", category[1]);
			extraInfoType[2] = new ExtraInfoType("Broj kvadrata", category[2]);
			session.save(extraInfoType[0]);
			session.save(extraInfoType[1]);
			session.save(extraInfoType[2]);
			
			Article[] article = new Article[3];
			article[0] = new Article(1L, "Volkswagen Golf 5 u dobrom stanju", 12000, Condition.Used, location[2], category[0], new GregorianCalendar(2018, 3, 15).getTime());
			article[1] = new Article(5L, "Intel core i5-8500/nVidia GTX 1060", 2000, Condition.New, location[1], category[1], new GregorianCalendar(2018, 2, 11).getTime());
			article[2] = new Article(751L, "Stan na Bjelavama 70m2 opremljen", 150000, Condition.Used, location[0], category[2], new GregorianCalendar(2017, 11, 25).getTime());
			session.save(article[0]);
			session.save(article[1]);
			session.save(article[2]);
			
			Image[] image = new Image[3];
			image[0] = new Image(article[0], null);
			image[1] = new Image(article[1], null);
			image[2] = new Image(article[2], null);
			session.save(image[0]);
			session.save(image[1]);
			session.save(image[2]);
			
			ExtraInfo[] extraInfo = new ExtraInfo[3];
			extraInfo[0] = new ExtraInfo(article[0], extraInfoType[0], "140000");
			extraInfo[1] = new ExtraInfo(article[1], extraInfoType[1], "3.1");
			extraInfo[2] = new ExtraInfo(article[2], extraInfoType[2], "70");
			session.save(extraInfo[0]);
			session.save(extraInfo[1]);
			session.save(extraInfo[2]);
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
}
