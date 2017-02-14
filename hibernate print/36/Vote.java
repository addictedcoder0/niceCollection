package org.rudra.modelClass36;

import java.util.Date;

public class Vote {

	private int vote_id;
	private String party_name;
	private Date voting_date;
	private Voter voter;
	
	public Vote(){
		
	}
	
	public int getVote_id() {
		return vote_id;
	}
	public void setVote_id(int vote_id) {
		this.vote_id = vote_id;
	}
	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	public Date getVoting_date() {
		return voting_date;
	}
	public void setVoting_date(Date voting_date) {
		this.voting_date = voting_date;
	}
	public Voter getVoter() {
		return voter;
	}
	public void setVoter(Voter voter) {
		this.voter = voter;
	}
	
	
	
	
}
