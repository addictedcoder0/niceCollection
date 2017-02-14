package org.rudra.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.rudra.modelClass15.UserDetails;
import org.rudra.modelClass15.Vehicle;

public class HibernateTester {

	public static void main(String[] args) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("bike");
		
		UserDetails userDetails =  new UserDetails();
		userDetails.setUserName("abhishek");
		userDetails.getVehicle().add(vehicle);
		userDetails.getVehicle().add(vehicle2);
		
		/**
		 * It reads the configuration file (cfg) and build the session factory object based on the configuration provided
		 */
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.save(vehicle);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
		
		/** using the sessionFactory to fetch the record by using the primary key , always reuse the session factory obj
		 *  because it is costly to create . 
		 */
		vehicle = null;
		userDetails = null;
		session = sessionFactory.openSession();
		userDetails =  session.get(UserDetails.class,1);
		vehicle = session.get(Vehicle.class,userDetails.getVehicle().iterator().next().getVehicleId());
		System.out.println("user details : "+userDetails.getUserId());
		System.out.println("user details : "+userDetails.getUserName());
		System.out.println("user details : "+userDetails.getVehicle().iterator().next().getVehicleId());
		System.out.println("vehicle details : "+vehicle.getVehicleId());
		System.out.println("vehicle details : "+vehicle.getVehicleName());
		session.close();
		session.getSessionFactory().close();
		sessionFactory.close();
		
	}
}