package media;

import java.util.Arrays;

public class Photo extends Media {
	
	private String[] authors;
	
	public Photo(String title, int year,String[] authors) {
		super(title, year);
		this.authors = authors;
	}
	
	public Type getType() {
		return Type.PHOTO;
	}

	public String[] getAuthors() {
		return authors;
	}

	public boolean equals(Object o) {
		if(o instanceof Photo) {
			
			Photo e = (Photo) o;
			return super.equals(o) && Arrays.equals(this.authors, e.authors);
		}
		return false;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Photo [" + (authors != null ? "authors=" + Arrays.toString(authors) : "") + "]";
	}
}
