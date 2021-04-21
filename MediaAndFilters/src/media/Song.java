package media;

import media.filters.HasDuration;
import media.filters.HasGenre;

public class Song extends Media implements HasDuration, HasGenre{
	private int duration;
	private String genre;
	private String singer;
	
	public Song(String title, int year,String singer, int duration, String genre) {
		super(title, year);
		this.genre = genre;
		this.singer = singer;
		this.duration = duration;
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
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	public Type getType() {
		return Type.SONG;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Song) {
			
			Song e = (Song) o;
			return super.equals(o) && this.genre == e.genre && this.singer == e.singer && this.duration == e.duration;
		}
		return false;
	}

	
	@Override
	public String toString() {
		return "Song [duration=" + duration + ", " + (genre != null ? "genre=" + genre + ", " : "")
				+ (singer != null ? "singer=" + singer : "") + "]";
	}
}
