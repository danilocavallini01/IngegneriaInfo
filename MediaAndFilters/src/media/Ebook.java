package media;

import java.util.Arrays;

import media.filters.HasGenre;

public class Ebook extends Media implements HasGenre{
	private String[] authors;
	private String genre;
	
	public Ebook(String title, int year, String[] authors, String genre) {
		super(title, year);
		this.authors = authors;
		this.genre = genre;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Ebook) {
			
			Ebook e = (Ebook) o;
			return super.equals(o) && Arrays.equals(this.authors, e.authors) && this.genre == e.genre;
		}
		return false;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public Type getType() {
		return Type.EBOOK;
	}

	@Override
	public String toString() {
		return "Ebook [" + (authors != null ? "authors=" + Arrays.toString(authors) + ", " : "")
				+ (genre != null ? "genre=" + genre : "") + "]";
	}
	
}
