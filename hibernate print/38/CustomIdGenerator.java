package org.rudra.modelClass38;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.IdentityGenerator;


public class CustomIdGenerator extends IdentityGenerator {

 private String defaultPrefix = "EMP";

 private int defaultNumber = 1;

 @Override
	public Serializable generate(SessionImplementor s, Object obj) {
		// via pgpadmin web-portal created a sequence employee38.
	 String pk = null;;
	 try{
		 
		 Connection con = s.connection();
		 Statement st=con.createStatement();
		 ResultSet rs = st.executeQuery("SELECT nextval('employee38')");
		 if(rs.next()){
			pk=defaultPrefix+rs.getInt(1);
		 }
		 
	 }catch(Exception e){
		 return null;
	 }
		return pk;
	}
 
}