package org.rudra.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.rudra.modelClass18.UserDetails;
import org.rudra.modelClass18.Vehicle;

public class HibernateTester {

	public static void main(String[] args) {
		
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("car");
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("bike");
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setVehicleName("Bus");
		
		UserDetails userDetails1 =  new UserDetails();
		userDetails1.setUserName("abhishek");
		
		userDetails1.getVehicle().add(vehicle1);
		userDetails1.getVehicle().add(vehicle2);
		userDetails1.getVehicle().add(vehicle3);
			
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
		session.persist(userDetails1);
		session.getTransaction().commit();
		session.close();
		
		/** using the sessionFactory to fetch the record by using the primary key , always reuse the session factory obj
		 *  because it is costly to create . 
		 */
		
		session = sessionFactory.openSession();
		
		//From user side.
		userDetails1=null;
		userDetails1 =  session.get(UserDetails.class,1);
		System.out.println("user2 details : "+userDetails1.getUserId());
		System.out.println("user2 details : "+userDetails1.getUserName());
		Iterator<Vehicle> vehiclesOfUser1 = userDetails1.getVehicle().iterator();
		Vehicle vehicle;
		while(vehiclesOfUser1.hasNext()){
		//vehicle1 = session.get(Vehicle.class,vehiclesOfUser2.next().getVehicleId());
		vehicle=vehiclesOfUser1.next();
		System.out.println("vehicle details : "+vehicle.getVehicleId());
		System.out.println("vehicle details : "+vehicle.getVehicleName());
		}
		session.close();
		session.getSessionFactory().close();
		sessionFactory.close();
		
	}

	
}