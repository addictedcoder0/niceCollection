package org.rudra.modelClass35;

public class Movie {

	private int movie_id;
	private String movie_name;
	private Actor actor;
	public Movie(){
		
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public Actor getActor() {
		return actor;
	}
	
}
