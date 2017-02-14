package org.rudra.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rudra.modelClass36.Vote;
import org.rudra.modelClass36.Voter;

public class HibernateTester {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();

		Voter voter = new Voter();
		voter.setVoter_id(1);
		voter.setVoter_name("ansh");
		voter.setVoter_age(24);
		
		Vote vote = new Vote();
		// vote id is generated , as per the configuration given in hbm file , it will same as voter id.
		vote.setParty_name("XYZ");
		vote.setVoting_date(new Date());
		vote.setVoter(voter);
		
		/*on uncommenting this section we will get exception , because we already have one vote from the same voter.
		 * 
		 * Vote vote2 = new Vote();
		vote2.setParty_name("XYZ");
		vote2.setVoting_date(new Date());
		vote2.setVoter(voter);
		
		session1.save(vote2);
		*/
		
		session1.save(voter);
		session1.save(vote);
		
		session1.getTransaction().commit();
		session1.close();
		sessionFactory.close();
	}
}