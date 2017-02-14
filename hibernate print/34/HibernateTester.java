package org.rudra.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass34.Actor;
import org.rudra.modelClass34.Movie;

public class HibernateTester {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();

		Actor a1 = new Actor();
		a1.setActor_id(1);
		a1.setActor_name("Amir Khan");
		
		Movie m1 =  new Movie();
		m1.setMovie_id(1);
		m1.setMovie_name("Pk");
		
		Movie m2 = new Movie();
		m2.setMovie_id(2);
		m2.setMovie_name("Gajni");
		
		Set<Movie> movies = new HashSet<Movie>();
		movies.add(m1);
		movies.add(m2);
		
		a1.setMovieSet(movies);
	/*
	 * cascade option is used to reflect the same changes across all the child , as done with parent
	 * cascade="all" option saves all the objects associated with the actor , so we don't need to save these movies.
		
		session1.save(m1);
		session1.save(m2);
	*/	
		session1.save(a1);
		
		
		session1.getTransaction().commit();
		session1.close();
		sessionFactory.close();
	}
}