package org.rudra.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.rudra.modelClass17.UserDetails;
import org.rudra.modelClass17.Vehicle;

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
		UserDetails userDetails2 =  new UserDetails();
		userDetails2.setUserName("rudra");
		UserDetails userDetails3 =  new UserDetails();
		userDetails3.setUserName("abhishek");
		userDetails1.getVehicle().add(vehicle1);
		userDetails2.getVehicle().add(vehicle2);
		userDetails2.getVehicle().add(vehicle1);
		userDetails1.getVehicle().add(vehicle3);
		vehicle1.getUserList().add(userDetails1);
		vehicle1.getUserList().add(userDetails2);
		vehicle2.getUserList().add(userDetails2);
		
		/**
		 * It reads the configuration file (cfg) and build the session factory object based on the configuration provided
		 */
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails1);
		session.save(userDetails2);
		session.save(userDetails3);
		session.save(vehicle1);
		session.save(vehicle2);
		session.save(vehicle3);
		session.getTransaction().commit();
		session.close();
		
		/** using the sessionFactory to fetch the record by using the primary key , always reuse the session factory obj
		 *  because it is costly to create . 
		 */
		
		session = sessionFactory.openSession();
		
		//From user side.
		userDetails2=null;
		userDetails2 =  session.get(UserDetails.class,2);
		System.out.println("user2 details : "+userDetails2.getUserId());
		System.out.println("user2 details : "+userDetails2.getUserName());
		Iterator<Vehicle> vehiclesOfUser2 = userDetails2.getVehicle().iterator();
		Vehicle vehicle;
		while(vehiclesOfUser2.hasNext()){
		//vehicle1 = session.get(Vehicle.class,vehiclesOfUser2.next().getVehicleId());
		vehicle=vehiclesOfUser2.next();
		printClientList(vehicle);
		System.out.println("vehicle details : "+vehicle.getVehicleId());
		System.out.println("vehicle details : "+vehicle.getVehicleName());
		}
		vehicle3=session.get(Vehicle.class,vehicle3.getVehicleId());
		System.out.println(vehicle3.getUserList().toString());
		session.close();
		session.getSessionFactory().close();
		sessionFactory.close();
		
	}

	private static void printClientList(Vehicle vehicle) {
		//from vehicle side
				List<UserDetails> clientList =(List<UserDetails>) vehicle.getUserList();
				for(UserDetails client : clientList){
					System.out.println("client : "+client.getUserName());
				}
	}
}