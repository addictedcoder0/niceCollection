package org.rudra.modelClass34;

import java.util.Set;

public class Actor {

	private int actor_id;
	private String actor_name;
	private Set<Movie> movieSet;
	public Actor(){
		
	}
	public int getActor_id() {
		return actor_id;
	}
	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}
	public String getActor_name() {
		return actor_name;
	}
	public void setActor_name(String actor_name) {
		this.actor_name = actor_name;
	}
	public Set<Movie> getMovieSet() {
		return movieSet;
	}
	public void setMovieSet(Set<Movie> movieSet) {
		this.movieSet = movieSet;
	}
	
}
