package media;

import java.util.Arrays;

import media.filters.HasDuration;
import media.filters.HasGenre;

public class Film extends Media implements HasDuration,HasGenre{
	private String[] actors;
	private String director;
	private int duration;
	private String genre;
	
	public Film(String title, int year,  String director,  int duration, String[] actors, String genre) {
		super(title, year);
		this.actors = actors;
		this.director = director;
		this.duration = duration;
		this.genre = genre;
	}
	
	public String[] getActors() {
		return actors;
	}
	public void setActors(String[] actors) {
		this.actors = actors;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Film) {
			
			Film e = (Film) o;
			return super.equals(o) && Arrays.equals(this.actors, e.actors) && this.director == e.director && this.duration == e.duration && this.genre == e.genre;
		}
		return false;
	}
	
	public Type getType() {
		return Type.FILM;
	}
	
	@Override
	public String toString() {
		return "Film [" + (actors != null ? "actors=" + Arrays.toString(actors) + ", " : "")
				+ (director != null ? "director=" + director + ", " : "") + "duration=" + duration + ", "
				+ (genre != null ? "genre=" + genre : "") + "]";
	}
	
}
