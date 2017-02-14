package org.rudra.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass20.FourWheeler;
import org.rudra.modelClass20.TwoWheeler;
import org.rudra.modelClass20.Vehicle;

public class HibernateTester {

	public static void main(String[] args) {
		
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("car");
		
		TwoWheeler vehicle2 = new TwoWheeler();
		vehicle2.setVehicleName("bike");
		vehicle2.setSteeringHandle("Yamaha Handle");
		
		FourWheeler vehicle3 = new FourWheeler();
		vehicle3.setVehicleName("Bus");
		vehicle3.setSteeringWheel("Porche");
		
	/*	UserDetails userDetails1 =  new UserDetails();
		userDetails1.setUserName("abhishek");
		
		userDetails1.getVehicle().add(vehicle1);
		userDetails1.getVehicle().add(vehicle2);
		userDetails1.getVehicle().add(vehicle3);*/
			
		/**
		 * It reads the configuration file (cfg) and build the session factory object based on the configuration provided
		 */
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		/**
		 * here we are using persist() , which search for any cascade dependency of the saved object .
		 * and save those entities automatically without calling the save() again . 
		 */
		session.save(vehicle1);
		session.save(vehicle2);
		session.save(vehicle3);
		session.getTransaction().commit();
		session.close();
		
		/** using the sessionFactory to fetch the record by using the primary key , always reuse the session factory obj
		 *  because it is costly to create . 
		 */
		
	//	session = sessionFactory.openSession();
		
	//	session.close();
		session.getSessionFactory().close();
		sessionFactory.close();
		
	}

	
}